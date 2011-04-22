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
	
	public boolean isEqual(Zone_champ_tuile z){
		if(!z.getC().isEqual(this.c))
			return false;
		
		Vector<Integer> v = z.getIndices();
		
		if(this.indices.size() != v.size())
			return false;
		
		for(int i = 0; i < this.indices.size(); i++){
			if(!this.indices.contains(v.elementAt(i)))
				return false;
		}
		
		return true;
	}
	
}