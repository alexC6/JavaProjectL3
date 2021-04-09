# Projet Java - Porte / Monstre / Trésor

## Convention de code

Les conventions adoptées sont les suivantes :

- noms des variables membre : `mVariable`
- noms des paramètres de fonction : `tParameter`

## Commentaires Javadoc

### Début de fichier

Les débuts de fichiers commencent par un commentaire indiquant le nom du fichier, un rapide résumé de son contenu, 
suivi du ou des auteurs, puis fini par la version du fichier qui correspond à la date de sa dernière édition.

### Commentaires de méthodes

Les méthodes autres que les constructeurs, getters et setters non complexes, doivent être précédées d'un commentaire explicatif.
Ce commentaire doit contenir un résumé rapide du fonctionnement de la méthode, ainsi que le nom des paramètres, leur type, 
et ce à quoi ils correspondent. Dans le cas où le fichier est édité par plusieurs auteurs, les commentaires de chaque méthode
doivent contenir l'auteur de la méthode en question.

À l'intérieur même des méthodes, les commentaires doivent expliquer concrètement ce qui est fait dans les cas suivants :

- instruction complexe ou sujet à interprétation
- appel successif à plusieurs méthodes. Exemple : `variable.getter().action()`
- boucles et structure conditionnelles

## Structure hiérarchique

Le dossier de travail contient deux dossiers :

- `src`: contient l'ensemble des sources du projet
- `lib`: où sont stockées les .class

## Fichiers ignorés

Les fichiers ignorées par Git sont les suivants :

- `*.class`
- `*.jar`
- `*.war`
- `*.nar`
- `*.ear`
- `*.zip`
- `*.tar.gz`
- `*.rar`
- `*.log`
- `*.ctxt`