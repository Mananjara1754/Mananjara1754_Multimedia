
package play;
import java.awt.BorderLayout;
import java.io.File;
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LireMp4 extends JFrame {
    
    EmbeddedMediaPlayerComponent video = new EmbeddedMediaListPlayerComponent();
    JButton play,pause,stop;
    JPanel panelBout = new JPanel(new FlowLayout(FlowLayout.CENTER));

    public LireMp4(){
        
        setSize(1280, 720);
        setTitle("My video");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        try {
            video.getMediaPlayer().prepareMedia("andrana.mp4");        
        } catch (Exception e) {
            e.printStackTrace();
        }
        play = new JButton("play");
        stop = new JButton("Stop");
        pause = new JButton("pause");

        panelBout.add(play);
        panelBout.add(stop);
        panelBout.add(pause);


        add(video,BorderLayout.CENTER);
        add(panelBout,BorderLayout.SOUTH);
        setVisible(true);
        addListener();
    }
    private void addListener() {
        play.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                video.getMediaPlayer().start();
                System.out.println("huh");
            }
        });
        stop.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                video.getMediaPlayer().stop();
            }
        });
        pause.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                video.getMediaPlayer().pause();
            }
        });
    }
}
