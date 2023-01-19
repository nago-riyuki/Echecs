package pieces;

public class Tour implements IPieces {
    protected boolean blanc;

    public Tour(boolean blanc) {
        this.blanc = blanc;
    }

    public String getColor(){
        return (estBlanc() ? "blanc" : "noir");
    }
    public boolean deplacementValide(int x1, int y1, int x2, int y2) {
        if (x1 == x2 || y1 == y2) {
            return true;
        }
        return false;
    }

	public boolean estBlanc() {
		return blanc;
	}
}