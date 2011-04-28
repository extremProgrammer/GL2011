import java.util.Vector;


public class ZoneRoute {

	boolean pion;
	boolean fermeG;//savoir si la route est ferme sur la gauche
	boolean fermeD;//savoir si la route est ferme sur la droite
	Vector <Coordonnees> chemin;

	public ZoneRoute(){
		this.chemin=new Vector<Coordonnees>();
		this.fermeG=false;
		this.fermeD=false;
		this.pion=false;
	}
	
	public boolean getFermeG(){
		return this.fermeG;
	}
	
	public boolean getFermeD(){
		return this.fermeD;
	}
	
	public void setFermeG(boolean b){
		this.fermeG=b;
	}
	
	public void setFermeD(boolean b){
		this.fermeD=b;
	}
	
	public void insertTuile(Tuile t, int positionX, int positionY){
		Coordonnees c = new Coordonnees(positionX, positionY);
		if(this.chemin.size()==0){
			this.chemin.add(c);
		}
		else if(positionX<this.chemin.elementAt(0).getX() || positionY<this.chemin.elementAt(0).getY()){
			chemin.insertElementAt(c, 0);
			if (t.is_carrefour() || t.fin_route())
				this.fermeG=true;
		}
		else{
			chemin.insertElementAt(c, this.chemin.size());
			if (t.is_carrefour() || t.fin_route())
				this.fermeD=true;
		}
		if(t.isPion())
			this.pion=true;
	}
	
	public boolean isPion(){
		return pion;
	}
	
	public void setPion(boolean b){
		this.pion=b;
	}
	
	public void fusionRoute(ZoneRoute route, int positionX, int positionY){
		//si la zone route doit être recoller au début de celle ci
		Vector <Coordonnees> chemin_copie = new Vector<Coordonnees>();
		if(positionX==this.chemin.elementAt(0).getX() || positionY==this.chemin.elementAt(0).getY()){
			for(int i=0; i<route.chemin.size(); i++)
				chemin_copie.add(route.chemin.elementAt(i));
			for(int j=1; j<this.chemin.size(); j++)
				chemin_copie.add(this.chemin.elementAt(j));
			this.chemin=chemin_copie;
			this.fermeG=route.getFermeG();
		}
		else{
			for(int i=1; i<route.chemin.size(); i++)
				this.chemin.add(route.chemin.elementAt(i));
			this.fermeD=route.getFermeD();
		}
	}
	
}
