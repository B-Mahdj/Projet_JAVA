package utilitaire;

import film.Film;
import java.util.ArrayList;
import film.Films;
/**
 * Classe contenant des méthodes utilitaires pour le projet 
 * et les tests JUnit
 */
public class Outils {

	/**
	 * Methode permetant de recuperer le nombre d'images d'un film f en parametre
	 * 
	 * @param f : le film dont on veut recuperer le nombre d'image
	 *
	 * @return le nombre d'images du film f
	 */
	public static int getnbImages(Film f) {
		char tab[][] = Films.getEcran(f);
		int n = 0;
		while (f.suivante(tab)) {
			n++;
		}
		f.rembobiner();
		return n;
	}

	/**
	 * Methode permetant de recuperer les images d'un film f en paramètre
	 * 
	 * @param f : le film dont on veut recuperer les images
	 *
	 * @return un tableau contenant les images du film f
	 */
	public static ArrayList<char[][]> getImages(Film f) {
		ArrayList<char[][]> tab = new ArrayList<char[][]>();
		char[][] ecran = Films.getEcran(f);
		while (f.suivante(ecran)) {
			tab.add(ecran);
			ecran = Films.getEcran(f);
			Films.effacer(ecran);
		}
		f.rembobiner();
		return tab;
	}
}
