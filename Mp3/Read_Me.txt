Projet Socket S3 : MULTIMEDIA 

serveur :
    Bridge.java
        Class pour avoir tous les media disponible dans Musique (.mp3 , .mp4 , .jpg)
    Serveur.java :
        Serveur Socket
        Recoive les demandes du client 
        envoie les choix sous forme de byte[] (decoupe en plusieurs morceux(Grace au fonction Mizara))

client :
    Client.java
        recoivent les titres des media envoyer par le serveur
        Creation d'un objet Affiche 
    Affiche.java
        Fenetre qui affiche les musiques , video , image que le client veut voir ou jouer
        Bouttoun 'done' --> playlistener
    playlistener.java
        associe avec Action.java pour la lecture du choix

Lecture :
reinitialise le fichier viser(andrana(.mp3/.mp4/.jpg))
Recoive byte[] par byte[] , puis extracte les bytes dans le fichier vise et effectue la lecture 

