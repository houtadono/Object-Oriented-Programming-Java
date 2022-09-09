package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class QuanLyBaiTapNhom_1 {
    private static class SinhVien{
        private String maSV,tenSV,sdt;
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
            return this.maSV+' '+this.tenSV+' '+this.sdt;
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
                if(tmp.sttNhom == sttNhom)
                    this.dsSV.add(tmp);
        }
        
        @Override
        public String toString(){
            String s = String.format("DANH SACH NHOM %d:\n", this.sttNhom);
            for(SinhVien tmp : this.dsSV)
                s+= tmp+"\n";
            s += "Bai tap dang ky: "+this.tenBT;
            return s;
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
        int t = sc.nextInt();
        while(t-->0){
            int sttNhom = sc.nextInt();
            for(Nhom tmp : dsN)
                if(tmp.sttNhom == sttNhom)
                    System.out.println(tmp);
        }
    }
}
