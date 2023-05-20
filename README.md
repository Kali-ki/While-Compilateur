# Compilateur While

Ce projet est un compilateur pour la langage While.

## Hiérarchie des répertoires

Vous trouverez dans cette archive les répertoires suivants :

- ```ANTLR_Grammar``` : la grammaire ANTLR décorée pour la génération de l'AST
- ```java``` : le code de notre compilateur WHILE
- ```compilateur``` : la compilation du projet contenant :
    - ```program.while``` : le code source WHILE
    - ```runner.bash``` : le script réalisant la compilation à partir du code source vers un programme exécutable
    - ```runtime.jar``` : le programme exécutable

## Compiler un fichier

### Prérequis

- Avoir Java 16 (minimum)
- Avoir le compilateur g++

### Exécution du compilateur

- Cloner le projet
- Aller dans le dossier ```compilateur```

Maintenant vous pouvez utiliser la commande pour compiler et éxécuter un fichier while :

> ./runner.bash *fichierwhile*

Des options facultatives peuvent s'ajouter à la commande :

| option | description |
| :--------------- |:---------------:|
| -a  | Affiche l'AST |
| -t  | Affiche la table des symboles |
| -c  | Affiche le code intermédiaire |
| -r  | N'éxecute pas le programme ; Active -e |
| -p  | Ne supprime pas le code intermédiaire C++ |
| -e  | Ne supprime pas l'exécutable |

## Mettre en place le projet pour le modifier et le compiler

- Inclure les librairies qui se trouvent dans `java/lib`
- Mettre en path d'entrée
    - `java/src/main`
    - `java/src/test`
- Ajouter au ClassPath `java/class`

Pour les tests :

Indiquer à JUnit le dossier d'éxécution suivant `/java/tests/programmes_test/`

Vous pouvez retrouver ci-dessous le contenu fichier settings.json utilisé :

```json
{
    
    "java.project.referencedLibraries": [
        "java/lib/*.jar"
    ],

    "java.project.sourcePaths": [
        "java/src/main",
        "java/src/test"
    ],

    "java.project.outputPath": "java/class",

    "java.test.config": {
        "workingDirectory": "${workspaceFolder}/java/tests/programmes_test/"
    }

}
```

## Exécuter les tests

Il est possible d'exécuter les tests :

- Pour les tests de l'exécutions il suffit de se rendre dans `java/tests/` et de lancer le script bash `test.bash`

- Pour les tests de vérification de l'analyse sémantique, il faut les éxécuter via JUnit (voire répertoire `java/src/test`)
