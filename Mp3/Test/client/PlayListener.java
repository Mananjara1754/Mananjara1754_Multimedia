package listener;
import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.net.Socket;
import java.io.ObjectOutputStream;
import java.io.*;
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
import play.*;
public class PlayListener implements MouseListener{
    JComboBox liste;
     Affiche fenetre;
    byte[] fichier;
 
    public JComboBox getChoix() {
        return liste;
    }
    public void setChoix(JComboBox liste) {
        this.liste = liste;
    }
    public PlayListener(Affiche soratra,JComboBox liste) {
        this.setChoix(liste);
        this.fenetre = soratra;
    }
    public static void alefaso(JComboBox liste,Affiche soratra,byte[] fichier) {
        play.Action acte = new play.Action(liste, soratra, fichier);
        acte.start();
    }

    public void mouseClicked(MouseEvent e){
        System.out.println("mandeha ny traitement");
        alefaso(this.liste,this.fenetre,this.fichier);
    }
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
}
