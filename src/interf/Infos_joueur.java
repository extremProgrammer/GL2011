package interf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Infos_joueur extends JPanel{

	Color c;
	JLabel Jnom_joueur;
	JLabel Jnb_pions;
	JLabel Jnb_points;
	
	int nb_pions;
	int nb_points;
	
	public Infos_joueur(Color c, String nom_joueur) {
		
		this.nb_pions = 10; 
		this.nb_points = 0;
		
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(4, 1));
		
		this.c = c;
		
		this.Jnom_joueur = new JLabel();
		this.Jnom_joueur.setText(nom_joueur);
		
		this.Jnb_pions = new JLabel();
		this.Jnb_pions.setText("Pions restants : " + nb_pions);
		
		this.Jnb_points = new JLabel();
		this.Jnb_points.setText("Points : " + nb_points);
		
		this.add(Jnom_joueur);
		this.add(Jnb_points);
		this.add(Jnb_pions);
		
	}

	public int getNb_pions() {
		return nb_pions;
	}

	public void setNb_pions(int nb_pions) {
		this.nb_pions = nb_pions;
	}

	public int getNb_points() {
		return nb_points;
	}

	public void setNb_points(int nb_points) {
		this.nb_points = nb_points;
	}
	
	public String getNom(){
		return Jnom_joueur.getText();
	}
	
	public void setNom(String nom){
		Jnom_joueur.setText(nom);
	}

	public Color getC() {
		return c;
	}

	public void setC(Color c) {
		this.c = c;
	}
	
}
