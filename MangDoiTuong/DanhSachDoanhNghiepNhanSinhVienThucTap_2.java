package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachDoanhNghiepNhanSinhVienThucTap_2 {
    private static class DoanhNghiep implements Comparable<DoanhNghiep>{
        private String id,name;
        private int receiveNumber;

        public DoanhNghiep(String id, String name, int receiveNumber) {
            this.id = id;
            this.name = name;
            this.receiveNumber = receiveNumber;
        }
        
        @Override
        public int compareTo(DoanhNghiep o) {
            if(this.receiveNumber<o.receiveNumber) return 1;
            if(this.receiveNumber>o.receiveNumber) return -1;
            return this.id.compareTo(o.id);
        }
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+String.valueOf(this.receiveNumber);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<DoanhNghiep> ds = new ArrayList<>();
        int t = sc.nextInt(); 
        while(t-->0){        
            sc.nextLine();
            ds.add(new DoanhNghiep(sc.nextLine(),sc.nextLine(),sc.nextInt()));
        }
        Collections.sort(ds);
        t = sc.nextInt(); 
        while(t-->0){
            int a = sc.nextInt(); 
            int b = sc.nextInt(); 
            System.out.printf("DANH SACH DOANH NGHIEP NHAN TU %d DEN %d SINH VIEN:\n",a,b);
            for(DoanhNghiep tmp : ds) 
                if(tmp.receiveNumber>=a&&tmp.receiveNumber<=b)
                    System.out.println(tmp);
        }
    }
}
