
 
import java.io.File;
import java.io.IOException;
import java.io.*;  
import java.net.*;  
import javazoom.jl.player.Player;
import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.sound.sampled.*;
import javazoom.jl.player.Player;


import java.nio.file.*;
import java.util.Arrays;
import java.io.IOException;
 
public class Main {

	// public File getsoundFile(String h){
	// 	File sound = new File(h);
	// 	if (!sound.exists() || !sound.isFile()) {
	// 		throw new IllegalArgumentException("tsy fichier");
	// 	}
	// 	return sound;
	// }
	public static void main(String[] args) {
		
	try{
		File myFile = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Musique\\11 Save Your Tears.mp3");

		byte[] tab = Files.readAllBytes(Paths.get("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Musique\\11 Save Your Tears.mp3"));
		// FileInputStream fis=new FileInputStream(myFile);
		// //DataInputStream dis = new DataInputStream(is);
		// BufferedInputStream bis= new BufferedInputStream(fis);
		// System.out.println(bis.hashCode());
		// Player player=new Player(bis);
		// player.play();
		// AudioInputStream is = AudioSystem.getAudioInputStream(myFile);
		// DataInputStream dis = new DataInputStream(is);      //So we can use readFully()
		// AudioFormat audioFormat = is.getFormat();
		// DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
		// SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
		// line.open(audioFormat);
		// line.start();
		// byte[] data = new byte[(int)(is.getFrameLength() * audioFormat.getFrameSize())];
		// dis.readFully(data);
		// dis.close();
		ByteArrayInputStream bt = new ByteArrayInputStream(tab);
		Player player=new Player(bt);
		player.play();

				
			
		}
		catch(Exception exc){
				exc.printStackTrace();
				System.out.println("Failed to play the file.");
		}
	
		
		
		
		/// AudioInputStream din = null;
        

// try{
//     File file= new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\1.wav");
//     FileInputStream fis = new FileInputStream(file);
//     BufferedInputStream bis= new BufferedInputStream(fis);
//     Player playMP3 = new Player(bis);
//     playMP3.play();
// }
// catch(Exception exc){
//     exc.printStackTrace();
//     System.out.println("Failed to play the file.");
// }
        // try {
        //     File file= new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\1.wav");
        //             FileInputStream fis=new FileInputStream(file);
        //             BufferedInputStream bis= new BufferedInputStream(fis);
    
    
        //             Player player=new Player(bis);
        //             //System.out.println(fc.getSelectedFile().getAbsolutePath());
        //             player.play();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
		// try {
		// 	//File file = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\24kGoldn - Mood (Lyrics) ft. Iann Dior.m4a");
		// 	File file = getsoundFile(args[0]);
		// 	AudioInputStream in = AudioSystem.getAudioInputStream(file);
		// 	AudioFormat baseFormat = in.getFormat();
		// 	AudioFormat decodedFormat = new AudioFormat(
		// 	AudioFormat.Encoding.PCM_SIGNED,
		// 	baseFormat.getSampleRate(), 16, baseFormat.getChannels(),
		// 	baseFormat.getChannels() * 2, baseFormat.getSampleRate(),
		// 	false);
		// 	din = AudioSystem.getAudioInputStream(decodedFormat, in);
		// 	DataLine.Info info = new DataLine.Info(SourceDataLine.class, decodedFormat);
		// 	SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
		// 	if(line != null) {
		// 		line.open(decodedFormat);
		// 		byte[] data = new byte[4096];
		// 		// Start
		// 		line.start();
 
		// 		int nBytesRead;
		// 		while ((nBytesRead = din.read(data, 0, data.length)) != -1) {	
		// 			line.write(data, 0, nBytesRead);
		// 		}
		// 		// Stop
		// 		line.drain();
		// 		line.stop();
		// 		line.close();
		// 		din.close();
		// 	}
 
		// }
		// catch(Exception e) {
		// 	e.printStackTrace();
		// }
		// finally {
		// 	if(din != null) {
		// 		try { din.close(); } catch(IOException e) { }
		// 	}
		// }
	}
 
}