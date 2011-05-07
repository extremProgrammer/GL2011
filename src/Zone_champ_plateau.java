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
	
	public void fusion(Zone_champ_plateau zcp){
		
		//On fusionne les 2 vecteurs en évitant de créer des doublons
		Vector<Zone_champ_tuile> v = zcp.getZones();
		for(int i = 0; i < v.size(); i++){
			if(!this.contient_zone_champ_tuile(v.elementAt(i))){
				this.zones.add(v.elementAt(i));
			}
		}
		
	}
	
	public boolean contient_zone_champ_tuile(Zone_champ_tuile zct){
		
		for(int i = 0; i < this.zones.size(); i++){	
			if(this.zones.elementAt(i).isEqual(zct)){
				return true;
			}
		}
		
		return false;
	}
	
	//Renvoie vrai si 2 Zone_champ_tuile sont identiques dans les Zone_champ_plateau
	public boolean meme_zone_champ_tuile(Zone_champ_plateau zcp){
		
		Vector<Zone_champ_tuile> v = zcp.getZones();
		
		for(int i = 0; i < this.zones.size(); i++){
			for(int j = 0; j < v.size(); j++){
				if(this.zones.elementAt(i).isEqual(v.elementAt(j))){
					return true;
				}
			}
		}
		
		return false;
	}
	
	/*public static void main(String []args){
		
		Plateau p = new Plateau(143, 143);
		
		//Premiere tuile
		int [] cotes17 = {2, 0, 1, 0, 0, 0, 1, 0, 1};
		Tuile t = new Tuile(17, cotes17);
		
		p.imbriquer(t, 72, 72);
		
		//On récupère les zones de la nouvelle tuile
		Vector<Zone_champ_tuile> v = All_Zones_champ_tuile.getZones_champ_tuile(17, new Coordonnees(72, 72));
		
		//Création du vecteur qui contiendra toutes les zones champ du plateau
		Vector<Zone_champ_plateau> zones = new Vector<Zone_champ_plateau>();
		
		//Pour la première tuile on crée autant de zone_champ_plateau qu'elle contient de zone_champ_tuile
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
		
		int [] cotes22 = {1, 0, 1, 0, 1, 0,1 , 0, 1};
		Tuile t4 = new Tuile(22, cotes22);
		
		p.imbriquer(t4, 73, 73);
		
		Vector<Zone_champ_tuile> v4 = All_Zones_champ_tuile.getZones_champ_tuile(22, new Coordonnees(73, 73));
		
		for(int i = 0; i < v4.size(); i++){
			Vector<Zone_champ_tuile> v5 = new Vector<Zone_champ_tuile>();
			v5.add(v4.elementAt(i));
			Zone_champ_plateau z = new Zone_champ_plateau(v5, false);
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
		
		System.out.println("APRES FUSION : ");
		
		//Fusion des zones
		zones = All_Zones_champ_tuile.fusion(zones);
		
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
	}*/
	
}
