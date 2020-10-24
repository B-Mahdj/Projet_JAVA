package montage;

import film.Film;

/**
 * Classe permettant de repeter un Film donne un nombre n de fois
 */
public class Repetition implements Film {
	Film delegue;
	private int n; // Nombre de répétitions du film que l'on veut répéter
	private int num = 0; // Nombre de fois ou le film a été répété

	public Repetition(Film f, int n) {
		delegue = f;
		this.n = n;
	}

	/**
	 * Indique la hauteur des images de ce film (en nombre de caractères).
	 * 
	 * @return Hauteur minimale de l'écran pour pouvoir afficher les images de ce
	 *         film.
	 */
	public int hauteur() {
		return delegue.hauteur();
	}

	/**
	 * Indique la largeur des images de ce film (en nombre de caractères).
	 * 
	 * @return largeur minimale de l'écran pour pouvoir afficher les images de ce
	 *         film.
	 */
	public int largeur() {
		return delegue.largeur();
	}

	/**
	 * Obtenir l'image suivante (s'il y en a une).
	 * 
	 * @param écran L'écran ou afficher l'image
	 * @return vrai Si l'image suivante a été affichée sur l'écran tant que le
	 *         film n'a été répété n fois et faux si le film est terminé
	 * 
	 */
	public boolean suivante(char[][] ecran) {
		if (n <= 0) { //Film qu'on veut repeter un nombre n�gatif de fois ou 0 fois
			return false; // = un Film vide
		}

		else if (delegue.suivante(ecran)) {
			return true;
		}

		else {
			if (num != n - 1) { //Pas repeter le film le nombre de fois voulu
				delegue.rembobiner(); //On recommence 
				++num;
				if (delegue.suivante(ecran)) {
					return true;
				}
			}
			return false;
		}
	}

	/**
	 * Rembobine le film en permettant de rejouer le film dans sa totalité (via des
	 * appels successifs à la méthode suivante()).
	 */
	public void rembobiner() {
		delegue.rembobiner();
		this.num = 0;
	}

}
