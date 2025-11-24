public class Case {
    private int x, y;

    public Case(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (this == obj)
            return true;

        if (obj.getClass() != this.getClass())
            return false;

        Case c = (Case) obj;
        return this.x == c.x && this.y == c.y;
    }

    // Retourne la coordonnée au format échiquéen (A1..H8)
    public String toChessCoord() {
        char file = (char) ('A' + this.x);
        int rank = this.y + 1;
        return String.format("%c%d", file, rank);
    }

}