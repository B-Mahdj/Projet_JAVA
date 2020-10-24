package montage;

import film.Film;
import film.Films;

/**
 * Classe permettant d'obtenir un extrait d'un Film via la délégation JaVa
 */
public class ExtraitFilm implements Film {
	private Film delegue;
	private int img_1;
	private int img_2;
	private int num = 0;

	public ExtraitFilm(Film f, int img1, int img2) {
		delegue = f;
		this.img_1 = img1;
		this.img_2 = img2;
	}

	public int hauteur() {
		return delegue.hauteur();
	}

	public int largeur() {
		return delegue.largeur();
	}

	public boolean suivante(char[][] ecran) {
		// Si img_2 < img_1, le film doit etre vide
		if (img_2 < img_1) {
			return false;
		} else {
			while (num < img_1) { //Pas encore arrivé à l'image du premier indice
				delegue.suivante(ecran);
				Films.effacer(ecran);
				++num;
			}
			if (num <= img_2 && delegue.suivante(ecran)) { //Entre l'image du 1er indice et du 2nd
				++num;
				return true;
			}
			return false;
		}
	}

	public void rembobiner() {
		delegue.rembobiner();
		this.num = 0;
	}

}
