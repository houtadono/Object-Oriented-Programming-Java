package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepNhanVienTheoThuNhap {
    static int stt=1;
    private static class NhanVien implements Comparable<NhanVien>{
        private String id,name,chucVu;
        private double salaryDay,day,salary,phuCap,tamUng,conLai;

        public NhanVien(Scanner sc) {
            sc.nextLine();
            this.id = getId(stt++);
            this.name = sc.nextLine();
            this.chucVu = sc.next();
            this.salaryDay = sc.nextDouble();
            this.day = sc.nextDouble();
            
            if(this.chucVu.contentEquals("GD")) this.phuCap = 500;
            else if(this.chucVu.contentEquals("PGD")) this.phuCap = 400;
            else if(this.chucVu.contentEquals("TP")) this.phuCap = 300;
            else if(this.chucVu.contentEquals("KT")) this.phuCap = 250;
            else this.phuCap = 100;
            this.salary = this.salaryDay*this.day;
            
            if((this.phuCap+this.salary)*2/3<25000) this.tamUng = Math.round((this.phuCap+this.salary)*2/3/1000)*1000;
            else this.tamUng = 25000;
            this.conLai = this.salary + this.phuCap - this.tamUng;
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "NV"+s;
        }

        @Override
        public int compareTo(NhanVien o) {
            if(this.salary+this.phuCap < o.salary+o.phuCap) return 1;
            if(this.salary+this.phuCap > o.salary+o.phuCap) return -1;
            return this.id.compareTo(o.id);
        }
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<NhanVien> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new NhanVien(sc));
        }
        Collections.sort(ds);
        for(NhanVien tmp : ds)
            System.out.printf("%s %s %.0f %.0f %.0f %.0f\n",tmp.id,tmp.name,tmp.phuCap,tmp.salary,tmp.tamUng,tmp.conLai);
    }
}
