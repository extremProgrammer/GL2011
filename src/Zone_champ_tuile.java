import java.util.Vector;

public class Zone_champ_tuile{
	Coordonnees c;
	Vector<Integer> indices;
	boolean pion;
	
	public Zone_champ_tuile(Coordonnees c, Vector<Integer> indices, boolean pion) {
		this.c = c;
		this.indices = indices;
		this.pion = false;
	}

	public Coordonnees getC() {
		return c;
	}

	public void setC(Coordonnees c) {
		this.c = c;
	}

	public Vector<Integer> getIndices() {
		return indices;
	}

	public void setIndices(Vector<Integer> indices) {
		this.indices = indices;
	}
	
}