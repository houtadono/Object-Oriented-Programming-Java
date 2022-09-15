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
public class HieuCuaHaiTapTu {
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.difference(s2));
        System.out.println(s2.difference(s1));
    }
}
class WordSet{
        private TreeSet<String> data = new TreeSet<>();

        WordSet(String fileName) throws FileNotFoundException{ 
            Scanner sc = new Scanner(new File(fileName));
            while(sc.hasNext()){
                String s = sc.next().toLowerCase();
                this.data.add(s);
            }
        }
        WordSet (TreeSet<String> p){
            this.data = p;
        }
        
        WordSet difference(WordSet p){
            TreeSet<String> a = new TreeSet<>();
            for(String tmp : this.data)
                if(!p.data.contains(tmp))
                    a.add(tmp);
            return new WordSet(a);
        }
        
        @Override
        public String toString(){
            String s = "";
            for(String i : this.data) s += i+" ";
            return s;
        }
    }
