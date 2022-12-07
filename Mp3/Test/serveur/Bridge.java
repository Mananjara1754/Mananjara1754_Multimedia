package pont;
import java.io.File;
import java.util.Vector;
public class Bridge {    
    public Vector get_All_mp3() {
        File dir  = new File("D:\\FIANARANA\\DEV_JAVA\\Mp3\\Musique");
        File[] liste = dir.listFiles();
        Vector v = new Vector<>();
        for(File item : liste){
            if(item.isFile()){
                if(item.getName().contains(".mp3")){
                    v.add(item.getName());
                }
                if(item.getName().contains(".mp4")){
                    v.add(item.getName());
                }
                if(item.getName().contains(".jpg")){
                    v.add(item.getName());
                }
            }
        }
        Object[] k = v.toArray();
        String[] rep = new String[k.length];
        for (int i = 0; i < rep.length; i++) {
            rep[i] = (String)k[i];
            System.out.println(rep[i]);
        }
        return v;
    }   
}