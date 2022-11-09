package ThucHanhNhom8_To2;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class LietKeTuKhacNhau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        String s = "";
        while(t-->0) s += sc.nextLine().toLowerCase() + " ";
        WordSet a = new WordSet(s);
        
        t = Integer.parseInt(sc.nextLine());
        s = "";
        while(t-->0) s += sc.nextLine().toLowerCase() + " ";
        WordSet b = new WordSet(s);
        
        System.out.println(a.difference(b));
        System.out.println(b.difference(a));
    }
    
}
class WordSet{
    private TreeSet<String> data = new TreeSet<>();

    WordSet(String s){ 
        String [] data = s.split("\\s+");
        this.data.addAll(Arrays.asList(data));
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
