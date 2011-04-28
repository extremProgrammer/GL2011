import java.util.Vector;

public class Joueur {

	String pseudo;
	int NBpoint;
	Vector<Pion>pions;//max 8
	Tuile t;
	
	public Joueur(){
		this.NBpoint=0;
		this.pions=new Vector<Pion>();
		t=null;
	}
	
	public Joueur(String pseudo){
		this.pseudo=pseudo;
		this.NBpoint=0;
		this.pions=new Vector<Pion>();
		t=null;
	}
	
	public Joueur(String pseudo, Vector<Pion>pions){
		this.pseudo=pseudo;
		this.pions=pions;
		t=null;
	}
	
	public void setTuile(Tuile t){
		this.t=t;
	}
	
	public Tuile getTuile(){
		return this.t;
	}
	
	public String getPseudo(){
		return this.pseudo;
	}
	
	public void setPion(Vector<Pion>pions){
		this.pions=pions;
	}
	
	public int pion_restant(){
		return pions.size();
	}
	
	public void piocher_tuile(Deck d){
		this.t = d.piocher();
		
	}
	
	public void addPoint(int p){
		this.NBpoint+=p;
	}
	
	public void poser_tuile(Tuile t, Plateau p, int positionX, int positionY){
		p.imbriquer(t, positionX, positionY);
		this.t=null;
	}
	
	public void poser_pion(Tuile t, Plateau p, int positionX, int positionY, int c){
		p.plateau[positionX][positionY].inserer_pion(c, pions.elementAt(pions.size()-1));
		this.pions.remove(this.pions.size()-1);
	}
	
}
