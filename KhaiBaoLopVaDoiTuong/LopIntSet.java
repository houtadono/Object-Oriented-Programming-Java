package KhaiBaoLopVaDoiTuong;
import java.util.*;
/**
 *
 * @author Houta
 */
class IntSet{
    private final TreeSet<Integer> data;
    
    IntSet(int[] data) {
        ArrayList<Integer> a = new ArrayList<>();
        for(int i: data) a.add(i);
        this.data = new TreeSet<>(a);
    }
    IntSet(ArrayList<Integer> data ) {
        this.data = new TreeSet<>(data);
    }
    
    IntSet union(IntSet p){
        ArrayList<Integer> a = new ArrayList<>();
        for(Integer i: p.data) a.add(i);
        for(Integer i: this.data) a.add(i);
        return new IntSet(a);
    }
    
    @Override
    public String toString(){
        String s = "";
        for(Integer i: this.data) s+= String.valueOf(i)+' ';
        return s;
    }
}
public class LopIntSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.union(s2);
        System.out.println(s3);
    }
}
