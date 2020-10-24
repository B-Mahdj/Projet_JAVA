package montage;

import film.Film;
import film.Films;

/**
 * Classe qui permet d'encadrer les images d'un Film par des * via la délégation
 * JaVa
 */
public class Encadrement implements Film {
	Film delegue;

	public Encadrement(Film f) {
		this.delegue = f;
	}

	public int hauteur() {
		return delegue.hauteur() + 2; //+2 pour la place des *
	}

	public int largeur() {
		return delegue.largeur() + 2; //+2 pour la place des *
	}

	public boolean suivante(char[][] ecran) {
		char[][] ecran_base = Films.getEcran(delegue);
		if (delegue.suivante(ecran_base)) { // L'image du Film non encadre
			for (int i = 0; i < this.largeur(); ++i) { //Encadrement sur la largeur
				ecran[0][i] = '*';
				ecran[hauteur() - 1][i] = '*';
			}
			for (int i = 0; i < this.hauteur(); ++i) { //Encadrement sur la hauteur
				ecran[i][0] = '*';
				ecran[i][largeur() - 1] = '*';
			}

			for (int i = 1; i < delegue.hauteur() + 1; ++i) { //Copie de l'image de base dans l'écran encadré
				for (int z = 1; z < delegue.largeur() + 1; ++z) {
					ecran[i][z] = ecran_base[i - 1][z - 1];
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public void rembobiner() {
		delegue.rembobiner();
	}
}
