package KhaiBaoLopVaDoiTuong;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class WordSet {
    private TreeSet<String> data;

    WordSet(String s) {
        s=s.toLowerCase();
        this.data = new TreeSet<>(Arrays.asList(s.split("\\s+")));
    }
    WordSet (TreeSet<String> p){
        this.data = p;
    }
    
    WordSet union(WordSet p){
        TreeSet<String> a = (TreeSet<String>) this.data.clone();
        for(String s: p.data){
            a.add(s);
        }
        return new WordSet(a);
    }
    WordSet intersection(WordSet p){
        TreeSet<String> a = new TreeSet<>();
        for(String i: this.data){
            for(String j: p.data){
                if(i.contentEquals(j)){
                    a.add(i);
                }
                if(i.compareTo(j)<0) break;
            }
        }
        return new WordSet(a);
    }
    
    @Override
    public String toString(){
        String s = "";
        for(String i: this.data){
            s+= i + ' ';
        }
        return s;
    }
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        WordSet s1 = new WordSet(in.nextLine());
        WordSet s2 = new WordSet(in.nextLine());
        System.out.println(s1.union(s2));
        System.out.println(s1.intersection(s2));
    }
}
