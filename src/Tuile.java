
public class Tuile {
	
	/* 
	 * Indices des c�t�s et centre:
	 * 0 : Nord
	 * 1 : Est
	 * 2 : Sud
	 * 3 : Ouest
	 * 4 : Centre
	 * 
	 * Types de c�t�s et centre: 
	 * 0 : Champ
	 * 1 : chemin
	 * 2 : ville
	 * 3 : abbaye
	 */
	
	int id;//id pour associer a une image
	int []cotes;
	Pion []pions;
	boolean pion;
	boolean blason;
	
	public Tuile(){
		this.cotes = new int[5];
		this.pions = new Pion[5];
		for(int i=0; i<5; i++)
			this.pions[i]=null;
		pion=false;
	}
	
	public Tuile(int id, int []cotes){
		this.id=id;
		this.cotes = cotes;
		this.blason=false;
	}
	
	public Tuile(int id, int []cotes, boolean blason){
		this.id=id;
		this.cotes = cotes;
		this.blason = blason;
	}
	
	public Tuile(int []cotes, Pion []pions){
		this.cotes = cotes;
		this.pions = pions;
	}
	
	
	public int getType(int i){
		return this.cotes[i];
	}
	
	public int getID(){
		return this.id;
	}
	
	//Rotation droite
	public void rotationDroite(){
		int [] copie = new int[5];
		for(int i = 0; i < 4; i++){
			copie[i] = this.cotes[i];
		}
		for(int i = 0; i < 4; i++){
			this.cotes[(i+1)%4] = copie[i];
		}
	}

	
	//Rotation gauche
	public void rotationGauche(){
		int [] copie = new int[5];
		for(int i = 0; i < 4; i++){
		copie[i] = this.cotes[i];
		}
		for(int i = 0; i < 4; i++){
		this.cotes[i] = copie[(i+1)%4];
		}
	}

	
	public boolean isPion(){
		return pion;
	}
	
	public boolean isBlason(){
		return blason;
	}
	
	public int where_is_pion(){
		for(int i=0; i<pions.length; i++){
			if(pions[i]!=null)
				return i;
		}
		return -1;
	}
	
	public void inserer_pion(int c, Pion p){
		this.pions[c]=p;
	}
	
}
