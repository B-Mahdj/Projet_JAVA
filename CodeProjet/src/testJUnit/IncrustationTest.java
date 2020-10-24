package testJUnit;

import static org.junit.Assert.*;
import utilitaire.Outils;
import film.Film;
import film.Films;
import java.util.ArrayList;
import org.junit.Test;
import exemple.LaDiagonaleDuFou;
import montage.Incrustation;

class IncrustationTest {

	@Test
	void testImages() {
		Film f = new LaDiagonaleDuFou();
		Film d = new LaDiagonaleDuFou();
		int li = 2;
		int co = 2;
				
		Film n = new Incrustation(f, d, li, co);
		
		ArrayList<char[][]> tab_d = Outils.getImages(d);
		ArrayList<char[][]> tab_n = Outils.getImages(n);
		
		for(int g = 0; g<Outils.getnbImages(n); ++g) {
			for (int i = li; i < n.hauteur(); ++i) {
				for (int z = co; z < n.largeur() ; ++z) {
					assertEquals(tab_n.get(g)[i][z],tab_d.get(g)[i - li][z - co]); 
				}
			}
		}
	}
	
	@Test
	void testFilmOuIncrusterVide() {
		Film d = new LaDiagonaleDuFou();
		Film f = new LaDiagonaleDuFou();
		char[][] ecran = Films.getEcran(f);
		while(f.suivante(ecran)) {
		}
		int li = 1;
		int co = 1;
		Film n = new Incrustation(f, d, li, co);
		
		assertFalse(n.suivante(ecran));
		
	}
	
	@Test 
	void testFilmAIncrusterVide() {
		Film d = new LaDiagonaleDuFou();
		Film f = new LaDiagonaleDuFou();
		
		char[][] ecran = Films.getEcran(d);
		while(d.suivante(ecran)) {
		}
		Film n = new Incrustation(f, d, 1, 1);
		
		ArrayList<char[][]> tab_n = Outils.getImages(n);
		ArrayList<char[][]> tab_f = Outils.getImages(f);
		
		for(int g = 0; g<Outils.getnbImages(n); ++g) {
				for (int z = 0; z < n.largeur() ; ++z) {
					assertEquals(tab_n.get(g)[g][z],tab_f.get(g)[g][z]); 
				}
		}
		
	}
}

