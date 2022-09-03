package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangXepHang {
    private static class SinhVien implements Comparable<SinhVien>{
        private String name;
        private int doTrue,submit;

        public SinhVien(String name, int doTrue, int submit) {
            this.name = name;
            this.doTrue = doTrue;
            this.submit = submit;
        }

        @Override
        public int compareTo(SinhVien o) {
            if(this.doTrue<o.doTrue) return 1;
            if(this.doTrue>o.doTrue) return -1;
            if(this.submit>o.submit) return 1;
            if(this.submit<o.submit) return -1;
            return this.name.compareTo(o.name);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<SinhVien> ds = new ArrayList<>();
        while(t-->0){      
            sc.nextLine();
            ds.add(new SinhVien(sc.nextLine(),sc.nextInt(),sc.nextInt()));
        }
        Collections.sort(ds);
        for(SinhVien tmp : ds)
            System.out.printf("%s %d %d\n",tmp.name,tmp.doTrue,tmp.submit);
    }
}
