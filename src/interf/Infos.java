package interf;

import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Infos extends JPanel{

	Vector<Infos_joueur> v = new Vector<Infos_joueur>();
	
	public Infos(Vector<Infos_joueur> v){
		this.v = v;
		
		for(int i = 0; i < v.size(); i++){
			this.add(v.elementAt(i));
		}
	}
	
}
