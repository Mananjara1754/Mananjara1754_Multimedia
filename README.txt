Explication de certains fonctions : 
- Serveur.java
    fonction mizara :
        mizarazara anle byte[] ho alefa tsikelikely
    fonction cancel : 
        interruption anle thread
    fonction ActivationServer : 
        creation serveur socket , envoie des data et des bytes apres division au client

-bridge.java
    fonction get_All_mp3 : 
        Avoir tous les titres de media disponibles

-Client.java
    fonction receive : 
        recoive les listes des media depuis le serveur et traite le cote affichage

-Affiche.java
    extends jFrame presentation des listes des media sous forme de liste deroulante
    fonction reinitialise :
        suppression byte dans le fichier andrana.mp4
    fonction reinitialiseMp3 :
        suppression byte dans le fichier andrana.mp3
    fonction reinitialiseImg :
        suppression byte dans le fichier andrana.jpg
    fonction changeFile : 
        ecrire les byte dans andrana.mp4
    fonction changeImage : 
        ecrire les byte dans andrana.mp3
    fonction changeMp3 : 
        ecrire les byte dans andrana.mp3

-Playlistener.java
    pour selectionner le choix et l'effectuer

-Action.java
extends thread
    pour jouer les media choisie , (recoive les info envoyer par le serveur(le byte tsikelikely))

-LireImage.java
    lire fichier image 

-LireMp4.java
    lecture du fichier audio et video , besoin de l'application vlc (VLCJ)