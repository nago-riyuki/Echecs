package piecesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.Fou;
import pieces.IPieces;
import pieces.Pion;

class PionTest {

	@Test
	void test() {
		IPieces[][] plateau;
        plateau = new IPieces[8][8];
        
		plateau[0][0] = new Pion(true);
        
        assertEquals("blanc", plateau[0][0].getColor());
		assertTrue(plateau[0][0].deplacementValide(0, 0, 0, 1));
		assertFalse(plateau[0][0].deplacementValide(0, 0, 0, 2));
		
	}

}
