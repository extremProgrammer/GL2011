import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;


public class Jeu {
	
	Plateau p;
	int NBjoueur;
	Joueur [] tab;
	
	public Jeu(){
		this.p = new Plateau();
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
		return this.tab[i].getPseudo();
	}
	 
	public void initialisation(){
		System.out.println("Combien de joueurs?");
		int nbJoueur=readInt();
		this.tab = new Joueur[nbJoueur];
		String name="";
		for(int i =0; i<this.tab.length; i++){
			System.out.println("Entrez le nom du joueur");
			name = readString();
			tab[i] = new Joueur(name);
			Vector<Pion> list = new Vector<Pion>();
			for(int j=0; j<8; j++){
				list.add(new Pion(i, tab[i]));
			}
		}
	}
	
	
	/*************************************************************************************/
	public void launch(){
		int positionX=0;
		int positionY=0;
		//p.imbriquer(t3, 0, 0); //t3, positionX, positionY;
	}
}
