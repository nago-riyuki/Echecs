package echecs;

import java.util.Scanner;

import pieces.Fou;
import pieces.Roi;
import pieces.Cavalier;
import pieces.Pion;
import pieces.IPieces;
import pieces.Reine;
import pieces.Tour;

public class Echequier {
    private static int taille;
    private static IPieces[][] plateau;
    private static final Scanner SCANNER = new Scanner(System.in);

    public Echequier(int taille)
    {
        Echequier.taille = taille;
        plateau = new IPieces[taille][taille];
    }

    private void creerPlateau(){

        for (int i = 0; i < taille; i++) {
            for (int j = 0; j < taille; j++) {
                plateau[i][j] = null;
            }
        }
        // Initialisation des pièces
        plateau[0][0] = new Tour(true);
        plateau[0][1] = new Cavalier(true);
        plateau[0][2] = new Fou(true);
        plateau[0][3] = new Reine(true);
        plateau[0][4] = new Roi(true);
        plateau[0][5] = new Fou(true);
        plateau[0][6] = new Cavalier(true);
        plateau[0][7] = new Tour(true);
        
        plateau[taille-1][0] = new Tour(false);
        plateau[taille-1][1] = new Cavalier(false);
        plateau[taille-1][2] = new Fou(false);
        plateau[taille-1][3] = new Reine(false);
        plateau[taille-1][4] = new Roi(false);
        plateau[taille-1][5] = new Fou(false);
        plateau[taille-1][6] = new Cavalier(false);
        plateau[taille-1][7] = new Tour(false);

        for (int i = 0; i < taille; i++) {
            plateau[1][i] = new Pion(true);
            plateau[taille - 2][i] = new Pion(false);
        }
    }

    public void partie(){
    	
        creerPlateau();

        boolean tourDeBlanc = true;
        boolean passer = false;
        while (true) {
            System.out.println(afficherPlateau());
            System.out.print((tourDeBlanc ? "Joueur blanc" : "Joueur noir")+ ":");
            String input = SCANNER.nextLine();
            String[] positions = input.split(" a ");
            if (positions.length != 2) {
                System.out.println("Position invalide");
                continue;
            }
            String piece = positions[0];
            String deplacement = positions[1];
            int x1 = piece.charAt(0) - 'A';
            int y1 = Integer.parseInt(piece.substring(1)) - 1;

            if (x1 < 0 || x1 >= taille || y1 < 0 || y1 >= taille) {
                System.out.println("Déplacement invalide");
                continue;
            }
            int x2 = deplacement.charAt(0) - 'A';
            int y2 = Integer.parseInt(deplacement.substring(1)) - 1;

            // vérifier qu'il y a une pièce sur la position qu'on souhaite déplacer
            if (plateau[y1][x1] == null) {
                System.out.println("Il n'y a pas de piece à cette endroit");
                System.out.println();
                continue;
            }

            // vérifier si le déplacement est correcte
            if (!plateau[y1][x1].deplacementValide(x1, y1, x2, y2)) {
                System.out.println("Déplacement invalide");
                continue;
            }
            
            // vérifier si on se déplace pas sur une position de la même couleur
            if(plateau[y2][x2] != null && (plateau[y1][x1]).getColor() == (plateau[y2][x2]).getColor()){
                System.out.println("Déplacement invalide");
                continue;
            }

                    // Permet de voir si il y a un obstacle
        if(plateau[y1][x1] instanceof Tour || plateau[y1][x1] instanceof Reine) {
            if(x1 == x2) { // Déplacement verticale
                int minY = Math.min(y1, y2);
                int maxY = Math.max(y1, y2);
                for (int y = minY + 1; y < maxY; y++) {
                    if (plateau[y][x1] != null) {
                        System.out.println("Déplacement invalide");
                        passer = true;
                        continue;
                    }
                }
            } else if (y1 == y2) { // Déplacement horizontale
                int minX = Math.min(x1, x2);
                int maxX = Math.max(x1, x2);
                for (int x = minX + 1; x < maxX; x++) {
                    if (plateau[y1][x] != null) {
                        System.out.println("Déplacement invalide");
                        passer = true;
                        continue;
                    }
                }
            } else { // Déplacement diagonale
                int xDiff = x2 - x1;
                int yDiff = y2 - y1;
                int xDirection = xDiff / Math.abs(xDiff);
                int yDirection = yDiff / Math.abs(yDiff);
                int x = x1 + xDirection;
                int y = y1 + yDirection;
                while (x != x2 && y != y2) {
                    if (plateau[y][x] != null) {
                        System.out.println("Déplacement invalide");
                        passer = true;
                        break;
                    }
                    x += xDirection;
                    y += yDirection;
                }
            }
        }
        else if (plateau[y1][x1] instanceof Fou) {
            int xDiff = x2 - x1;
            int yDiff = y2 - y1;
            int xDirection = xDiff / Math.abs(xDiff);
            int yDirection = yDiff / Math.abs(yDiff);
            int x = x1 + xDirection;
            int y = y1 + yDirection;
            while (x != x2 && y != y2) {
                if (plateau[y][x] != null) {
                    System.out.println("Déplacement invalide");
                    passer = true;
                    break;
                }
                x += xDirection;
                y += yDirection;
            }
        }
            // Déplacer la pièce
            if(!passer){
                plateau[y2][x2] = plateau[y1][x1];
                plateau[y1][x1] = null;
                tourDeBlanc = !tourDeBlanc;
            }
        }
    }
    
    public static String afficherPlateau() {
    	String s = "";
        for (int i = taille - 1; i >= 0; i--) {
            s+=((i + 1) + " ");
            for (int j = 0; j < taille; j++) {
                if (plateau[i][j] == null) {
                	s+=("- ");
                } else if (plateau[i][j] instanceof Pion) {
                	s+=((((Pion) plateau[i][j]).estBlanc() ? "P " : "p "));
                } else if (plateau[i][j] instanceof Tour) {
                	s+=((((Tour) plateau[i][j]).estBlanc() ? "T " : "t "));
                } else if (plateau[i][j] instanceof Cavalier) {
                	s+=((((Cavalier) plateau[i][j]).estBlanc() ? "C " : "c "));
                } else if (plateau[i][j] instanceof Fou) {
                	s+=((((Fou) plateau[i][j]).estBlanc() ? "F " : "f "));
                } else if (plateau[i][j] instanceof Reine) {
                	s+=((((Reine) plateau[i][j]).estBlanc() ? "R " : "r "));
                } else if (plateau[i][j] instanceof Roi) {
                	s+=((((Roi) plateau[i][j]).estBlanc() ? "K " : "k "));
                }
            }
            s+="\n";
        }
        s+="  ";
        for (int i = 0; i < taille; i++) {
        	s+=((char) ('A' + i) + " ");
        }
        s+="\n";
        
        return s;
    }
}
