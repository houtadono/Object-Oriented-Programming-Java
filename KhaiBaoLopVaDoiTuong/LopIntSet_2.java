package KhaiBaoLopVaDoiTuong;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class LopIntSet_2 {
    private static class IntSet{
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
        IntSet intersection(IntSet p){
            ArrayList<Integer> a = new ArrayList<>();
            for(Integer i: p.data)
                for(Integer j: this.data){
                    if(Objects.equals(i, j)) a.add(i);
                    if(j>i) break;
                }
            return new IntSet(a);
        }
        
        @Override
        public String toString(){
            String s = "";
            for(Integer i: this.data) s+= String.valueOf(i)+' ';
            return s;
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int n = sc.nextInt(), m = sc.nextInt(), a[] = new int[n], b[] = new int[m];
        for(int i = 0; i<n; i++) a[i] = sc.nextInt();
        for(int i = 0; i<m; i++) b[i] = sc.nextInt();
        IntSet s1 = new IntSet(a);
        IntSet s2 = new IntSet(b);
        IntSet s3 = s1.intersection(s2);
        System.out.println(s3);
    }
}
