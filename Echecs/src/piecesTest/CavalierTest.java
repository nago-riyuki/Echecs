package piecesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.Cavalier;
import pieces.IPieces;
import pieces.Tour;

class CavalierTest {

	@Test
	void test() {
		IPieces[][] plateau;
        plateau = new IPieces[8][8];

		plateau[0][0] = new Cavalier(true);
		
		assertEquals("blanc", plateau[0][0].getColor());
		assertTrue(plateau[0][0].deplacementValide(0, 0, 2, 1));
		assertFalse(plateau[0][0].deplacementValide(0, 0, 3, 3));
	}

}
