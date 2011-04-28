
public class Tuile {
	
	/* 
	 * Indices des cotes et centre:
	 * 0 : Nord
	 * 1 : NE
	 * 2 : Est
	 * 3 : SE
	 * 4 : Sud
	 * 5 : SO
	 * 6 : Ouest
	 * 7 : NO
	 * 8 : Centre
	 * 
	 * Types de cotess et centre: 
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
		this.cotes = new int[9];
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
		int [] copie = new int[9];
		for(int i = 0; i < 9; i++){
			copie[i] = this.cotes[i];
		}
		//Pas besoin de changer le centre
		for(int i = 0; i < 8; i++){
			this.cotes[(i+2)%8] = copie[i];
		}
	}

	
	//Rotation gauche
	public void rotationGauche(){
		int [] copie = new int[9];
		for(int i = 0; i < 9; i++){
			copie[i] = this.cotes[i];
		}
		//Pas besoin de changer le centre
		for(int i = 0; i < 8; i++){
			this.cotes[i] = copie[(i+2)%8];
		}
	}

	
	public boolean isPion(){
		return pion;
	}
	
	public boolean isBlason(){
		return blason;
	}
	
	//retourne la position du pion sur la tuile
	public int where_is_pion(){
		for(int i=0; i<pions.length; i++){
			if(pions[i]!=null)
				return i;
		}
		return -1;
	}
	
	//retourne la valeur 
	public int Pion_is_on(){
		int i = where_is_pion();
		return this.cotes[i];
	}
	
	public void inserer_pion(int c, Pion p){
		this.pions[c]=p;
	}
	
	public boolean is_carrefour(){
		int nbchemin=0;
		for(int i=0; i<8; i+=2){
			if(this.cotes[i]==1)
				nbchemin++;
		}
		if(this.cotes[8]==1 && nbchemin>2)
			return true;
		return false;
	}
	
	public boolean is_route(){
		int nbchemin=0;
		for(int i=0; i<8; i+=2){
			if(this.cotes[i]==1)
				nbchemin++;
		}
		if(nbchemin==2)
			return true;
		return false;
	}
	
	public boolean fin_route(){
		int nbchemin=0;
		for(int i=0; i<8; i+=2){
			if(this.cotes[i]==1)
				nbchemin++;
		}
		return nbchemin<2;
	}
	
}
