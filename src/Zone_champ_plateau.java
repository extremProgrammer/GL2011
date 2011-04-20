import java.util.Vector;


public class Zone_champ_plateau {

	Vector<Zone_champ_tuile> zones;
	boolean pion;
	
	public Zone_champ_plateau(){
		this.zones = new Vector<Zone_champ_tuile>();
		this.pion = false;
	}
	
	public Zone_champ_plateau(Vector<Zone_champ_tuile> zones, boolean pion) {
		super();
		this.zones = zones;
		this.pion = pion;
	}

	public Vector<Zone_champ_tuile> getZones() {
		return zones;
	}

	public void setZones(Vector<Zone_champ_tuile> zones) {
		this.zones = zones;
	}

	public boolean isPion() {
		return pion;
	}

	public void setPion(boolean pion) {
		this.pion = pion;
	}
	
	public void fusion(Zone_champ_tuile z){
		this.zones.add(z);
	}
	
	public static void main(String []args){
		
		Plateau p = new Plateau(143, 143);
		
		//Premiere tuile
		int [] cotes17 = {2, 0, 1, 0, 0, 0, 1, 0, 1};
		Tuile t = new Tuile(17, cotes17);
		
		p.imbriquer(t, 72, 72);
		
		Vector<Zone_champ_tuile> v = All_Zones_champ_tuile.getZones_champ_tuile(17, new Coordonnees(72, 72));
		Vector<Zone_champ_plateau> zones = new Vector<Zone_champ_plateau>();
		
		for(int i = 0; i < v.size(); i++){
			Vector<Zone_champ_tuile> v2 = new Vector<Zone_champ_tuile>();
			v2.add(v.elementAt(i));
			Zone_champ_plateau z = new Zone_champ_plateau(v2, false);
			zones.add(z);
		}
		
		int [] cotes10 = {2, 0, 0, 0, 0, 0, 0, 0, 0};
		Tuile t2 = new Tuile(10, cotes10);
		
		p.imbriquer(t2, 73, 71);
		
		Vector<Zone_champ_tuile> v2 = All_Zones_champ_tuile.getZones_champ_tuile(10, new Coordonnees(73, 71));
		
		for(int i = 0; i < v2.size(); i++){
			Vector<Zone_champ_tuile> v3 = new Vector<Zone_champ_tuile>();
			v3.add(v2.elementAt(i));
			Zone_champ_plateau z = new Zone_champ_plateau(v3, false);
			zones.add(z);
		}
		
		
		//Vérification
		String s = "";
		for(int i = 0; i < zones.size(); i++){
			s += "zone : " + i + "\n";
			Vector<Zone_champ_tuile> zone_champ_plateau = zones.elementAt(i).getZones();
			for(int j = 0; j < zone_champ_plateau.size(); j++){
				s += "Tuile : " + zone_champ_plateau.elementAt(j).getC().getX() + " " + 
				zone_champ_plateau.elementAt(j).getC().getY() + " ";
				
				s += "indices : ";
				Vector<Integer> indices = zone_champ_plateau.elementAt(j).getIndices();
				for(int k = 0; k < indices.size(); k++){
					s += indices.elementAt(k) + " ";
				}
				
				s += "\n";
			}
		}
		
		System.out.println(s);
		
		//Nouvelle tuile insérée
		int [] cotes1 = {0, 0, 0, 0, 1, 0, 1, 1, 1};
		Tuile t3 = new Tuile(1, cotes1);
		
		System.out.println("pose possible : " + p.pose_Possible(t3, 73, 72));
		
		p.imbriquer(t3, 73, 72);
		
		All_Zones_champ_tuile.all_fusions(p, zones, 1, 73, 72);
		
		//Vérification
		s = "";
		for(int i = 0; i < zones.size(); i++){
			s += "zone : " + i + "\n";
			Vector<Zone_champ_tuile> zone_champ_plateau = zones.elementAt(i).getZones();
			for(int j = 0; j < zone_champ_plateau.size(); j++){
				s += "Tuile : " + zone_champ_plateau.elementAt(j).getC().getX() + " " + 
				zone_champ_plateau.elementAt(j).getC().getY() + " ";
				
				s += "indices : ";
				Vector<Integer> indices = zone_champ_plateau.elementAt(j).getIndices();
				for(int k = 0; k < indices.size(); k++){
					s += indices.elementAt(k) + " ";
				}
				
				s += "\n";
			}
		}
		
		System.out.println(s);
		
	}
	
}
