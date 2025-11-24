import java.util.ArrayList;

public class Echequier {

    private Piece[][] plateau = new Piece[8][8];
    private ArrayList<String> historique = new ArrayList<>();

    public Echequier() {
        // j'ai préféré mettre les nom des couleurs en anglais car on code en anglais
        for (int x = 0; x < 8; x++) {
            plateau[x][1] = new Pion("white", x, 1);
        }

        for (int x = 0; x < 8; x++) {
            plateau[x][6] = new Pion("black", x, 6);
        }

        plateau[0][0] = new Tour("white", 0, 0);
        plateau[7][0] = new Tour("white", 7, 0);
        plateau[0][7] = new Tour("black", 0, 7);
        plateau[7][7] = new Tour("black", 7, 7);

        plateau[1][0] = new Cavalier("white", 1, 0);
        plateau[6][0] = new Cavalier("white", 6, 0);
        plateau[1][7] = new Cavalier("black", 1, 7);
        plateau[6][7] = new Cavalier("black", 6, 7);

        plateau[3][0] = new Reine("white", 3, 0);
        plateau[3][7] = new Reine("black", 3, 7);

        plateau[4][0] = new Roi("white", 4, 0);
        plateau[4][7] = new Roi("black", 4, 7);

        plateau[2][0] = new Fou("white", 2, 0);
        plateau[5][0] = new Fou("white", 5, 0);
        plateau[2][7] = new Fou("black", 2, 7);
        plateau[5][7] = new Fou("black", 5, 7);

    }

    // Récupère la pièce à la position (x, y)
    // Sinon la position est hors du plateau donc -> null
    public Piece getPiece(int x, int y) {
        if (x < 0 || x >= 8 || y < 0 || y >= 8)
            return null;
        return plateau[x][y];
    }

    public boolean coupValide(Piece piece, Case destination) {
        if (destination.getX() < 0 || destination.getX() >= 8 || destination.getY() < 0 || destination.getY() >= 8)
            return false;

        if (!piece.deplacement(destination))
            return false;

        Piece cible = getPiece(destination.getX(), destination.getY());
        if (cible != null && cible.getCouleur().equals(piece.getCouleur()))
            return false;

        String nomClasse = piece.getClass().getSimpleName();
        if (!nomClasse.equals("Cavalier")) {
            if (!cheminLibre(piece.getPosition(), destination)) {
                return false;
            }
        }
        return true;
    }

    private boolean cheminLibre(Case depart, Case arrivee) {
        int dx = Integer.compare(arrivee.getX(), depart.getX());
        int dy = Integer.compare(arrivee.getY(), depart.getY());

        int x = depart.getX() + dx;
        int y = depart.getY() + dy;

        while (x != arrivee.getX() || y != arrivee.getY()) {
            if (getPiece(x, y) != null) {
                return false;
            }
            x += dx;
            y += dy;
        }
        return true;
    }

    public void setPiece(int x, int y, Piece p) {
        if (x >= 0 && x < 8 && y >= 0 && y < 8) {
            plateau[x][y] = p;
        }
    }

    public void enregistrerCoup(Piece piece, Case depart, Case arrivee) {
        String coup = piece.getClass().getSimpleName() + " " + piece.getCouleur() +
            " de " + depart.toChessCoord() + " à " + arrivee.toChessCoord();
        historique.add(coup);

    }

    // si une piece a été capturé
    public void enregistrerCoup(Piece piece, Case depart, Case arrivee, Piece capture) {
        String coup = piece.getClass().getSimpleName() + " " + piece.getCouleur() +
                " de " + depart.toChessCoord() + " à " + arrivee.toChessCoord();
        if (capture != null) {
            coup += " et capture " + capture.getClass().getSimpleName() + " " + capture.getCouleur();
        }
        historique.add(coup);
    }

    public ArrayList<String> getHistorique() {
        return historique;
    }

    public void printEchequier() {
        // Affiche les indices de colonnes
        System.out.print("   ");
        for (int x = 0; x < 8; x++) {
            char file = (char) ('A' + x);
            System.out.print(file + "  ");
        }
        System.out.println();
        for (int y = 7; y >= 0; y--) {
            // Affiche le numéro de rangée (1..8) avec le rang 8 en haut
            System.out.print((y + 1) + " |");
            for (int x = 0; x < 8; x++) {
                Piece p = getPiece(x, y);
                if (p == null) {
                    System.out.print("-- ");
                } else {
                    System.out.print(p.toString() + " ");
                }
            }
            System.out.println();
        }
    }
}