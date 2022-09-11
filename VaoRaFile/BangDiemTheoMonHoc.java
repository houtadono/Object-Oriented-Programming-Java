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
public class BangDiemTheoMonHoc {
    private static class SinhVien{
        private String maSV,tenSV,clas,email;
        
        public SinhVien(Scanner sc) {
            this.maSV = sc.next();
            sc.nextLine();
            this.tenSV = standardName(sc.nextLine());
            this.clas = sc.next();
            this.email = sc.next();
        }
        public static String standardName(String s){
            s = s.trim().toLowerCase();
            String res = "" + Character.toUpperCase(s.charAt(0));
            for(int i=1; i< s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
                    else res += s.charAt(i);
                }
            }
            return res;
        }
    }
    private static class MonHoc{
        private String maMH,tenMH;
        private int soTinChi;

        public MonHoc(Scanner sc) {
            this.maMH = sc.next();
            sc.nextLine();
            this.tenMH = sc.nextLine();
            this.soTinChi = sc.nextInt();
        }
    }
    private static class BangDiem implements Comparable<BangDiem>{
        private double diem;
        private SinhVien sv;
        private MonHoc mh;
        
        public BangDiem(Scanner sc,ArrayList<SinhVien> dsSV,ArrayList<MonHoc> dsMH) {
            String maSV = sc.next();
            String maMH = sc.next();
            this.diem = sc.nextDouble();
            for(SinhVien tmp : dsSV)
                if(tmp.maSV.contains(maSV)){
                    this.sv = tmp;
                    break;
                }
            for(MonHoc tmp : dsMH)
                if(tmp.maMH.contains(maMH)){
                    this.mh = tmp;
                    break;
                }
        }
        
        @Override
        public String toString(){
            String diem = String.format("%.1f", this.diem);
            if(this.diem == (int) this.diem) diem = String.format("%.0f", this.diem);
            return this.sv.maSV+' '+this.sv.tenSV+' '+this.sv.clas
                    +' '+diem;
        }
        @Override
        public int compareTo(BangDiem o) {
            if(this.diem<o.diem) return 1;
            if(this.diem>o.diem) return -1;
            return this.sv.maSV.compareTo(o.sv.maSV);
        }
    }
    public static void main(String []args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = sc.nextInt(); 
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        while(t-->0)
            dsSV.add(new SinhVien(sc));
        
        sc = new Scanner(new File("MONHOC.in"));
        t = sc.nextInt(); 
        ArrayList<MonHoc> dsMH = new ArrayList<>();
        while(t-->0)
            dsMH.add(new MonHoc(sc));
        
        sc = new Scanner(new File("BANGDIEM.in"));
        t = sc.nextInt(); 
        ArrayList<BangDiem> dsBD = new ArrayList<>();
        while(t-->0)
            dsBD.add(new BangDiem(sc,dsSV,dsMH));
        Collections.sort(dsBD);
        t = sc.nextInt(); 
        while(t-->0){
            String maMH = sc.next();
            for(MonHoc tmp : dsMH)
                if(tmp.maMH.contains(maMH)){
                    System.out.printf("BANG DIEM MON %s:\n",tmp.tenMH);
                    break;
                }
            for(BangDiem tmp : dsBD)
                if(tmp.mh.maMH.contains(maMH)){
                    System.out.println(tmp);
                }
        }
    }
}
