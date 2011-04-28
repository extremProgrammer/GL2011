import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;





public class Main {

	 static public int readInt(){
	    	final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	        try{
	            return Integer.parseInt(in.readLine());   //lecture du choix utilisateur
	        }
	        catch(IOException e){
	            e.printStackTrace();
	            return -1;
	        }
	 }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*Deck d = new Deck();
		d.initialisation();
		System.out.println(d.size());
		System.out.println(d.deck.elementAt(0).cotes[0]);
		d.melanger();
		System.out.println(d.size());
		System.out.println(d.deck.elementAt(0).cotes[0]);
		d.piocher();
		System.out.println(d.size());
		
		Jeu j = new Jeu();
		j.initialisation();
		System.out.println(j.joueur[0].pseudo+" "+j.joueur[1].pseudo);*/
		
		
		/* LANCEMENT DU JEU */
		Jeu j = new Jeu();
		j.initialisation();
		j.launch();
	}

}
