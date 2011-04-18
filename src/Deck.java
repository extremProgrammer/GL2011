import java.util.Vector;


public class Deck {

	Vector <Tuile> deck;
	
	public Deck(){
		this.deck = new Vector<Tuile>();
	}
	
	public int size(){
		return this.deck.size();
	}
	
	public void initialisation(){
		//Nord, Est, Sud, Ouest, Centre
		//* 0 : Champ, 1 : chemin, 2 : ville , 3 : abbaye

		int [] cotes1 = {0, 0, 1, 1, 0};
		Tuile t = new Tuile(1, cotes1);
		for(int i=0; i<9; i++)
			deck.add(t);
		
		int [] cotes2 = {2, 1, 1, 0, 1};
		t = new Tuile(2, cotes2);
		for(int i=0; i<3; i++)
			deck.add(t);
		
		int [] cotes3 = {2, 1 , 1 ,2, 0};
		t = new Tuile(3, cotes3, true);
		for(int i=0; i<2; i++)
			deck.add(t);
		
		int [] cotes4 = {2, 2 , 1 ,2, 2};
		t = new Tuile(4, cotes4);
		deck.add(t);
		
		int [] cotes5 = {2, 2 , 1 ,2, 2};
		t = new Tuile(5, cotes5, true);
		deck.add(t);
		
		int [] cotes6 = {2, 1 , 1 ,2, 0};
		t = new Tuile(6, cotes6);
		for(int i=0; i<3; i++)
			deck.add(t);
		
		int [] cotes7 = {2, 1 , 1 ,1, 1};
		t = new Tuile(7, cotes7);
		for(int i=0; i<3; i++)
			deck.add(t);
		
		int [] cotes8 = {1,0 , 1 ,0 , 1};
		t = new Tuile(8, cotes8);
		for(int i=0; i<8; i++)
			deck.add(t);
		
		int [] cotes9 = {0 ,1 , 1 ,1 , 1};
		t = new Tuile(9, cotes9);
		for(int i=0; i<4; i++)
			deck.add(t);
		
		int [] cotes10 = {2 ,0 ,0 ,0 ,0};
		t = new Tuile(10, cotes10);
		for(int i=0; i<5; i++)
			deck.add(t);
		
		int [] cotes11 = {2 ,2 ,0 ,0 ,0};
		t = new Tuile(11, cotes11);
		for(int i=0; i<2; i++)
			deck.add(t);
		
		int [] cotes12 = {2 ,2 ,0 ,2 ,2};
		t = new Tuile(12, cotes12);
		for(int i=0; i<3; i++)
			deck.add(t);
		
		int [] cotes13 = {0 ,0 ,0 ,0 ,3};
		t = new Tuile(13, cotes13);
		for(int i=0; i<4; i++)
			deck.add(t);
		
		int [] cotes14 = {0 ,0 ,1 ,0 ,3};
		t = new Tuile(14, cotes14);
		for(int i=0; i<2; i++)
			deck.add(t);
		
		int [] cotes15 = {2 ,0 ,0 ,2 ,0};
		t = new Tuile(15, cotes15);
		for(int i=0; i<3; i++)
			deck.add(t);
		
		int [] cotes16 = {0 ,2 ,0 ,2 ,2};
		t = new Tuile(16, cotes16, true);
		for(int i=0; i<2; i++)
			deck.add(t);
		
		int [] cotes17 = {2 ,1 ,0 ,1 ,1};
		t = new Tuile(17, cotes17);
		for(int i=0; i<4; i++)
			deck.add(t);
		
		int [] cotes18 = {2 ,0 ,1 ,1 ,1};
		t = new Tuile(18, cotes18);
		for(int i=0; i<3; i++)
			deck.add(t);
		
		int [] cotes19 = {0 ,2 ,0 ,2 ,2};
		t = new Tuile(19, cotes19);
		deck.add(t);
			
		int [] cotes20 = {2 ,2 ,1 ,2 ,2};
		t = new Tuile(20, cotes20, true);
		for(int i=0; i<2; i++)
			deck.add(t);
	
		int [] cotes21 = {2 ,2 ,2 ,2 ,2};
		t = new Tuile(21, cotes21, true);
		deck.add(t);
		
		int [] cotes22 = {1 ,1 ,1 ,1 ,1};
		t = new Tuile(22, cotes22);
		deck.add(t);
		
		int [] cotes23 = {2 ,0 ,0 ,2 ,0};
		t = new Tuile(23, cotes23, true);
		for(int i=0; i<2; i++)
			deck.add(t);
		
		int [] cotes24 = {0 ,2 ,0 ,2 ,0};
		t = new Tuile(24, cotes24);
		for(int i=0; i<3; i++)
			deck.add(t);
		
	} 
	
	public void melanger(){
		Vector <Tuile> deck_copie = new Vector<Tuile>();
		int low=0;
		int high;
		int rand;
		while(this.deck.size()!=0){
			high=this.deck.size();
			rand = (int)(Math.random() * (high-low)) + low;
			deck_copie.add(this.deck.elementAt(rand));
			this.deck.remove(rand);
		}
		for(int i=0; i<deck_copie.size(); i++){
			this.deck.add(deck_copie.elementAt(i));
		}
	}
	
	public Tuile piocher(){
		Tuile t=this.deck.lastElement();
		this.deck.remove(this.deck.lastElement());
		return t;
	}
	
}
