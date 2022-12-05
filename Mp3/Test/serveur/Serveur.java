package serveur;
import pont.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.*;  
import java.net.*;  
import javazoom.jl.player.Player;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.sound.sampled.*;
import javazoom.jl.player.Player;
import java.nio.ByteBuffer;
import java.nio.file.*;
import java.util.Arrays;
import java.util.Vector;
import java.io.IOException;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Serveur {


    public static int[] mizara(int taille,int divisuer) {
        int[] rep = new int[4];
        if(taille % divisuer!=0){
            int[] lesvaleurs = new int[divisuer+1];
            lesvaleurs[lesvaleurs.length-1] = taille % divisuer;
            for (int i = 0; i < lesvaleurs.length-1; i++) {
                lesvaleurs[i] = taille/divisuer;
            }
            rep = lesvaleurs;
        }
        else{
            int[] lesvaleurs = new int[divisuer];
            lesvaleurs[lesvaleurs.length-1] = taille/divisuer;
            for (int i = 0; i < lesvaleurs.length-1; i++) {
                lesvaleurs[i] = taille/divisuer;
            }
            rep = lesvaleurs;
        }
        
        return rep;
    }
    public static void main(String[] args){ 
        Bridge o = new Bridge();
        try{
        ServerSocket ss=new ServerSocket(6664);  
        Socket s=ss.accept();
    
        //.................................mandefa anle Musique rehetra    
        ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        oos.flush();
        Vector v = o.get_All_mp3();
        oos.writeObject(v);

       //..........................mandray anle music
        ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
        String choisie = (String)ois.readObject();
        byte[] tab = Files.readAllBytes(Paths.get("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Musique\\"+choisie));
        //byte[] tab = Files.readAllBytes(Paths.get("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Musique\\Tayc - NUE (Clip Officiel).mp4"));

        //MAndefa anle taille
        ObjectOutputStream taille = new ObjectOutputStream(s.getOutputStream());
        taille.flush();
        taille.writeObject(tab.length);

        ByteBuffer k = ByteBuffer.wrap(tab);        //Association de tab dans k
        System.out.println(tab.length);

        //Traitement de l'envoie du bytes par bytes
        ObjectOutputStream envoieByte = new ObjectOutputStream(s.getOutputStream());
        envoieByte.flush();
        int[] valeur = mizara(tab.length,5);       //Division du bytes en 10 bytes
        
        for (int i = 0; i < valeur.length; i++) {
            System.out.println(valeur[i] + " les valeurs " + i);
            byte[] vide = new byte[valeur[i]];
            k.get(vide,0,vide.length);    
        
        // envoie du byte a lire
            envoieByte.writeObject(vide); 
            System.out.println("lasa");
        }
        
        oos.close();
        taille.close();
        envoieByte.close();
        ss.close();  
        s.close();
        }catch(Exception e){
            e.printStackTrace();
        }  
        } 
} 