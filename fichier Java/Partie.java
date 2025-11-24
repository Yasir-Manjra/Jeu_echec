import java.util.Scanner;

public class Partie {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Echequier plateau = new Echequier();

        // Demande le nom des joueurs
        System.out.print("Nom du joueur blanc : ");
        String nomBlanc = scanner.nextLine();
        System.out.print("Nom du joueur noir : ");
        String nomNoir = scanner.nextLine();

        Joueur joueurBlanc = new Joueur(nomBlanc, "white");
        Joueur joueurNoir = new Joueur(nomNoir, "black");
        Joueur joueurActuel = joueurBlanc;

        boolean continuer = true;

        System.out.println("Bienvenue sur le jeu d'echecs !");
        System.out.println("Format des coordonnees : x y (ex: 0 1)");
        System.out.println("x = colonne 0 a 7, y = ligne 0 a 7, (0,0) en bas a gauche.");
        System.out.println("(7,7) en haut a droite , et 'exit' pour quitter le jeu.");

        while (continuer) {
            // Affichage du plateau
            System.out.println("\nPlateau actuel :");
            plateau.printEchequier();
            System.out.println("\nC'est au tour de " + joueurActuel.getNom() + " (" + joueurActuel.getCouleur() + ")");

            // Saisie du coup
            System.out.print(
                    "Entrez les coordonnees de la piece a deplacer (x y), 'h' pour l'historique ou 'exit' pour quitter : ");
            String entree = scanner.nextLine();
            if (entree.equalsIgnoreCase("exit")) {
                continuer = false;
                break;
            }
            if (entree.equalsIgnoreCase("h") || entree.equalsIgnoreCase("historique")) {
                System.out.println("\nHistorique des coups :");
                for (String coup : plateau.getHistorique()) {
                    System.out.println(coup);
                }
                continue;
            }

            String[] debutCoords = entree.trim().split("\\s+");
            if (debutCoords.length != 2) {
                System.out.println("Entree invalide. Reessayez.");
                continue;
            }

            int debutX, debutY;
            try {
                debutX = Integer.parseInt(debutCoords[0]);
                debutY = Integer.parseInt(debutCoords[1]);
            } catch (NumberFormatException e) {
                System.out.println("Coordonnees invalides. Reessayez.");
                continue;
            }

            Piece piece = plateau.getPiece(debutX, debutY);
            if (piece == null) {
                System.out.println("Aucune piece a cette position.");
                continue;
            }
            if (!piece.getCouleur().equals(joueurActuel.getCouleur())) {
                System.out.println("Ce n'est pas votre piece !");
                continue;
            }

            System.out.print("Entrez les coordonnees d'arrivee (x y) : ");
            String[] finCoords = scanner.nextLine().trim().split("\\s+");
            if (finCoords.length != 2) {
                System.out.println("Entree invalide. Reessayez.");
                continue;
            }

            int finX, finY;
            try {
                finX = Integer.parseInt(finCoords[0]);
                finY = Integer.parseInt(finCoords[1]);
            } catch (NumberFormatException e) {
                System.out.println("Coordonnees invalides. Reessayez.");
                continue;
            }

            Case destination = new Case(finX, finY);
            if (!plateau.coupValide(piece, destination)) {
                System.out.println("Coup invalide selon les regles ou obstacles.");
                continue;
            }

            Piece capturee = plateau.getPiece(finX, finY);

            plateau.getPiece(debutX, debutY).setPosition(destination);
            plateau.setPiece(finX, finY, piece);
            plateau.setPiece(debutX, debutY, null);

            if (capturee != null) {
                plateau.enregistrerCoup(piece, new Case(debutX, debutY), destination, capturee);
            } else {
                plateau.enregistrerCoup(piece, new Case(debutX, debutY), destination);
            }

            // change le joueur
            joueurActuel = (joueurActuel == joueurBlanc) ? joueurNoir : joueurBlanc;
        }

        System.out.println("Merci d'avoir joue !");
        System.out.println("\nHistorique des coups :");
        for (String coup : plateau.getHistorique()) {
            System.out.println(coup);
        }
        scanner.close();
    }
}