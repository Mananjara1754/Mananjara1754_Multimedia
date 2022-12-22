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
       Thread.currentThread().interrupt() ;
    }
    public static void receive() {
        Thread thr = new Thread(new Runnable(){
            @Override
            public void run() {
                try {
                    int n= 0;
                    Socket s = null;
                    ObjectInputStream oi = null; 
                    Object objetAzo= null;
                    Vector v = null;
                    Object[] oups = null;
                    String[] lesMusics =  null;
                    Affiche show = null;
                    while (!Thread.currentThread().isInterrupted()){
                        // traitements
                        s=new Socket("localhost",6664); 
                        oi = new ObjectInputStream(s.getInputStream());
                        objetAzo =  oi.readObject();
                        v = (Vector)objetAzo;
                        oups = v.toArray();
                        lesMusics = new String[oups.length];
                        for (int i = 0; i < oups.length; i++) {
                            lesMusics[i] = (String)oups[i];
                        }
                        //Envoie du choix
                        show = new Affiche(lesMusics, s );
    
                       //.....fanaphana....//
                       if(n==10000){
                        System.out.println("stop euh");
                        cancel();
                    }
                   }
                }  catch (Exception e) {
                    System.out.println(e.getMessage());
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
