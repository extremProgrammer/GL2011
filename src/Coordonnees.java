
public class Coordonnees{
	int x, y;
	
	public Coordonnees(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public boolean isEqual(Coordonnees c){
		return (c.getX() == this.x && c.getY() == this.y);
	}
}