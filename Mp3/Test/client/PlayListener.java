package listener;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.event.ActionListener;
/*0 */
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.*;
//..
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

import affiche.Affiche;
import play.*;
public class PlayListener implements MouseListener{
    JComboBox liste;
    Affiche fenetre;
    byte[] fichier;
    JButton pause;
    public JComboBox getChoix() {
        return liste;
    }
    public void setChoix(JComboBox liste) {
        this.liste = liste;
    }
    public PlayListener(Affiche soratra,JComboBox liste,JButton pause) {
        this.setChoix(liste);
        this.fenetre = soratra;
        this.pause = pause;
    }

    public void mouseClicked(MouseEvent e){
       
        System.out.println("oulalalallalall");
        
        try {
            ObjectOutputStream oos = new ObjectOutputStream(fenetre.getS().getOutputStream());
            oos.flush();
            String choix = String.valueOf(liste.getItemAt(liste.getSelectedIndex())) ;
            oos.writeObject(choix);
           
            //..... taille

            ObjectInputStream receiveTaille = new ObjectInputStream(fenetre.getS().getInputStream());
            int taille = (int)receiveTaille.readObject();
            System.out.println(taille  + " Tailles maximale");
        
                //.....recevoir
                
            int count = 0;
            ObjectInputStream receiveByte = new ObjectInputStream(fenetre.getS().getInputStream());
            if(choix.contains(".mp3")){
                while(count<taille){
                    fichier = (byte[])receiveByte.readObject();
                    count = fichier.length+count;
                    ByteArrayInputStream bt = new ByteArrayInputStream(fichier);
                    Player player=new Player(bt);
                    player.play();
                    this.fenetre.setFocusable(true);
                }
                receiveByte.close();
            }
           
            int c =0;
            if(choix.contains(".mp4")){
                while(count<taille){
                    Thread thr = new Thread(new Runnable() {
                        @Override
                        public void run() {           
                            NativeLibrary.addSearchPath("libvlc","C:\\Program Files\\VideoLAN\\VLC");
                            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
                            new LireMp4();
                        }
                        
                    });
                    if(c == 0){
                        this.fenetre.reinitialise();
                        System.out.println("vita reinitialisation");
                        thr.start();
                    }
                    c++;
                    fichier = (byte[])receiveByte.readObject();
                    count = fichier.length+count;
                    System.out.println(fichier.length+" oulala");
                    System.out.println(count);
                    this.fenetre.changeFile(fichier);
                    System.out.println("vaochange");
                    
                }
                //new LireMp4();
    
                
        // pause.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
        //         jLabel.setText(selectedFruit);
        //     }
        // });
                receiveByte.close();
            }
            fenetre.getS().close();
            oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
          
    }
    
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}
