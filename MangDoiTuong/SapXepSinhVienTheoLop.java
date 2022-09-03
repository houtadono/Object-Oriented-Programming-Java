package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepSinhVienTheoLop {
    private static class SinhVien implements Comparable<SinhVien>{
        private String id,name,clas,email;

        public SinhVien(String id, String name, String clas, String email) {
            this.id = id;
            this.name = name;
            this.clas = clas;
            this.email = email;
        }    
        
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+this.clas+' '+this.email;
        }
        @Override
        public int compareTo(SinhVien o) {
            if(o.clas.contentEquals(this.clas))
                return this.id.compareTo(o.id);
            return this.clas.compareTo(o.clas);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        ArrayList<SinhVien> ds = new ArrayList<>();
        while(t-->0){        
            ds.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(ds);
        for(SinhVien tmp : ds)
            System.out.println(tmp);
    }
}
