public class Roi extends Piece {
    public Roi(String couleur, int x, int y) {
        super(couleur, x, y);
    }

    public boolean deplacement(Case destination) {
        int dx = Math.abs(destination.getX() - position.getX());
        int dy = Math.abs(destination.getY() - position.getY());
        return (dx <= 1 && dy <= 1) && (dx + dy != 0);
    }

    public String toString() {
        return couleur.charAt(0) + "R";
    }
}