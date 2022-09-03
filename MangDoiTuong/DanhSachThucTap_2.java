package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachThucTap_2 {
    static int dem = 1;
    private static class SinhVien implements Comparable<SinhVien>{
        private String id,name,clas,email,dn;
        private int stt;
        
        public SinhVien(Scanner sc) {
            this.stt = dem++;
            this.id = sc.next();
            sc.nextLine();
            this.name = sc.nextLine();
            this.clas = sc.next();
            this.email = sc.next();
            this.dn = sc.next();
        }
        
        @Override
        public int compareTo(SinhVien o) {
            return this.id.compareTo(o.id);
        }
        @Override
        public String toString(){
            return String.valueOf(this.stt)+' '+this.id+' '+this.name+' '
                    +this.clas+' '+this.email+' '+this.dn;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<SinhVien> ds = new ArrayList<>();
        while(t-->0){      
            ds.add(new SinhVien(sc));
        }
        Collections.sort(ds);
        t = sc.nextInt();
        while(t-->0){      
            String dn = sc.next();
            for(SinhVien tmp : ds)
                if(tmp.dn.contains(dn))
                    System.out.println(tmp);
        }
    }
}
