public class Fou extends Piece {
    public Fou(String couleur, int x, int y) {
        super(couleur, x, y);
    }

    public boolean deplacement(Case destination) {
        int dx = Math.abs(destination.getX() - position.getX());
        int dy = Math.abs(destination.getY() - position.getY());
        return dx == dy && dx != 0;
    }

    public String toString() {
        return couleur.charAt(0) + "F";
    }
}