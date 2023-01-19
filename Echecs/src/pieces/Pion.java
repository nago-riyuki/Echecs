package pieces;

public class Pion implements IPieces {
    protected boolean blanc;

    public Pion(boolean blanc) {
        this.blanc = blanc;
    }

    public String getColor(){
        return (estBlanc() ? "blanc" : "noir");
    }

    public boolean deplacementValide(int x1, int y1, int x2, int y2) {
        if (estBlanc()) {
            if (x1 == x2 && y2 == y1 + 1) {
                return true;
            }
        } else {
            if (x1 == x2 && y2 == y1 - 1) {
                return true;
            }
        }
        return false;
    }

	public boolean estBlanc() {
		return blanc;
	}
}
