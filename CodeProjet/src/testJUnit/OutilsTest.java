package testJUnit;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import exemple.LaDiagonaleDuFou;
import film.Film;
import film.Films;
import utilitaire.Outils;

import java.util.ArrayList;

class OutilsTest {
	
	// Objectif : V�rifier que l'on obtient bien le meme nombre d'images du film
	@Test
	void testgetnbImages() {
		Film d = new LaDiagonaleDuFou();
		assertEquals(20, Outils.getnbImages(d));
	}

	// Objectif : V�rifier que les images r�cup�rables sont les memes 
	@Test
	void testgetImages() {
		Film d = new LaDiagonaleDuFou();
		ArrayList<char[][]> tab = Outils.getImages(d);
		char[][] ecran = Films.getEcran(d);
		for(int i = 0; i<20; ++i) {
			Films.effacer(ecran);
			d.suivante(ecran);
			for(int z = 0; z<d.hauteur(); ++z) {
				for (int p = 0; p<d.largeur(); ++p) {
					assertEquals(ecran[z][p], tab.get(i)[z][p]);
				}
			}
		}
	}

}
