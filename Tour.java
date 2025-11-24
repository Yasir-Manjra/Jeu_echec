public class Tour extends Piece {
    public Tour(String couleur, int x, int y) {
        super(couleur, x, y);
    }

    public boolean deplacement(Case destination) {
        int dx = destination.getX() - position.getX();
        int dy = destination.getY() - position.getY();
        // Déplacement horizontal ou vertical, mais pas les deux
        return (dx == 0 && dy != 0) || (dx != 0 && dy == 0);
    }

    public String toString() {
        return couleur.charAt(0) + "T";
    }
}