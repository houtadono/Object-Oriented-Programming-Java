package VaoRaFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Houta
 */
public class LietKeTheoThuTuXuatHien {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream file = new FileInputStream("NHIPHAN.in");
        ObjectInputStream is = new ObjectInputStream(file);
        ArrayList<String> als = (ArrayList<String>) is.readObject();
        Set<String> ss = new HashSet<>();
        for(String tmp : als){
            String [] data = tmp.split("\\s+");
            for(String i : data)
                ss.add(i.toLowerCase());
        }
        
        Scanner sc = new Scanner(new File("VANBAN.in"));
        Set<String> res = new HashSet<>();
        while(sc.hasNext()){
            String s = sc.next().toLowerCase();
            if(ss.contains(s) && !res.contains(s)){
                System.out.println(s);
                res.add(s);
            }
        }
    }
}
