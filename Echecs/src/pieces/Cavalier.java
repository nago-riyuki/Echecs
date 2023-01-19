package pieces;

public class Cavalier implements IPieces {
    protected boolean blanc;
    
    public Cavalier(boolean blanc){
        this.blanc = blanc;
    }

    public String getColor(){
        return (estBlanc() ? "blanc" : "noir");
    }

    public boolean deplacementValide(int x1, int y1, int x2, int y2) {
        int xDiff = Math.abs(x1 - x2);
        int yDiff = Math.abs(y1 - y2);
        if (xDiff == 2 && yDiff == 1) {
            return true;
        }
        if (xDiff == 1 && yDiff == 2) {
            return true;
        }
        return false;
    }

	public boolean estBlanc() {
		return blanc;
	}
}
