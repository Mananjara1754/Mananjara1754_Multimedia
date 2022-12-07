package client;
import affiche.Affiche;
import listener.*;
import javazoom.jl.player.Player;
import java.io.*;  
import java.net.*;
import java.util.Vector;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.*;
import javax.swing.*;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.Files;
import java.nio.file.Path;

public class Client {

    public static void cancel() {
        // interruption du thread courant, c'est-à-dire le nôtre
       Thread.currentThread().interrupt() ;
    }
    public static void receive() {
        Thread thr = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    int n= 0;
                    while (!Thread.currentThread().isInterrupted()){
                        // traitements
                        Socket s=new Socket("localhost",6664); 
                        ObjectInputStream oi = new ObjectInputStream(s.getInputStream());
                        Object objetAzo =  oi.readObject();
                        Vector v = (Vector)objetAzo;
                        Object[] oups = v.toArray();
                        String[] lesMusics = new String[oups.length];
                        for (int i = 0; i < oups.length; i++) {
                            lesMusics[i] = (String)oups[i];
                        }
                        //Envoie du choix
                        Affiche show = new Affiche(lesMusics, s );
    
                       //.....fanaphana....//
                       if(n==10000){
                        System.out.println("stope euh");
                        cancel();
                    }
                   }
                }  catch (Exception e) {
                    e.printStackTrace();
                    Thread.currentThread().interrupted();
                }
            }
        });
        thr.start();
    }

    public static void main(String[] args) {
        receive();
}

}

//Exemples de thread action mandeha en parallele an MAin
// Thread thr = new Thread(new Runnable() {
//     @Override
//     public void run() {
        
//         //System.out.println(fichier.length + "io ny lasa");
//         try {
//             ByteArrayInputStream bt = new ByteArrayInputStream(fichier);
//         Player player=new Player(bt);
//         player.play();
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
        
//     }
    
// });
// thr.start();
