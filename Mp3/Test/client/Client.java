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
    
    

    // static void reinitialise(){
    //     try (BufferedWriter fos = Files.newBufferedWriter(Path.of("andrana.mp4"),StandardOpenOption.TRUNCATE_EXISTING)){
    //     }
    //     catch(Exception r){
    //     r.printStackTrace();
    //     }
    // }
    // static void changeFile(byte[] tab){
    //     File k = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp4");
    //     try (FileOutputStream fos = new FileOutputStream("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp4",true)){
    //     fos.write(tab);
    //     }
    //     catch(Exception r){
    //     r.printStackTrace();
    //     }
    // }

    public static void main(String[] args) {
        // NativeLibrary.addSearchPath("libvlc","C:\\Program Files\\VideoLAN\\VLC");
        // Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        try {
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
            
            
        }
        catch(Exception e){
            System.out.println("misy ereurrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");
            e.printStackTrace();
        }
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