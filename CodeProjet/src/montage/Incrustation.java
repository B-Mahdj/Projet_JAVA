package montage;

import film.Film;
import film.Films;
import utilitaire.Outils;

/**
 * Classe permettant d'incruster les images d'un film dans un autre à une
 * certaine position (x,y) de l'ecran
 */
public class Incrustation implements Film {
	private Film f1;
	private Film f2;
	private int taille_f1;
	private int taille_f2;
	private int li;
	private int co;
	private int num = 0;

	public Incrustation(Film f, Film g, int li, int co) {
		this.f1 = f;
		this.f2 = g;
		this.taille_f1 = Outils.getnbImages(f);
		this.taille_f2 = Outils.getnbImages(g);
		
		//Si un des indices est négatif, sa valeur devient nulle
		if (li < 0) {
			this.li = 0;
		} else {
			this.li = li;
		}
		if (co < 0) {
			this.co = 0;
		} else {
			this.co = co;
		}
	}

	public int hauteur() {
		return f1.hauteur();
	}

	public int largeur() {
		return f1.largeur();
	}

	public boolean suivante(char[][] ecran) {
		if (num < taille_f1) { // Tant que f1 n'est pas vide, on continue
			if (num < taille_f2) { // On peut incruster l'image de f2 dans f1
				char[][] ecran_2 = Films.getEcran(f2);
				f2.suivante(ecran_2); 
				f1.suivante(ecran);
				for (int i = li; i < f1.hauteur() && i - li < f2.hauteur(); ++i) {
					for (int z = co; z < f1.largeur() && z - co < f2.largeur(); ++z) {
						ecran[i][z] = ecran_2[i - li][z - co]; //Incrustation
					}
				}
				++num;
				return true;
			} else { // On ne peut pas incruster l'image de f2 dans f1
				f1.suivante(ecran);
				++num;
				return true;
			}
		}
		// f1 est vide
		return false;
	}

	public void rembobiner() {
		this.num = 0;
		f1.rembobiner();
		f2.rembobiner();
	}
}
