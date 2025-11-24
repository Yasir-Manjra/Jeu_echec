public class Pion extends Piece {
    public Pion(String couleur, int x, int y) {
        super(couleur, x, y);
    }

    public boolean deplacement(Case destination) {
        int dx = destination.getX() - position.getX();
        int dy = destination.getY() - position.getY();
        int direction = couleur.equals("white") ? 1 : -1;
        int startRow = couleur.equals("white") ? 1 : 6;

        // si a deja bouger avance d'une case
        if (dx == 0 && dy == direction)
            return true;
        // sinon deux
        if (dx == 0 && dy == 2 * direction && position.getY() == startRow)
            return true;
        // capture en diagonale
        if (Math.abs(dx) == 1 && dy == direction)
            return true;

        return false;
    }

    public String toString() {
        return couleur.charAt(0) + "P";
    }
}