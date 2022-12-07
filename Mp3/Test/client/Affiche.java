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
    public void reinitialiseImg(){
        try (BufferedWriter fos = Files.newBufferedWriter(Path.of("andrana.jpg"),StandardOpenOption.TRUNCATE_EXISTING)){
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
    public void changeImage(byte[] tab){
        //File k = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp4");
        try (FileOutputStream fos = new FileOutputStream("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.jpg",true)){
        fos.write(tab);
        }
        catch(Exception r){
        r.printStackTrace();
        }
    }
    //.................................
    public void changeMp3(byte[] tab){
        //File k = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp3");
        try (FileOutputStream fos = new FileOutputStream("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.mp3",true)){
        fos.write(tab);
        }
        catch(Exception r){
        r.printStackTrace();
        }
    }
    public void reinitialiseMp3(){
        try (BufferedWriter fos = Files.newBufferedWriter(Path.of("andrana.mp3"),StandardOpenOption.TRUNCATE_EXISTING)){
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
        jButton.addMouseListener(new PlayListener(this,jComboBox,pause));
    }
}