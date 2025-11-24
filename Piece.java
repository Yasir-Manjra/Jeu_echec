public abstract class Piece {
    protected String couleur;
    protected Case position;

    public Piece(String couleur, int x, int y) {
        this.couleur = couleur;
        this.position = new Case(x, y);
    }

    public String getCouleur() {
        return couleur;
    }

    public Case getPosition() {
        return position;
    }

    public void setPosition(Case nouvelle) {
        this.position = nouvelle;
    }

    public abstract boolean deplacement(Case destination);

    public abstract String toString();
}