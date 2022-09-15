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
public class HopVaGiaoCuaHaiFileVanBan {
    private static class WordSet{
        private TreeSet<String> data = new TreeSet<>();;

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
        
        WordSet union(WordSet p){
            TreeSet<String> a = (TreeSet<String>) this.data.clone();
            for(String s: p.data) a.add(s);
            return new WordSet(a);
        }
        WordSet intersection(WordSet p){
            TreeSet<String> a = new TreeSet<>();
            for(String i: this.data)
                for(String j: p.data){
                    if(i.contentEquals(j)){
                        a.add(i);
                    }
                    if(i.compareTo(j)<0) break;
                }
            return new WordSet(a);
        }
        
        @Override
        public String toString(){
            String s = "";
            for(String i : this.data) s += i+" ";
            return s;
        }
    }
    public static void main(String[] args) throws IOException {
        WordSet s1 = new WordSet("DATA1.in");
        WordSet s2 = new WordSet("DATA2.in");
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
