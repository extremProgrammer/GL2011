package interf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Infos_tuile extends JPanel{

	JLabel Jtuile;
	JLabel JflecheG;
	JLabel JflecheD;
	
	public Infos_tuile(int tile_width, int tile_height){
		this.Jtuile = new JLabel();
		this.Jtuile.setPreferredSize(new Dimension(tile_width, tile_height));
		this.Jtuile.setBackground(Color.WHITE);
		
		this.setLayout(new BorderLayout());
		this.add(this.Jtuile, BorderLayout.CENTER);
	}
	
	public void setNextTuile(String fichier_image){
		ImageIcon icon = new ImageIcon(fichier_image);
		Jtuile.setIcon(icon);
	}
	
}
