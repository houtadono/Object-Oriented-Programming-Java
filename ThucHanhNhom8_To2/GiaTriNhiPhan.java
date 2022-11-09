package ThucHanhNhom8_To2;
import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class GiaTriNhiPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        SortedSet<Pair> set = new TreeSet<>();
        while(q-->0){
            Pair tmp = new Pair(sc.nextInt(),sc.nextInt());
            if(set.contains(tmp)) set.remove(tmp);
            else set.add(tmp);
        }
        while (!set.isEmpty()){
            
        }
        for (Pair tmp : set) {
            System.out.println(tmp.first+","+tmp.second);
        }
    }
}
class Pair implements Comparable<Pair>{
    int first, second;

    public Pair(int first, int second) {
        super();
        this.first = first;
        this.second = second;
    }

    @Override
    public int compareTo(Pair o) {
        return first==o.first?second-o.second:first-o.first;
    }
}
