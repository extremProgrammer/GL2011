package interf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Plateau extends JPanel{
	
	JLabel [][]plateau;
	GridBagConstraints c;
	
	public Plateau(int nb_tuiles, String fichier_image1){
		
		JLabel image;
		
		ImageIcon icone = new ImageIcon(fichier_image1);
		
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		
		c = new GridBagConstraints();
		
		/* La première tuile est au milieu. Comme il y a nb_tuiles tuiles,
		 * on peut poser nb_tuiles-1 à gauche, à droite, en haut, en bas.
		 * Soit sur une ligne 2*(nb_tuiles-1) + la tuile de départ = 2*nb_tuiles-1 
		 * idem pour une colonne
		 */
		
		//Nombre max de tuiles sur une ligne/colonne
		int nb_max = 2*nb_tuiles-1;
		
		plateau = new JLabel[nb_max][nb_max];
		
		for(int i = 0; i < plateau.length; i++){
			for(int j = 0; j < plateau[i].length; j++){
				c.gridx = j;
				c.gridy = i;
				
				//On pose la première tuile au milieu en position (nb_tuiles, nb_tuiles)
				if(c.gridx == nb_tuiles && c.gridy == nb_tuiles){
					image = new JLabel(new ImageIcon(fichier_image1));
				} 
				
				//Pour le reste des tuiles on remplit de blanc
				else {
					image = new JLabel();
					image.setPreferredSize(new Dimension(icone.getIconWidth(), icone.getIconHeight()));
					image.setBackground(Color.WHITE);
				}
				
				this.add(image, c);
				plateau[i][j] = image;
			}
		}
		
	}
	
	public void setImageTuile(String fichier_image, int ligne, int colonne){
		ImageIcon icone = new ImageIcon(fichier_image);
		plateau[ligne][colonne].setIcon(icone);	
	}
	
	//Crée une bordure rouge pour désigner une position possible pour poser une tuile
	public void setTuilePossible(int ligne, int colonne){
		plateau[ligne][colonne].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.RED));
	}
	
}
