package application;

import film.Film;

/**
* Classe permettant le montage de Film via des appels à des constructeurs
* de classe situés dans le paquetage montage
* **/

public class Montage {
	/**
	 * Methode permettant de retourner un Film qui sera le Film f donne repeter un
	 * nombre n de fois
	 * 
	 * @param f Le film a repeter
	 * @param n Le nombre de fois a repeter le Film
	 * @return Le film f repeter n fois
	 */
	public static Film Repetition(Film f, int n) {
		Film ff = new montage.Repetition(f, n);
		return ff;
	}

	/**
	 * Methode permettant de retourner un Film qui sera l'extrait du Film f donne
	 * entre les numeros donnes en parametre
	 * 
	 * @param f Le film d'ou prendre l'extrait
	 * @param d L'indice de la première image ou commencer l'extrait
	 * @param e L'indice de la deuxième image ou finir l'extrait
	 * @return L'extrait du Film f
	 */
	public static Film ExtraitFilm(Film f, int d, int e) {
		Film ff = new montage.ExtraitFilm(f, d, e);
		return ff;
	}

	/**
	 * Methode permettant de retourner un Film qui sera le Film f donne en parametre
	 * encadre par des *
	 * 
	 * @param f Le film f a encadrer
	 * @return Film f encadre par des *
	 */
	public static Film Encadrement(Film f) {
		Film ff = new montage.Encadrement(f);
		return ff;
	}

	/**
	 * Methode permettant de coller 2 films l'un a la suite de l'autre dans un
	 * nouveau film et de retourner ce film
	 * 
	 * @param f Le premier film a coller
	 * @param g Le second film a coller a la suite du premier
	 * @return Le film qui colle les 2 films donnes en parametre
	 */
	public static Film Collage(Film f, Film g) {
		Film ff = new montage.Collage(f, g);
		return ff;
	}

	/**
	 * Methode permettant d'incruster les images d'un film dans un autre a la
	 * position donne en parametre
	 * 
	 * @param f  Film de base ou incruster les images
	 * @param g  Second Film d'ou les images incrustees viennent
	 * @param li Indice x de la position ou incruster les images
	 * @param co Indice y de la position ou incruster les images
	 * @return Le film de base f avec les images du film g incruste a la position
	 *         (li, co) de chaque image
	 */
	public static Film Incrustation(Film f, Film g, int li, int co) {
		Film ff = new montage.Incrustation(f, g, li, co);
		return ff;
	}
}
