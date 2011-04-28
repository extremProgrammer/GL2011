import java.util.Vector;


public class ZoneVille {

	boolean fermeN;
	boolean fermeS;
	boolean fermeO;
	boolean fermeE;
	boolean pion;
	Vector <Object[]> ville;//[0]: la tuile, [1]: les coordonnées
	
	public ZoneVille(){
		this.ville = new Vector<Object[]>();
		this.fermeN=false;
		this.fermeS=false;
		this.fermeO=false;
		this.fermeE=false;
		this.pion=false;
	}
	
	public int getTaille(){
		return this.ville.size();
	}
	
	public void side_closed(Tuile t, int positionX, int positionY, Plateau p){
		/* Verifier si la ville est ferme ou si la tuile n'est pas connecté a une autre tuile existante */
		if(t.cotes[0]!=2)
			this.fermeN=true;
		else if(/*p.plateau[positionX][ positionY-1].cotes[4]!=2 ||*/ p.plateau[positionX][ positionY-1]==null)
			this.fermeN=false;
		if(t.cotes[2]!=2)
			this.fermeE=true;
		else if(p.plateau[positionX+1][ positionY].cotes[6]!=2)
			this.fermeE=false;
		if(t.cotes[0]!=4)
			this.fermeS=true;
		else if(p.plateau[positionX][ positionY+1].cotes[0]!=2)
			this.fermeS=false;
		if(t.cotes[0]!=6)
			this.fermeO=true;
		else if(p.plateau[positionX-1][ positionY].cotes[2]!=2)
			this.fermeO=false;
	}
	
	public void insertTuile(Tuile t, int positionX, int positionY, Plateau p){
		side_closed(t, positionX, positionY, p);
		Coordonnees c = new Coordonnees(positionX, positionY);
		Object [] tab = {t , c};
		this.ville.add(tab);
	}
	
	public boolean isPion(){
		return pion;
	}
	
	public void setPion(boolean b){
		this.pion=b;
	}
	
	public boolean isComplete(){
		return(this.fermeN && this.fermeE && this.fermeS && this.fermeO);
	}
	
	public void fusionVille(ZoneVille ville, int positionX, int positionY, Plateau p){
		for(int i=0; i<ville.getTaille(); i++){
			if(((Coordonnees) ville.ville.elementAt(i)[1]).getX()!=positionX && ((Coordonnees) ville.ville.elementAt(i)[1]).getY()!=positionY){//la tuile qui connecte les 2 zones a déjà été rajouté dans la 1ere zone
				side_closed((Tuile)ville.ville.elementAt(i)[0], ((Coordonnees) ville.ville.elementAt(i)[1]).getX(), ((Coordonnees) ville.ville.elementAt(i)[1]).getY(), p);
				this.ville.add(ville.ville.elementAt(i));
			}
		}
		
	}
	
}
