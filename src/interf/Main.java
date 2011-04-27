package interf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JFrame {
	
	String fichier_image1;
	int nb_tuiles;
	Plateau p;
	JScrollPane scrollPane;
	JPanel informations;
	
	public Main(int nb_tuiles, String fichier_image1){
		
		//Plateau
		this.fichier_image1 = fichier_image1;
		this.nb_tuiles = nb_tuiles;
		this.p = new Plateau(nb_tuiles, fichier_image1);
		this.scrollPane = new JScrollPane(p);
		this.scrollPane.setPreferredSize(new Dimension(800, 800));
		
		//Informations partie
		
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(scrollPane);
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.WHITE);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
		
		ImageIcon icone = new ImageIcon(fichier_image1);
		//Centre la vue sur la première tuile
		this.scrollPane.getHorizontalScrollBar().setValue(scrollPane.getHorizontalScrollBar().getMaximum()/2 - 5*icone.getIconWidth());
		this.scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()/2 - 4*icone.getIconHeight());
	
	}
	
	public void setImageTuile(String fichier_image, int ligne, int colonne){
		this.p.setImageTuile(fichier_image, ligne, colonne);
	}
	
	public void setTuilePossible(int ligne, int colonne){
		this.p.setTuilePossible(ligne, colonne);
	}
	
	public static void main(final String []args){
		
		Main m = new Main(72, "tile-a.png");
		
		m.setImageTuile("tile-b.png", 72, 73);
	
		m.setImageTuile("tile-b.png", 72, 74);
		
		m.setTuilePossible(72, 71);
		m.setTuilePossible(71, 72);
		
	}
}
