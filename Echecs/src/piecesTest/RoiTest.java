package piecesTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import pieces.IPieces;
import pieces.Reine;
import pieces.Roi;

class RoiTest {

	@Test
	void test() {
		IPieces[][] plateau;
        plateau = new IPieces[8][8];
        
        plateau[0][0] = new Roi(true);
        
        assertEquals("blanc", plateau[0][0].getColor());
		assertTrue(plateau[0][0].deplacementValide(0, 0, 1, 1));
		assertFalse(plateau[0][0].deplacementValide(0, 0, 0, 2));
		assertTrue(plateau[0][0].deplacementValide(0, 0, 0, 1));
        
	}

}
