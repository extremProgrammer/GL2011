import java.awt.List;
import java.util.Arrays;
import java.util.Vector;


public class All_Zones_champ_tuile {
	
	public static int getOppositeN(int type){
		if(type == 7)
			return 5;
		if(type == 0)
			return 4;
		if(type == 1)
			return 3;
		return -1;
	}
	
	public static int getOppositeE(int type){
		if(type == 1)
			return 7;
		if(type == 2)
			return 6;
		if(type == 3)
			return 5;
		return -1;
	}
	
	public static int getOppositeS(int type){
		if(type == 5)
			return 7;
		if(type == 4)
			return 0;
		if(type == 3)
			return 1;
		return -1;
	}
	
	public static int getOppositeO(int type){
		if(type == 7)
			return 1;
		if(type == 6)
			return 2;
		if(type == 5)
			return 3;
		return -1;
	}
	
	public static Vector<Integer> array_to_vector(int []tab){
		Vector<Integer> indices = new Vector<Integer>();
		
		for(int i = 0; i < tab.length; i++){
			indices.add(tab[i]);
		}
		
		return indices;
	}

	//Renvoie toutes les zones champ d'une tuile
	public static Vector<Zone_champ_tuile> getZones_champ_tuile(int id, Coordonnees c){
		Vector<Zone_champ_tuile> zones = new Vector<Zone_champ_tuile>();
		Vector<Integer> indices = new Vector<Integer>();
		Vector<Integer> indices2 = new Vector<Integer>();
		Vector<Integer> indices3 = new Vector<Integer>();
		Vector<Integer> indices4 = new Vector<Integer>();
		Zone_champ_tuile z;
		
		switch(id){
		case 1:
			int []tab = {0, 1, 2, 3, 7};
			indices = array_to_vector(tab);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			indices2.add(5);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 2:
			int []tab2 = {1, 5, 6, 7};
			indices = array_to_vector(tab2);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			indices2.add(3);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 3:
			int []tab3 = {1, 5, 8};
			indices = array_to_vector(tab3);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			indices2.add(3);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 4:
			indices.add(3);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			indices2.add(5);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 5:
			int []tab5 = {3, 4, 5};
			indices = array_to_vector(tab5);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 6:
			int []tab6 = {1, 5, 8};
			indices = array_to_vector(tab6);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);

			indices2.add(3);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 7:
			int []tab7 = {1, 7};
			indices = array_to_vector(tab7);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
		
			indices2.add(3);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
	
			indices3.add(5);
			z = new Zone_champ_tuile(c, indices3, false);
			zones.add(z);
			
			return zones;
			
		case 8:
			int []tab8 = {1, 2, 3};
			indices = array_to_vector(tab8);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);

