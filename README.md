# Projet Java - Porte / Monstre / Trésor

## Convention de code

Les conventions adoptées sont les suivantes :

- noms des variables membre : `mVariable`
- noms des paramètres de fonction : `tParameter`

## Structure hiérarchique

Le dossier de travail contient deux dossiers :

- `src` : contient l'ensemble des sources du projet
- `lib` : où sont stockées les .class

Les sources sont répartis de la façon suivante :

- `src.controleur` : toutes les classes contenant des contrôleurs, ainsi que la classe des méthodes liées à l'orientation dans le labyrinthe, ainsi que le système de sauvegarde
- `src.environnement` : toutes les classes liées à l'environnement et à ses objets, dans lequel évolue le personnage
- `src.equipement` : toutes les classes liées aux équipements que peut utiliser le personnage
- `src.main` : exécutable principal du programme
- `src.protagonistes` : toutes les classes liées aux êtres vivants évoluant dans le labyrinthe
- `src.vue` : ensemble des boundaries et des classes entrant en interaction avec l'utilisateur.

## Commandes pour l'utilisation

Dans un environnement Unix, la compilation du projet, depuis le dossier `lib`, se fait à l'aide de la commande `javac ../src/*/*.java -d ./`.

Pour lancer le projet depuis le dossier `lib` : `java main.Jeu`.

Afin de générer la documentation Java associée au projet, utilisez, depuis le dossier racine du projet : `javadoc src/*/*.java -d doc`

## License

Copyright © 2021, Chabert Thomas, Coulais Alexandre, Mortier Perrine, Suere Noëmie.