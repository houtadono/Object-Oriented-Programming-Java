package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class QuanLyBaiTapNhom {
    private static class SinhVien implements Comparable<SinhVien>{
        private String maSV,tenSV,sdt,tenBT;
        private int sttNhom;

        public SinhVien(Scanner sc) {
            this.maSV = sc.next();
            sc.nextLine();
            this.tenSV = sc.nextLine();
            this.sdt = sc.next();
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
    private static class BaiTap{
        private String tenBT;
        private int sttNhom;

        public BaiTap(String tenBT, int sttNhom) {
            this.tenBT = tenBT;
            this.sttNhom = sttNhom;
        }
    }
    private static class Nhom{
        private String maSV,tenBT;
        private int sttNhom;
        private ArrayList<SinhVien> dsSV = new ArrayList<>();

        public Nhom(Scanner sc, ArrayList<SinhVien> dsSV, ArrayList<BaiTap> dsBT) {
            this.maSV = sc.next();
            this.sttNhom = sc.nextInt();
            for(BaiTap tmp : dsBT)
                if(tmp.sttNhom == this.sttNhom){
                    this.tenBT = tmp.tenBT;
                    break;
                }
            for(SinhVien tmp : dsSV)
                if(tmp.maSV.contains(this.maSV)){
                    tmp.tenBT = this.tenBT;
                    tmp.sttNhom = this.sttNhom;
                    this.dsSV.add(tmp);
                    break;
                }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        for(int i = 1; i<=n; i++) dsSV.add(new SinhVien(sc));
        
        sc = new Scanner(new File("BAITAP.in"));
        int m = sc.nextInt();
        sc.nextLine();
        ArrayList<BaiTap> dsBT = new ArrayList<>();
        for(int i = 1; i<=m; i++) dsBT.add(new BaiTap(sc.nextLine(),i));
        
        sc = new Scanner(new File("NHOM.in"));
        ArrayList<Nhom> dsN = new ArrayList<>();
        for(int i = 1; i<=n; i++) dsN.add(new Nhom(sc,dsSV,dsBT));
        
        Collections.sort(dsSV);
        for(SinhVien tmp : dsSV)
            System.out.println(tmp);
    }
}
