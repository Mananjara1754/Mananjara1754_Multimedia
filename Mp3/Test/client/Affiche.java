package affiche;

import listener.*;

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

public class Affiche extends JFrame {
    
    String[] data;
    Socket s;
    byte[] fichier;
    public Socket getS() {
        return s;
    }


    public void reinitialise(){
        try (BufferedWriter fos = Files.newBufferedWriter(Path.of("andrana.mp4"),StandardOpenOption.TRUNCATE_EXISTING)){
        }
        catch(Exception r){
        r.printStackTrace();
        }
    }
    public void changeFile(byte[] tab){
        File k = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp4");
        try (FileOutputStream fos = new FileOutputStream("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp4",true)){
        fos.write(tab);
        }
        catch(Exception r){
        r.printStackTrace();
        }
    }

    public void setData(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }

    public Affiche(String[] data,Socket s){
       this.s = s;
      
        this.setData(data);
        JComboBox<String> jComboBox = new JComboBox<>(this.data);
        jComboBox.setBounds(80, 50, 140, 20);

        JButton jButton = new JButton("Done");
        jButton.setBounds(100, 100, 90, 20);

        JLabel jLabel = new JLabel();
        jLabel.setBounds(90, 100, 400, 100);

        this.add(jButton);
        this.add(jComboBox);
        this.add(jLabel);

        this.setLayout(null);
        this.setSize(350, 250);
        this.setVisible(true);
        
        JButton pause = new JButton("Pause");
        pause.setBounds(200, 100, 90, 20);
        this.add(pause);
        // pause.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
        //         jLabel.setText(selectedFruit);
        //     }
        // });
       
        // jButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
                
        //         String selectedFruit = "You selected " + jComboBox.getItemAt(jComboBox.getSelectedIndex());
        //         jLabel.setText(selectedFruit);
        //     //     try {
        //     //         ObjectOutputStream oos = new ObjectOutputStream(s.getOutputStream());
        //     //         oos.flush();
        //     //         String choix = jComboBox.getItemAt(jComboBox.getSelectedIndex());
        //     //         oos.writeObject(choix);
        //     //         //..... taille
        //     //     ObjectInputStream receiveTaille = new ObjectInputStream(s.getInputStream());
        //     //     int taille = (int)receiveTaille.readObject();
        //     //     System.out.println(taille  + " Tailles maximale");
                
        //     //     //.....recevoir
        //     //     int count = 0;
        //     //     ObjectInputStream receiveByte = new ObjectInputStream(s.getInputStream());
        //     //     // byte[] f = (byte[])receiveByte.readObject();
        //     //     //System.out.println(f.length+"manahoana");
        //     //     if(choix.contains(".mp3")){
        //     //         while(count<taille){
        //     //             fichier = (byte[])receiveByte.readObject();
        //     //             count = fichier.length+count;
        //     //             ByteArrayInputStream bt = new ByteArrayInputStream(fichier);
        //     //             Player player=new Player(bt);
        //     //             player.play();
                        
        //     //         }
        //     //         receiveByte.close();
        //     //     }
        //     //     LireMp4 play = new LireMp4();
        //     //     int c =0;
        //     //     if(choix.contains(".mp4")){
        //     //         while(count<taille){
        //     //             if(c == 0){
        //     //                 reinitialise();
        //     //                 System.out.println("vita reinitialisation");
        //     //             }
        //     //             c++;
        //     //             fichier = (byte[])receiveByte.readObject();
        //     //             count = fichier.length+count;
        //     //             System.out.println(fichier.length+" oulala");
        //     //             System.out.println(count);
        //     //             changeFile(fichier);
        //     //             System.out.println("vaochange");
        //     //         }
        //     //         play.playVideo();
        //     //         receiveByte.close();
        //     //     }
        //     //     s.close();
        //     //     oos.close();
                

        //     //     } catch (Exception ex) {
        //     //         ex.printStackTrace();
        //     //     }
               
        //      }
        // });
       // jButton.addMouseListener(new PlayListener(this,jComboBox.getItemAt(jComboBox.getSelectedIndex())));
       jButton.addMouseListener(new PlayListener(this, jComboBox,pause));
        
    }
}