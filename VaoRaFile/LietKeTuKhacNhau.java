package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class LietKeTuKhacNhau {
    private static class WordSet{
        private TreeSet<String> data;

        public WordSet(String fileName) throws FileNotFoundException{ 
            Scanner sc = new Scanner(new File(fileName));
            this.data = new TreeSet<>();
            while(sc.hasNext()){
                String s = sc.next().toLowerCase();
                this.data.add(s);
            }
        }
        
        @Override
        public String toString(){
            String s = "";
            for(String i : this.data) s += i+"\n";
            return s;
        }
    }
    public static void main(String[] args) throws IOException {
        WordSet ws = new WordSet("VANBAN.in");
        System.out.println(ws);
    }
}
