package play;
import javax.swing.*;
import java.lang.Runnable;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.*;
import javazoom.jl.player.Player;
import java.net.*;
import java.util.Vector;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.awt.*;
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
import affiche.Affiche;
public class Action extends Thread {

    JComboBox liste;
     Affiche fenetre;
    byte[] fichier;
    public JComboBox getListe() {
        return liste;
    }
    public void setListe(JComboBox liste) {
        this.liste = liste;
    }
    public Affiche getFenetre() {
        return fenetre;
    }
    public void setFenetre(Affiche fenetre) {
        this.fenetre = fenetre;
    }
    public byte[] getFichier() {
        return fichier;
    }
    public void setFichier(byte[] fichier) {
        this.fichier = fichier;
    }
    public Action(JComboBox liste, Affiche fenetre, byte[] fichier) {
        this.liste = liste;
        this.fenetre = fenetre;
        this.fichier = fichier;
    }
    public static void cancel() {
       Thread.currentThread().interrupt() ;
    }
    public void run() {
        try {
            int n= 0;
            while (!Thread.currentThread().isInterrupted()){
                // traitements
                ObjectOutputStream oos = new ObjectOutputStream(fenetre.getS().getOutputStream());
                oos.flush();
                String choix = String.valueOf(liste.getItemAt(liste.getSelectedIndex())) ;
                oos.writeObject(choix);
                //..... taille
                ObjectInputStream receiveTaille = new ObjectInputStream(fenetre.getS().getInputStream());
                int taille = (int)receiveTaille.readObject();
                System.out.println(taille  + " Tailles maximale");
            
                //.....receive
                    
                int count = 0;
                int y = 0;
                ObjectInputStream receiveByte = new ObjectInputStream(fenetre.getS().getInputStream());
                if(choix.contains(".jpg")){
                    while(count<taille){
                        if(y == 0){
                            this.fenetre.reinitialiseImg();
                            System.out.println("vita reinitialisation");
                        }
                        y++;
                        fichier = (byte[])receiveByte.readObject();
                        count = fichier.length+count;
                        this.fenetre.changeImage(fichier);
                        System.out.println("vaochange");
                    }
                    new LireImage();
                }
                int o = 0;
                if(choix.contains(".mp3")){
                    while(count<taille){
                        if(o == 0){
                            this.fenetre.reinitialiseMp3();
                            System.out.println("vita reinitialisation");
                        }
                        o++;
                        fichier = (byte[])receiveByte.readObject();
                        count = fichier.length+count;
                        System.out.println(fichier.length+" oulala");
                        System.out.println(count);
                        this.fenetre.changeMp3(fichier);
                        System.out.println("vaochange");  
                    }
                    try {
                        byte[] mozika = Files.readAllBytes(Paths.get("andrana.mp3"));
                        ByteArrayInputStream bt = new ByteArrayInputStream(mozika);
                        Player player=new Player(bt);
                        player.play();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    // while(count<taille){
                    //     fichier = (byte[])receiveByte.readObject(); 
                    //     try {
                    //         ByteArrayInputStream bt = new ByteArrayInputStream(fichier);
                    //         Player player=new Player(bt);
                    //         player.play();
                    //     } catch (Exception xe) {
                    //         xe.printStackTrace();
                    //     }          
                    //     count = fichier.length+count;
                    // }
                }
                int c =0;          
                        
                if(choix.contains(".mp4")){
                    while(count<taille){
                        if(c == 0){
                            this.fenetre.reinitialise();
                            System.out.println("vita reinitialisation");
                        }
                        c++;
                        fichier = (byte[])receiveByte.readObject();
                        count = fichier.length+count;
                        System.out.println(fichier.length+" oulala");
                        System.out.println(count);
                        this.fenetre.changeFile(fichier);
                        System.out.println("vaochange");  
                    }
                    NativeLibrary.addSearchPath("libvlc","C:\\Program Files\\VideoLAN\\VLC");
                    Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
                    new LireMp4();
                }
                
               //.....fanaphana....//
               if(n==10000){
                receiveByte.close();
                fenetre.getS().close();
                oos.close();
                System.out.println("stope euh");
                cancel();
            }
           }
        }  catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupted();
        }
    }
}