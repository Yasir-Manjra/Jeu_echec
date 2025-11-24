# Jeu d’Échecs en Java

### Documentation et Règles

## Bienvenue

Ce jeu respecte les règles classiques du jeu d’échecs , il peut être compiler dans le terminal
sans soucis.

## 1 Règles du Jeu d’Échecs

Le jeu d’échecs se joue à deux joueurs sur un plateau de 8x8 cases, alternant des cases avec
chaque joueur disposant de 16 pièces :
— 1 roi
— 1 reine
— 2 tours
— 2 cavaliers
— 2 fous
— 8 pions

### Objectif

Mettre le roi adverseen échec et mat, c’est-à-dire qu’il est attaqué sans qu’aucun coup
légal ne puisse le sauver.

## 2 Mouvements des pièces

```
Pièce Mouvement
Pion Avance d’une case (ou deux depuis la position initiale), cap-
ture en diagonale. Promotion possible à l’arrivée sur la der-
nière rangée.
Tour Se déplace en ligne droite horizontalement ou verticalement.
Fou Se déplace en diagonale sur n’importe quelle distance.
Cavalier Se déplace en « L » (2 cases dans une direction puis 1 per-
pendiculaire). Peut sauter au-dessus des pièces.
Reine Combine les mouvements de la tour et du fou.
Roi Se déplace d’une case dans n’importe quelle direction. Peut
effectuer leroqueavec une tour sous certaines conditions.
```

## 3 Compilation et Exécution

### Prérequis

```
— Java JDK 17 ou supérieur
```
### Compilation

1 javac *.java

```
Listing 1 – Compilation des fichiers Java
```
### Exécution

1 java Partie

```
Listing 2 – Exécution du programme Java
```
## 4 Comment Jouer

```
L’interface du jeu ici :
```
```
Figure 1– Interface du jeu
```
```
Nous commençons en tant que blanc (tour des blancs, ici car j’ai choisi le nom blanc/noir au
début de la partie). Imaginons que nous prenons la pièce en (1,1) et la déplaçons en (1,3).
```

```
Figure 2– Déplacement du pion blanc
```
```
Figure 3– Position après déplacement
```
Déplaçons maintenant le pion noir :

```
Figure 4– Déplacement du pion noir
```
Maintenant, le pion blanc peut capturer le pion noir :


```
Figure 5– Capture du pion noir par le pion blanc
```
## 5 Le projet

### 5.1 Qui A Fait Quoi?

Sofiane Sebbah : Fait les Classes Echequier,Piece,Joueur , Ainsi que la Class test (Partie)
Yasir Manjra : A fait la moitié class pieces (pion,fou,roi) ainsi que le UML

Robel Emmanuel : A fait l’autre moitié des classes Piece (Tour ,Reine,Cavalier) ainsi que ce
pdf

### 5.2 Ce qui fonctionne

- Le mouvement des pièces.
- Les pièces ne peuvent pas bouger là où il y a d’autres pièces, sauf pour capturer l’ennemi.
- L’historique de la partie fonctionne et enregistre chaque coup.

### 5.3 Ce qui ne fonctionne pas

- L’échec et mat ne fonctionne pas.
- Si le roi est en position d’échec, rien ne se passe PS : On a décidé de supprimer la fonction
échec mat car elle ne fonctionnait pas.