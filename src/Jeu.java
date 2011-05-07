import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class Jeu {
	
	Plateau p;
	Deck deck;
	int NBjoueur;
	Joueur [] joueur;
	Vector<ZoneRoute>zonesR;
	Vector<ZoneVille>zonesV;
	Vector<Zone_champ_plateau> zonesC;
	int tour;//savoir qui doit jouer, int compris entre 0 et NBjoueur
	
	public Jeu(){
		this.p = new Plateau(143, 143);
		this.deck = new Deck();
		this.zonesR = new Vector<ZoneRoute>();
		this.zonesV = new Vector<ZoneVille>();
		this.zonesC = new Vector<Zone_champ_plateau>();
	}
		
	 static public int readInt(){
	    	final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        try{
	            return Integer.parseInt(in.readLine());   //lecture du choix utilisateur
	        }
	        catch(IOException e){
	            e.printStackTrace();
	            return -1;
	        }
	 }
	
	 static public String readString(){
	    	final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        try{
	            return in.readLine();   //lecture du choix utilisateur
	        }
	        catch(IOException e){
	            e.printStackTrace();
	            return null;
	        }
	 }
	
	public String getName(int i){
		return this.joueur[i].getPseudo();
	}
	 
	public void initialisation(){
		/*          Mise en place de la premiere tuile         */
		/*Initialiser les zones par rapport � la premiere tuile*/
		int [] cotes17 = {2, 0, 1, 0, 0, 0, 1, 0, 1};
		Tuile t = new Tuile(17, cotes17);
		p.imbriquer(t, 71, 71);
		/*Creation des joueurs*/
		System.out.println("Combien de joueurs?");
		int nbJoueur=readInt();
		this.joueur = new Joueur[nbJoueur];
		String name="";
		for(int i =0; i<this.joueur.length; i++){
			System.out.println("Entrez le nom du joueur");
			name = readString();
			joueur[i] = new Joueur(name);
			Vector<Pion> list = new Vector<Pion>();
			for(int j=0; j<8; j++){
				list.add(new Pion(i, joueur[i]));
			}
		}
		/* initialisation des premieres zones */
		this.zonesV.add(new ZoneVille());
		this.zonesR.add(new ZoneRoute());
		this.zonesV.elementAt(0).insertTuile(t, 71, 71, p);
		this.zonesR.elementAt(0).insertTuile(t, 71, 71);
		
		//Zone_champ_tuile de la première tuile
		Vector<Zone_champ_tuile> v = All_Zones_champ_tuile.getZones_champ_tuile(17, new Coordonnees(71, 71));
		
		//Pour la première tuile on crée autant de zone_champ_plateau qu'elle contient de zone_champ_tuile
		for(int i = 0; i < v.size(); i++){
			Vector<Zone_champ_tuile> v2 = new Vector<Zone_champ_tuile>();
			v2.add(v.elementAt(i));
			Zone_champ_plateau z = new Zone_champ_plateau(v2, false);
			this.zonesC.add(z);
		}
		
		// Verification zones champ du plateau
		System.out.println(verification_zones_champ());
	}
	
	public void prochainJoueur(){
		if(this.tour==this.NBjoueur)
			tour=0;
		else
			tour++;
	}
	
	/*public int routeConnexe(int positionX, int positionY){
		
	}*/
	
	public boolean is_connectN(int positionX, int positionY){
		return (p.plateau[positionX][positionY-1]!=null && p.plateau[positionX][positionY-1].cotes[4]==p.plateau[positionX][positionY].cotes[0]);
	}
	
	public boolean is_connectE(int positionX, int positionY){
		return (p.plateau[positionX+1][positionY]!=null && p.plateau[positionX+1][positionY].cotes[6]==p.plateau[positionX][positionY].cotes[2]);
	}
	
	public boolean is_connectS(int positionX, int positionY){
		return (p.plateau[positionX][positionY+1]!=null && p.plateau[positionX][positionY+1].cotes[0]==p.plateau[positionX][positionY].cotes[4]);
	}
	
	public boolean is_connectO(int positionX, int positionY ){
		return (p.plateau[positionX-1][positionY]!=null && p.plateau[positionX-1][positionY].cotes[2]==p.plateau[positionX][positionY].cotes[6]);
	}
	
	public void connecter(Tuile t, int positionX,int positionY, int pX2, int pY2, int p1, int p2){
		//connecter que si cotes connect�s de meme types
		for(int i=0; i<zonesR.size(); i++){//parcours des zones
			for(int j=0; j<zonesR.elementAt(i).chemin.size(); j++){//parcours des tuiles dans la zone
				if(zonesR.elementAt(i).chemin.elementAt(j).getX()==pX2 && zonesR.elementAt(i).chemin.elementAt(j).getY()==pY2 && p.plateau[pX2][pY2].cotes[p1]==p.plateau[positionX][positionY].cotes[p2] && p.plateau[positionX][positionY].cotes[p2]==1){
					zonesR.elementAt(i).insertTuile(t, positionX, positionY);
					System.out.println("Route connectee");
					break;
				}
			}
		}
		for(int i=0; i<zonesV.size(); i++){//parcours des zones
			for(int j=0; j<zonesV.elementAt(i).ville.size(); j++){//parcours des tuiles dans la zone
				if(((Coordonnees) zonesV.elementAt(i).ville.elementAt(j)[1]).getX()==pX2 && ((Coordonnees) zonesV.elementAt(i).ville.elementAt(j)[1]).getY()==pY2 && p.plateau[pX2][pY2].cotes[p1]==p.plateau[positionX][positionY].cotes[p2] && p.plateau[positionX][positionY].cotes[p2]==2){
					zonesV.elementAt(i).insertTuile(t, positionX, positionY, p);
					System.out.println("ville connectee");
					break;
				}
			}
		}
	}
	
	public void afficher_tuile(Tuile t){
		for(int i=0; i<t.cotes.length; i++){
			System.out.print(t.cotes[i]+" ");
			if(i==2 || i==5 || i==8)
				System.out.println("");
			else
				System.out.print("|");
			
		}
	}
	
	public String verification_zones_champ(){
		//Vérification
		String s = "";
		for(int i = 0; i < this.zonesC.size(); i++){
			s += "zone : " + i + "\n";
			Vector<Zone_champ_tuile> zone_champ_plateau = this.zonesC.elementAt(i).getZones();
			for(int j = 0; j < zone_champ_plateau.size(); j++){
				s += "Tuile : " + zone_champ_plateau.elementAt(j).getC().getX() + " " + 
				zone_champ_plateau.elementAt(j).getC().getY() + " ";
				
				s += "indices : ";
				Vector<Integer> indices = zone_champ_plateau.elementAt(j).getIndices();
				for(int k = 0; k < indices.size(); k++){
					s += indices.elementAt(k) + " ";
				}
				
				s += "\n";
			}
		}
		
		return s;
	}
	
	/*************************************************************************************/
	public void launch(){
		deck.initialisation();
		deck.melanger();
		int positionX=0, positionY=0;
		Tuile t;
		while(this.deck.size()!=0){
			joueur[tour].piocher_tuile(deck);
			System.out.println(joueur[tour].getTuile().getID());
			afficher_tuile(joueur[tour].getTuile());
			p.ou_Poser(joueur[tour].getTuile());
			positionX=readInt();
			positionY=readInt();
			t=joueur[tour].getTuile();
			joueur[tour].poser_tuile(joueur[tour].getTuile(), p, positionX, positionY);
			/* Ajouter la tuile aux zones concernees */
			/* Verifier que la tuile ne relie pas 2 zones existante */
			/* identifier les tuiles qui permettent le regroupement des zones */
			if(is_connectN(positionX, positionY)){
				System.out.println("Connecte au nord");
				connecter(t, positionX, positionY, positionX, positionY-1, 4, 0);
			}
			if(is_connectE(positionX, positionY)){
				System.out.println("Connecte a l'est");
				connecter(t, positionX, positionY, positionX+1, positionY, 6, 2);
			}
			if(is_connectS(positionX, positionY)){
				System.out.println("Connecte au sud");
				connecter(t, positionX, positionY, positionX, positionY+1, 0, 4);
			}
			if(is_connectO(positionX, positionY)){
				System.out.println("Connecte a l'ouest");
				connecter(t, positionX, positionY, positionX-1, positionY, 2, 6);
			}
			
			/* Gestion zones champs */
			
			/* Fusion des Zone_champ_tuile de la nouvelle tuile */
			All_Zones_champ_tuile.all_fusions(p, this.zonesC, t.getID(), positionX, positionY);
			
			// Fusion des Zone_champ_plateau pour éviter les doublons
			this.zonesC = All_Zones_champ_tuile.fusion(this.zonesC);
			
			// Verification zones champ du plateau
			System.out.println(verification_zones_champ());
			
			prochainJoueur();
		}
		//p.imbriquer(t3, 0, 0); //t3, positionX, positionY;
	}
}
