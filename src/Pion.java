
public class Pion {

	String color;
	Joueur player;
	int positionX, positionY;
	
	public Pion(){
		this.color=null;
		this.positionX=-1;
		this.positionY=-1;
	}
	
	public Pion(int i, Joueur player){	
		//this.color=color;
		this.player=player;
		this.positionX=-1;
		this.positionY=-1;
		switch(i){
		case 0 : this.color="bleu";
		case 1 : this.color="jaune";
		case 2 : this.color="vert";
		case 3 : this.color="rouge";
		}
	}
	
	public int getPosX(){
		return this.positionX;
	}
	
	public int getPosY(){
		return this.positionY;
	}
	
	public void setPosX(int pos){
		this.positionX=pos;
	}
	
	public void setPosY(int pos){
		this.positionY=pos;
	}
	
	public Joueur getPlayer(){
		return this.player;
	}
	
	public String getColor(){
		return this.color;
	}
	
	/*public void setColor(int i){
		switch(i){
		case 0 : this.color="bleu";
		case 1 : this.color="jaune";
		case 2 : this.color="vert";
		case 3 : this.color="rouge";
		}
	}*/
	
}
