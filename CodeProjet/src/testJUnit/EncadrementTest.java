package testJUnit;

import org.junit.Test;
import montage.Encadrement;
import utilitaire.Outils;
import exemple.LaDiagonaleDuFou;
import film.Film;
import static org.junit.Assert.*;

class EncadrementTest {

	@Test
	void testConstructeur() {
		Film d = new LaDiagonaleDuFou();
		Film f = new Encadrement(d);
		assertEquals(d.hauteur(), f.hauteur() - 2 );
		assertEquals(d.largeur(), f.largeur() - 2);
	}
	
	@Test
	void testNbImages() {
		Film d = new LaDiagonaleDuFou();
		Film f = new Encadrement(d);
		assertEquals(Outils.getnbImages(d), Outils.getnbImages(f));	
	}
	
	

}
