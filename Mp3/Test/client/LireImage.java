package play;
import javax.swing.JFrame;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.ImageIcon;
import javax.swing.*;
import java.awt.BorderLayout;
/**
 * LireImage
 */
public class LireImage extends JFrame{

    public LireImage(){
        try {
            byte[] tab = Files.readAllBytes(Paths.get("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Test\\client\\andrana.jpg"));
            this.setSize(300, 300);    
            this.setTitle("Voici l'image choisi");
            
            ImageIcon icon = new ImageIcon(tab);
            JLabel label = new JLabel(icon);
            this.add(label,BorderLayout.CENTER);

            this.setVisible(true);
            
            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    
}