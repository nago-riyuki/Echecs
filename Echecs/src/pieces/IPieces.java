package pieces;

public interface IPieces {
    boolean deplacementValide(int x1, int y1, int x2, int y2);
    String getColor();
}