package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhGioChuanChoTungGiangVien {
    private static class MonHoc{
        private String maMH,tenMH;

        public MonHoc(Scanner sc) {
            this.maMH = sc.next();
            this.tenMH = sc.nextLine().substring(1);
        }
    }
    private static class GiangVien{
        private String maGV,tenGV;
        private double tongGioDay;
        private ArrayList<LopHocPhan> dsLHP;
        
        public GiangVien(Scanner sc) {
            this.maGV = sc.next();
            this.tenGV = sc.nextLine().substring(1);
            this.tongGioDay = 0;
            this.dsLHP = new ArrayList<>();
        }
        
        @Override
        public String toString(){
            String s = "Giang vien: "+this.tenGV+"\n";
            for(LopHocPhan tmp : dsLHP)
                s += tmp+"\n";
            return  s + "Tong: "+String.format("%.2f", this.tongGioDay);
        }
    }
    private static class LopHocPhan{
        private String maGV,maMH;
        private double gioDay;
        private MonHoc monHoc;
        
        public LopHocPhan(Scanner sc, ArrayList<MonHoc> dsMH, ArrayList<GiangVien> dsGV) {
            this.maGV = sc.next();
            this.maMH = sc.next();
            this.gioDay = sc.nextDouble();
            for(MonHoc tmp : dsMH)
                if(tmp.maMH.contentEquals(this.maMH)){
                    this.monHoc = tmp;
                    break;
                }
            for(GiangVien tmp : dsGV)
                if(tmp.maGV.contentEquals(this.maGV)){
                    tmp.tongGioDay += this.gioDay;
                    tmp.dsLHP.add(this);
                    break;
                }
        }
        
        @Override
        public String toString(){
            return this.monHoc.tenMH + ' ' + String.valueOf(this.gioDay);
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
        while(t-->0) dsLHP.add(new LopHocPhan(sc,dsMH,dsGV));
        String maGV = sc.next();
        for(GiangVien tmp : dsGV)
            if(tmp.maGV.contains(maGV))
                System.out.println(tmp);
    }
}
