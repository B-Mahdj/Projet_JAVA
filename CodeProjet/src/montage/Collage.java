package montage;

import film.Film;
import utilitaire.Outils;

/**
 * Classe implementant l'interface Film et permettant de coller 2 films l'un à
 * la suite de l'autre via la delegation JaVa
 */
public class Collage implements Film {
	private Film film1;
	private Film film2;
	private int hauteur;
	private int largeur;
	private int nbImages_f1;
	private int nbImages_f2;
	private int num = 0;

	public Collage(Film f, Film g) {
		film1 = f;
		film2 = g;
		// Hauteur & Largeur doivent etre capables de contenir
		// les 2 films
		if (f.hauteur() > g.hauteur()) {
			this.hauteur = f.hauteur();
		} else {
			this.hauteur = g.hauteur();
		}
		if (f.largeur() > g.largeur()) {
			this.largeur = f.largeur();
		} else {
			this.largeur = g.largeur();
		}

		nbImages_f1 = Outils.getnbImages(film1);
		nbImages_f2 = Outils.getnbImages(film2);
	}

	public int hauteur() {
		return this.hauteur;
	}

	public int largeur() {
		return this.largeur;
	}

	public boolean suivante(char[][] ecran) {
		if (num < nbImages_f1) { //Pas encore fini d'afficher le film 1
			film1.suivante(ecran);
			++num;
			return true;
		} else if (num == nbImages_f1) { //Quand on a fini d'afficher le film 1, 
			film1.rembobiner();			 //on le rembobine pour éviter le problème
		}								 //de références partagées 
		if (num < nbImages_f1 + nbImages_f2) { //Affiche le film 2
			film2.suivante(ecran);
			++num;
			return true;
		}
		return false;  //Fini d'afficher film1 & film 2
	}

	public void rembobiner() {
		this.film1.rembobiner(); 
		this.film2.rembobiner();
		num = 0;
	}
}
