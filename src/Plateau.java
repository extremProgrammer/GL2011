
public class Plateau {

	Tuile [][] plateau;
	
	public Plateau(){
		this.plateau = new Tuile[143][143];
	}
	
	public void imbriquer(Tuile t, int positionX, int positionY){
		this.plateau[positionX][positionY]=t;
	}
	
	public boolean isTuileN(int positionX, int positionY){
		if(positionY==0)
			return false;
		if(this.plateau[positionX][positionY-1]!=null)
			return true;
		else
			return false;
	}
	
	public boolean isTuileS(int positionX, int positionY){
		if(positionY==this.plateau[0].length-1)
			return false;
		if(this.plateau[positionX][positionY+1]!=null)
			return true;
		else
			return false;
	}

	public boolean isTuileE(int positionX, int positionY){
		if(positionX==this.plateau.length-1)
			return false;
		if(this.plateau[positionX+1][positionY]!=null)
			return true;
		else
			return false;
	}

	public boolean isTuileO(int positionX, int positionY){
		if(positionX==0)
			return false;
		if(this.plateau[positionX-1][positionY]!=null)
			return true;
		else
			return false;
	}
	
	public boolean isTuile(int positionX, int positionY){
		return this.plateau[positionX][positionY]!=null;
	}
	
	public boolean pose_Possible(Tuile t, int positionX, int positionY){
		if(isTuile(positionX, positionY)){
			return false;
		}
		if(!isTuileN(positionX,positionY) && !isTuileS(positionX,positionY) && !isTuileE(positionX,positionY) && !isTuileO(positionX,positionY)){
			return false;
		}
		if(isTuileN(positionX,positionY) && this.plateau[positionX][positionY-1].cotes[2]!=t.cotes[0]){
			return false;
		}
		if(isTuileS(positionX,positionY) && this.plateau[positionX][positionY+1].cotes[0]!=t.cotes[2]){
			return false;
		}
		if(isTuileE(positionX,positionY) && this.plateau[positionX+1][positionY].cotes[3]!=t.cotes[1]){
			return false;
		}
		if(isTuileO(positionX,positionY) && this.plateau[positionX-1][positionY].cotes[1]!=t.cotes[3]){
			return false;
		}
		return true;
	}
	
	public void ou_Poser(Tuile t){
		String s="";
		int cmp=1;
		for(int i=0; i<this.plateau.length; i++){
			for(int j=0; j<this.plateau[0].length; j++){
				if(pose_Possible(t, i, j)){
					s+=cmp+" poser tuile en position "+i+" "+j+"\n";
					cmp++;
				}	
			}
		}
		System.out.println(s);
	}
	
}
