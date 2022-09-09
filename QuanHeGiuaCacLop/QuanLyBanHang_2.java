package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class QuanLyBanHang_2 {
    static int sttKH = 1;
    private static class KhachHang{
        private String maKH,tenKH,gtKH,nsKH,dcKH;

        public KhachHang(Scanner sc) {
            this.maKH = getMaKH(sttKH++);
            this.tenKH = sc.nextLine();
            this.gtKH = sc.nextLine();
            this.nsKH = sc.nextLine();
            this.dcKH = sc.nextLine();
        }
        static String getMaKH(int n){
            String s = String.valueOf(n);
            while(s.length()<3) s = '0'+s;
            return "KH" + s;
        }
    }
    
    static int sttMH = 1;
    private static class MatHang{
        private String maMH,tenMH,donVi;
        private int giaMua,giaBan;

        public MatHang(Scanner sc) {
            sc.nextLine();
            this.maMH = getMaMH(sttMH++);
            this.tenMH = sc.nextLine();
            this.donVi = sc.next();
            this.giaMua = sc.nextInt();
            this.giaBan = sc.nextInt();
        }
        static String getMaMH(int n){
            String s = String.valueOf(n);
            while(s.length()<3) s = '0'+s;
            return "MH" + s;
        }
    }
    
    static int sttHD = 1;
    private static class HoaDon implements Comparable<HoaDon>{
        private String maHD,maKH,maMH;
        private int soLuong;
        private KhachHang khachKhang;
        private MatHang matHang;
        private long thanhTien,loiNhuan;

        public HoaDon(Scanner sc,ArrayList<KhachHang> dsKH,ArrayList<MatHang> dsMH) {
            this.maHD = getMaHD(sttHD++);
            this.maKH = sc.next();
            this.maMH = sc.next();
            this.soLuong = sc.nextInt();
            for(KhachHang tmp : dsKH)
                if(tmp.maKH.contentEquals(this.maKH)){
                    this.khachKhang = tmp;
                    break;
                }
            for(MatHang tmp : dsMH)
                if(tmp.maMH.contentEquals(this.maMH)){
                    this.matHang = tmp;
                    break;
                }
            this.thanhTien = this.matHang.giaBan*this.soLuong;
            this.loiNhuan = this.thanhTien - this.matHang.giaMua*this.soLuong;
        }
        static String getMaHD(int n){
            String s = String.valueOf(n);
            while(s.length()<3) s = '0'+s;
            return "HD" + s;
        }
        
        @Override
        public String toString(){
            return String.format("%s %s %s %s %d %d %d",
                this.maHD,this.khachKhang.tenKH,this.khachKhang.dcKH,
                this.matHang.tenMH,this.soLuong,this.thanhTien,this.loiNhuan);
        }
        @Override
        public int compareTo(HoaDon o) {
            if(this.loiNhuan<o.loiNhuan) return 1;
            if(this.loiNhuan>o.loiNhuan) return -1;
            return this.maHD.compareTo(o.maHD);
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        while(t-->0) dsKH.add(new KhachHang(sc));
        t = sc.nextInt();
        ArrayList<MatHang> dsMH = new ArrayList<>();
        while(t-->0) dsMH.add(new MatHang(sc));
        t = sc.nextInt();
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        while(t-->0) dsHD.add(new HoaDon(sc,dsKH,dsMH));
        Collections.sort(dsHD);
        for(HoaDon tmp : dsHD)
            System.out.println(tmp);
    }
}
