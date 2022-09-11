package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangTinhGioChuan {
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
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<MonHoc> dsMH = new ArrayList<>();
        while(t-->0) dsMH.add(new MonHoc(sc));
        t = sc.nextInt();
        ArrayList<GiangVien> dsGV = new ArrayList<>();
        while(t-->0) dsGV.add(new GiangVien(sc));
        t = sc.nextInt();
        ArrayList<LopHocPhan> dsLHP = new ArrayList<>();
        while(t-->0) dsLHP.add(new LopHocPhan(sc,dsGV));
        for(GiangVien tmp : dsGV)
            System.out.println(tmp);
    }
}
