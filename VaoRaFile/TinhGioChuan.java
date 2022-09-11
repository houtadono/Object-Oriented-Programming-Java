package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhGioChuan {
    private static class MonHoc{
        private String maMon,tenMon;

        public MonHoc(Scanner sc) {
            this.maMon = sc.next();
            this.tenMon = sc.nextLine();
        }
    }
    private static class GiangVien{
        private String maGV,tenGV;
        private double gioDay;

        public GiangVien(Scanner sc) {
            this.maGV = sc.next();
            this.tenGV = sc.nextLine().substring(1);
            this.gioDay = 0;
        }
        
        @Override
        public String toString(){
            return  this.tenGV+' '+String.format("%.2f", this.gioDay);
        }
    }
    private static class LopHocPhan{
        private String maGV,maMH;
        private double gioDay;

        public LopHocPhan(Scanner sc, ArrayList<GiangVien> dsGV) {
            this.maGV = sc.next();
            this.maMH = sc.next();
            this.gioDay = sc.nextDouble();
            for(GiangVien tmp : dsGV)
                if(tmp.maGV.contentEquals(this.maGV)){
                    tmp.gioDay += this.gioDay;
                    break;
                }
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = sc.nextInt();
        ArrayList<MonHoc> dsMH = new ArrayList<>();
        while(t-->0) dsMH.add(new MonHoc(sc));
        
        sc = new Scanner(new File("GIANGVIEN.in"));
        t = sc.nextInt();
        ArrayList<GiangVien> dsGV = new ArrayList<>();
        while(t-->0) dsGV.add(new GiangVien(sc));
        
        sc = new Scanner(new File("GIOCHUAN.in"));
        t = sc.nextInt();
        ArrayList<LopHocPhan> dsLHP = new ArrayList<>();
        while(t-->0) dsLHP.add(new LopHocPhan(sc,dsGV));
        for(GiangVien tmp : dsGV)
            System.out.println(tmp);
    }
}
