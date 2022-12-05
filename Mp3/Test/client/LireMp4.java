
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
        setTitle("Video Palyer");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

// import java.awt.*;
// import javax.swing.*;

// import com.sun.jna.Native;
// import com.sun.jna.NativeLibrary;

// import uk.co.caprica.vlcj.binding.LibVlc;
// import uk.co.caprica.vlcj.player.MediaPlayerFactory;
// import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
// import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
// import uk.co.caprica.vlcj.runtime.RuntimeUtil;

// public class LireMp4 {

//     public void playVideo() {

//         JFrame f = new JFrame("Play");
//         f.setSize(500, 500);
//         f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         //f.setLocationRelativeTo(null);
//         f.setVisible(true);

//         Canvas c = new Canvas();
//         c.setBackground(Color.black);
//         JPanel p = new JPanel(new BorderLayout());
//         p.add(c);
//         f.setContentPane(p);

//         NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
//         Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

//         MediaPlayerFactory mpf = new MediaPlayerFactory();
//         EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(f));
//         emp.setVideoSurface(mpf.newVideoSurface(c));
//         emp.prepareMedia("andrana.mp4");
//         emp.play();
        
//     }

// }