			int []tab82 = {5, 6, 7};
			indices2 = array_to_vector(tab82);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 9:
			int []tab9 = {0, 1, 7};
			indices = array_to_vector(tab9);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);

			indices2.add(3);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);

			indices3.add(5);
			z = new Zone_champ_tuile(c, indices3, false);
			zones.add(z);
			
			return zones;
			
		case 10:
			int []tab10 = {1, 2, 3, 4, 5, 6, 7, 8};
			indices = array_to_vector(tab10);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 11:
			int []tab11 = {3, 4, 5, 6, 7, 8};
			indices = array_to_vector(tab11);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 12:
			int []tab12 = {3, 4, 5};
			indices = array_to_vector(tab12);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 13:
			int []tab13 = {0, 1, 2, 3, 4, 5, 6, 7};
			indices = array_to_vector(tab13);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 14:
			int []tab14 = {0, 1, 2, 3, 5, 6, 7};
			indices = array_to_vector(tab14);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 15:
			int []tab15 = {1, 2, 3, 4, 5, 8};
			indices = array_to_vector(tab15);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 16:
			int []tab16 = {0, 1, 7};
			indices = array_to_vector(tab16);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);

			int []tab162 = {3, 4, 5};
			indices2 = array_to_vector(tab162);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 17:
			int []tab17 = {1, 7};
			indices = array_to_vector(tab17);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			int []tab172 = {3, 4, 5};
			indices2 = array_to_vector(tab172);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 18:
			int []tab18 = {1, 2, 3, 7};
			indices = array_to_vector(tab18);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			indices2.add(5);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 19:
			int []tab19 = {0, 1, 7};
			indices = array_to_vector(tab19);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
	
			int []tab192 = {3, 4, 5};
			indices2 = array_to_vector(tab192);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 20:
			indices.add(3);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			indices2.add(5);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);
			
			return zones;
			
		case 21:
			
			return zones;
			
		case 22:
			indices.add(1);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);

			indices2.add(3);
			z = new Zone_champ_tuile(c, indices2, false);
			zones.add(z);

			indices3.add(5);
			z = new Zone_champ_tuile(c, indices3, false);
			zones.add(z);

			indices4.add(7);
			z = new Zone_champ_tuile(c, indices4, false);
			zones.add(z);
			
			return zones;
			
		case 23:
			int []tab23 = {1, 2, 3, 4, 5, 8};
			indices = array_to_vector(tab23);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		case 24:
			int []tab24 = {0, 1, 3, 4, 5, 7, 8};
			indices = array_to_vector(tab24);
			z = new Zone_champ_tuile(c, indices, false);
			zones.add(z);
			
			return zones;
			
		default:
			return zones;
			
			
		}
	
	}
	
	public static Vector<Zone_champ_plateau> all_fusions(Plateau p, Vector<Zone_champ_plateau> zones, int id_tuile, int x, int y){
		Vector<Zone_champ_tuile> v = All_Zones_champ_tuile.getZones_champ_tuile(id_tuile, new Coordonnees(73, 72));
		
		System.out.println("Tuile au nord : " + p.isTuileN(x, y));
		System.out.println("Tuile à l'est : " + p.isTuileE(x, y));
		System.out.println("Tuile au sud : " + p.isTuileS(x, y));
		System.out.println("Tuile à l'ouest : " + p.isTuileO(x, y));
		
		if(p.isTuileN(x, y)){
			//On parcourt toutes les zones champ du plateau
			for(int i = 0; i < zones.size(); i++){
				Vector<Zone_champ_tuile> zone_champ_plateau = zones.elementAt(i).getZones();
				
				//On regarde si la tuile voisine y est et on fusionne les zones
				for(int j = 0; j < zone_champ_plateau.size(); j++){
					if(zone_champ_plateau.elementAt(j).getC().getX() == x && 
							zone_champ_plateau.elementAt(j).getC().getY() == (y-1)){
						
						//On récupère les indices de la case voisine
						Vector<Integer> indices_voisin = zone_champ_plateau.elementAt(j).getIndices();
						
						//On parcourt les zones de la nouvelle tuile
						for(int k = 0; k < v.size(); k++){
							
							//On récupère les indices de la nouvelle tuile
							Vector<Integer> indices_new_tuile = v.elementAt(k).getIndices();
							
							//Si un indice de indice_voisin correspond à l'opposé d'un indice de indices_new_tuiles, on fusionne
							for(int l = 0; l < indices_new_tuile.size(); l++){
								int indice = indices_new_tuile.elementAt(l);
								if((indice == 0 || indice == 1 || indice == 7) 
										&& indices_voisin.contains(All_Zones_champ_tuile.getOppositeN(indice))){
									zones.elementAt(i).fusion(v.elementAt(k));
									break;
								}
							}
						}	
					}
				}					
			}
		}
		
		if(p.isTuileE(x, y)){
			//On parcourt toutes les zones champ du plateau
			for(int i = 0; i < zones.size(); i++){
				Vector<Zone_champ_tuile> zone_champ_plateau = zones.elementAt(i).getZones();
				
				//On regarde si la tuile voisine y est et on fusionne les zones
				for(int j = 0; j < zone_champ_plateau.size(); j++){
					if(zone_champ_plateau.elementAt(j).getC().getX() == (x+1) && 
							zone_champ_plateau.elementAt(j).getC().getY() == y){
						
						//On récupère les indices de la case voisine
						Vector<Integer> indices_voisin = zone_champ_plateau.elementAt(j).getIndices();
						
						//On parcourt les zones de la nouvelle tuile
						for(int k = 0; k < v.size(); k++){
							
							//On récupère les indices de la nouvelle tuile
							Vector<Integer> indices_new_tuile = v.elementAt(k).getIndices();
							
							//Si un indice de indice_voisin correspond à l'opposé d'un indice de indices_new_tuiles, on fusionne
							for(int l = 0; l < indices_new_tuile.size(); l++){
								if(indices_voisin.contains(All_Zones_champ_tuile.getOppositeE(indices_new_tuile.elementAt(l)))){
									zones.elementAt(i).fusion(v.elementAt(k));
									break;
								}
							}
						}	
					}
				}					
			}
		}
		
		if(p.isTuileS(x, y)){
			//On parcourt toutes les zones champ du plateau
			for(int i = 0; i < zones.size(); i++){
				Vector<Zone_champ_tuile> zone_champ_plateau = zones.elementAt(i).getZones();
				
				//On regarde si la tuile voisine y est et on fusionne les zones
				for(int j = 0; j < zone_champ_plateau.size(); j++){
					if(zone_champ_plateau.elementAt(j).getC().getX() == x && 
							zone_champ_plateau.elementAt(j).getC().getY() == (y+1)){
						
						//On récupère les indices de la case voisine
						Vector<Integer> indices_voisin = zone_champ_plateau.elementAt(j).getIndices();
						
						//On parcourt les zones de la nouvelle tuile
						for(int k = 0; k < v.size(); k++){
							
							//On récupère les indices de la nouvelle tuile
							Vector<Integer> indices_new_tuile = v.elementAt(k).getIndices();
							
							//Si un indice de indice_voisin correspond à l'opposé d'un indice de indices_new_tuiles, on fusionne
							for(int l = 0; l < indices_new_tuile.size(); l++){
								if(indices_voisin.contains(All_Zones_champ_tuile.getOppositeS(indices_new_tuile.elementAt(l)))){
									zones.elementAt(i).fusion(v.elementAt(k));
									break;
								}
							}
						}	
					}
				}					
			}
		}
		
		if(p.isTuileO(x, y)){
			//On parcourt toutes les zones champ du plateau
			for(int i = 0; i < zones.size(); i++){
				Vector<Zone_champ_tuile> zone_champ_plateau = zones.elementAt(i).getZones();
				
				//On regarde si la tuile voisine y est et on fusionne les zones
				for(int j = 0; j < zone_champ_plateau.size(); j++){
					if(zone_champ_plateau.elementAt(j).getC().getX() == (x-1) && 
							zone_champ_plateau.elementAt(j).getC().getY() == y){
						
						//On récupère les indices de la case voisine
						Vector<Integer> indices_voisin = zone_champ_plateau.elementAt(j).getIndices();
						
						//On parcourt les zones de la nouvelle tuile
						for(int k = 0; k < v.size(); k++){
							
							//On récupère les indices de la nouvelle tuile
							Vector<Integer> indices_new_tuile = v.elementAt(k).getIndices();
							
							//Si un indice de indice_voisin correspond à l'opposé d'un indice de indices_new_tuiles, on fusionne
							for(int l = 0; l < indices_new_tuile.size(); l++){
								if(indices_voisin.contains(All_Zones_champ_tuile.getOppositeO(indices_new_tuile.elementAt(l)))){
									zones.elementAt(i).fusion(v.elementAt(k));
									break;
								}
							}
						}	
					}
				}					
			}
		}
		
		return zones;
	}
	
}
