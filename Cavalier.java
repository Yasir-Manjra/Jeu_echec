public class Cavalier extends Piece {
    public Cavalier(String couleur, int x, int y) {
        super(couleur, x, y);
    }

    public boolean deplacement(Case destination) {
        int dx = Math.abs(destination.getX() - position.getX());
        int dy = Math.abs(destination.getY() - position.getY());
        return (dx == 2 && dy == 1) || (dx == 1 && dy == 2);
    }

    public String toString() {
        return couleur.charAt(0) + "C";
    }
}