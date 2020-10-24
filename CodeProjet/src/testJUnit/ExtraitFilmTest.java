package testJUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import utilitaire.Outils;
import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import org.junit.Test;


class ExtraitFilmTest {

	@Test
	void testConstructeur() {
		Film d = new LaDiagonaleDuFou();
		Film f = new montage.ExtraitFilm(d, 2, 5);
		assertEquals(d.hauteur(), f.hauteur());
		assertEquals(d.largeur(), f.largeur());
	}
	
	@Test
	void testImages() {
		Film d = new LaDiagonaleDuFou();
		Film f = new montage.ExtraitFilm(d, 2, 5);
		ArrayList<char[][]> tab_d = Outils.getImages(d);
		ArrayList<char[][]> tab_f = Outils.getImages(f);
		for(int i = 0; i<4; ++i) {
			for(int z = 0; z<d.hauteur(); ++z) {
				for (int p = 0; p< d.largeur(); ++p) {
					assertEquals(tab_d.get(i+2)[z][p], tab_f.get(i)[z][p]);
				}
			}
		}
	}
	
	@Test
	void testExtraitNul() {
		Film d = new LaDiagonaleDuFou();
		Film f = new montage.ExtraitFilm(d, -2, -5);
		char[][] ecran = Films.getEcran(f);
		assertFalse(f.suivante(ecran));
		f = new montage.ExtraitFilm(d, 2, -5);
		assertFalse(f.suivante(ecran));
		f = new montage.ExtraitFilm(d, -2, 5);
		assertFalse(f.suivante(ecran));
		f = new montage.ExtraitFilm(d, 4, 1);
		assertFalse(f.suivante(ecran));
	}
	
}