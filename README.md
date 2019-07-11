# EscapeGameOnline
Projet 3 du parcours"développeur d'applications JAVA"


Prérequis :
====================
Avoir un client muni de JAVA 8 et d'un JDK.
Avoir GIT installé sur le client
Pouvoir lancer la commande java depuis la console.
Savoir créer un fichier jar depuis un IDE
Installer Maven 3.6.1 et l'ajouter dans le path.


Partie I: Exécuter le programme.
=================================
Extraire le fichier config.properties et EscapeGameOnline-1.0-SNAPSHOT.jar du livrable dans le répertoire de son choix.
Ouvrir une console en se placant dans le dossier contenant les deux fichiers ci-dessus et exécuter la commande suivante:
java -jar EscapegameOnline.jar [DEVMOD] ou sans paramètres java -jar EscapeGameOnline-1.0-SNAPSHOT.jar



Partie II: Recompiler le projet:
====================================
Ouvrir l'explorateur de fichiers
Choisir un dossier dans lequel cloner le répertoire, clic droit GIT bash here
Dans cette console:
git clone https://github.com/vbiasin/EscapeGameOnline.git
Lancer une invite de commandes et saisir mvn package



BONUS:
===========================


CONTENU:
===============
3 gros packages:
	-escapegameonline (Combination.java, Computer.java, Display.java,....)
	-game (Game.java, GameMod.java,....)
	-util (Randomutil.java,Property)
Fichiers importants:
README.md et config.properties


CONCEPT TECHNIQUES:
==============================
Héritage
Maven
Gestion de log avec log4j
Tests avec JUnit
lire le fichier config.properties et exploiter les valeurs de ce dernier.
