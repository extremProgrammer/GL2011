package interf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JFrame {
	
	int nb_tuiles;
	Plateau p;
	JScrollPane scrollPane;
	Infos infos_joueurs;
	Infos_tuile info_tuile;
	
	public Main(int nb_tuiles, int tile_width, int tile_height){
		
		// Plateau
		this.nb_tuiles = nb_tuiles;
		this.p = new Plateau(nb_tuiles, tile_width, tile_height);
		this.scrollPane = new JScrollPane(p);
		this.scrollPane.setPreferredSize(new Dimension(800, 700));
		
		// Infos partie
		Infos_joueur Infos_joueur = new Infos_joueur(Color.red, "Robert");
		Infos_joueur Infos_joueur2 = new Infos_joueur(Color.green, "Gérard");
		Infos_joueur Infos_joueur3 = new Infos_joueur(Color.blue, "Yves");
		Infos_joueur Infos_joueur4 = new Infos_joueur(Color.yellow, "Yvette");
		
		Vector<Infos_joueur> v = new Vector<Infos_joueur>();
		v.add(Infos_joueur);
		v.add(Infos_joueur2);
		v.add(Infos_joueur3);
		v.add(Infos_joueur4);
		
		this.infos_joueurs = new Infos(v);
		this.infos_joueurs.setPreferredSize(new Dimension(200, 800));
		this.infos_joueurs.setBackground(Color.WHITE);
		
		// Infos sur la nouvelle tuile à poser
		this.info_tuile = new Infos_tuile(tile_width, tile_height);
		this.info_tuile.setPreferredSize(new Dimension(800, 100));
		this.info_tuile.setBackground(Color.WHITE);
		
		// Ajout des composants
		this.getContentPane().setBackground(Color.WHITE);
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(scrollPane, BorderLayout.WEST);
		this.getContentPane().add(this.infos_joueurs, BorderLayout.EAST);
		this.getContentPane().add(this.info_tuile, BorderLayout.SOUTH);
		
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
		
		// Centre la vue sur la première tuile
		this.scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getMaximum()/2 - 5*tile_width);
		this.scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()/2 - 4*tile_height);
	
	}
	
	public void setImageTuile(String fichier_image, int ligne, int colonne){
		this.p.setImageTuile(fichier_image, ligne, colonne);
	}
	
	public void setTuilePossible(int ligne, int colonne){
		this.p.setTuilePossible(ligne, colonne);
	}
	
	public void setNextTuile(String fichier_image){
		this.info_tuile.setNextTuile(fichier_image);
	}
	
	public static void main(final String []args){
		
		Main m = new Main(72, 77, 78);
		
		m.setNextTuile("tile-b.png");
		
		m.setImageTuile("tile-a.png", 72, 72);
		m.setImageTuile("tile-b.png", 72, 73);
		m.setImageTuile("tile-b.png", 72, 74);
		
		m.setTuilePossible(72, 71);
		m.setTuilePossible(71, 72);
		
	}
}
