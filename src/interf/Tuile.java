package interf;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Tuile extends JPanel {
	
	ImageIcon image;
	JPanel []indices;
	
	public Tuile(int width, int height){
		super();
		this.setPreferredSize(new Dimension(width, height));
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(3, 3));
		
		indices = new JPanel[9];
		for(int i = 0; i < 9; i++){
			indices[i] = new JPanel();
			indices[i].setOpaque(false);
			this.add(indices[i]);
		}
	}
	
	public Tuile(ImageIcon image){
		this.image = image;
		this.setLayout(new GridLayout(3, 3));
		this.setPreferredSize(new Dimension(image.getIconWidth(), image.getIconHeight()));
		this.setImage(image);
		
		indices = new JPanel[9];
		for(int i = 0; i < 9; i++){
			indices[i] = new JPanel();
			indices[i].setOpaque(false);
			this.add(indices[i]);
		}
	}
	
	public void setImage(ImageIcon image){
		this.image = image;
	}
	
	public void drawPosesPion(int []indices){
		
	}
	
	public void paintComponent(Graphics g){
		if(this.image != null){
			g.drawImage(image.getImage(), 0, 0, 77, 78, null);
			g.setColor(Color.yellow);
			g.fillOval(39, 39, 7, 7);
		}
	}
	
}
