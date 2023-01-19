package pieces;

public class Fou implements IPieces {
    protected boolean blanc;
    
    public Fou(boolean white){
        this.blanc = white;
    }

    public String getColor(){
        return (estBlanc() ? "blanc" : "noir");
    }

    public boolean deplacementValide(int x1, int y1, int x2, int y2) {
        int xDiff = Math.abs(x1 - x2);
        int yDiff = Math.abs(y1 - y2);
        if (xDiff == yDiff) {
            return true;
        }
        return false;
    }

	public boolean estBlanc() {
		return blanc;
	}
}
