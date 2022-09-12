package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class QuanLyKhachSan {
    private static class Phong{
        private String kyHieuP,tenLoaiP;
        private double donGia,phiPhucVu;

        public Phong(Scanner sc) {
            this.kyHieuP = sc.next();
            this.tenLoaiP = sc.next();
            this.donGia = sc.nextDouble();
            this.phiPhucVu = sc.nextDouble();
        }
    }
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String maKH,tenKH,maP,dayIn,dayOut;
        private long soNgayLuuTru;
        private Double giamGia,phiPhucVu,phaiTra;
        private Phong p;
        
        public KhachHang(Scanner sc,ArrayList<Phong> dsP) {
            this.maKH = layMaKH(stt++);
            sc.nextLine();
            this.tenKH = sc.nextLine();
            this.maP = sc.next();
            this.dayIn = sc.next();
            this.dayOut = sc.next();
            this.soNgayLuuTru = getDay(this.dayIn,this.dayOut);
            if(this.soNgayLuuTru < 10) this.giamGia = 0.0;
            else if(this.soNgayLuuTru < 20) this.giamGia = 0.02;
            else if(this.soNgayLuuTru < 30) this.giamGia = 0.04;
            else this.giamGia = 0.06;
            for(Phong tmp : dsP)
                if(tmp.kyHieuP.contentEquals(this.maP.substring(2,3))){
                    this.p = tmp;
                    break;
                }
            long soNgay = this.soNgayLuuTru;
            if(soNgay == 0) soNgay++;
            this.phiPhucVu = this.p.phiPhucVu * this.p.donGia * soNgay;
            this.phaiTra = (this.p.donGia * soNgay + this.phiPhucVu)*(1-this.giamGia);
        }
        static String layMaKH(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "KH"+s;
        }
        static long getDay(String dayIn,String dayOut){
            try {
                DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateIn = simpleDateFormat.parse(dayIn);
                Date dateOut = simpleDateFormat.parse(dayOut);
                return (dateOut.getTime() - dateIn.getTime()) /(24 * 60 * 60 * 1000);
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyKhachSan.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }

        
        @Override
        public String toString(){
            return String.format("%s %s %s %d %.2f", this.maKH,this.tenKH,this.maP,this.soNgayLuuTru,this.phaiTra);
        }
        @Override
        public int compareTo(KhachHang o) {
            if(this.soNgayLuuTru<o.soNgayLuuTru) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        int t = sc.nextInt();
        ArrayList<Phong> dsP = new ArrayList<>();
        while(t-->0) dsP.add(new Phong(sc));
        t = sc.nextInt();
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        while(t-->0) dsKH.add(new KhachHang(sc,dsP));
        Collections.sort(dsKH);
        for(KhachHang tmp : dsKH)
            System.out.println(tmp);
    }
}
