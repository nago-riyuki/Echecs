package piecesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.IPieces;
import pieces.Pion;
import pieces.Reine;

class ReineTest {

	@Test
	void test() {
		IPieces[][] plateau;
        plateau = new IPieces[8][8];
        
		plateau[0][0] = new Reine(true);
        
        assertEquals("blanc", plateau[0][0].getColor());
		assertTrue(plateau[0][0].deplacementValide(0, 0, 0, 5));
		assertFalse(plateau[0][0].deplacementValide(0, 0, 1, 3));
		assertTrue(plateau[0][0].deplacementValide(0, 0, 4, 4));

	}

}
