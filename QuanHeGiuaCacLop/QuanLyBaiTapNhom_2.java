package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class QuanLyBaiTapNhom_2 {
    private static class SinhVien implements Comparable<SinhVien>{
        private String maSV,tenSV,sdt,tenBT;
        private int sttNhom;

        public SinhVien(Scanner sc) {
            this.maSV = sc.next();
            sc.nextLine();
            this.tenSV = sc.nextLine();
            this.sdt = sc.next();
            this.sttNhom = sc.nextInt();
        }
        
        @Override
        public String toString(){
            return this.maSV+' '+this.tenSV+' '+this.sdt+' '
                    +String.valueOf(this.sttNhom)+' '+this.tenBT;
        }
        @Override
        public int compareTo(SinhVien o) {
            return this.maSV.compareTo(o.maSV);
        }
    }
    private static class Nhom{
        private String tenBT;
        private ArrayList<SinhVien> dsSV;
        private int sttNhom;

        public Nhom(String tenBT, ArrayList<SinhVien> dsSV, int sttNhom) {
            this.tenBT = tenBT;
            this.dsSV = new ArrayList<>();
            this.sttNhom = sttNhom;
            for(SinhVien tmp : dsSV)
                if(tmp.sttNhom == sttNhom){
                    this.dsSV.add(tmp);
                    tmp.tenBT = this.tenBT;
                }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        while(n-->0) dsSV.add(new SinhVien(sc));
        sc.nextLine();
        ArrayList<Nhom> dsN = new ArrayList<>();
        int stt = 1;
        while(m-->0) dsN.add(new Nhom(sc.nextLine(),dsSV,stt++));
        Collections.sort(dsSV);
        for(SinhVien tmp : dsSV)
            System.out.println(tmp);
    }
}
        