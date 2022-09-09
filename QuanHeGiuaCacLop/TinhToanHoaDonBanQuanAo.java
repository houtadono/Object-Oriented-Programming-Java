package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhToanHoaDonBanQuanAo {
    static int stt = 1;
    private static class SanPham{
        private String maSP,tenSP;
        private int donGia1,donGia2;

        public SanPham(Scanner sc) {
            this.maSP = sc.next();
            sc.nextLine();
            this.tenSP = sc.nextLine();
            this.donGia1 = sc.nextInt();
            this.donGia2 = sc.nextInt();
        }
    }
    private static class HoaDon{
        private String maHD,tenSP;
        private int soLuong,donGia;
        private long giamGia,thanhTien,tienTra;

        public HoaDon(Scanner sc,ArrayList<SanPham> dsSP) {
            this.maHD = getMaHD(sc.next(),stt++);
            this.soLuong = sc.nextInt();
            for(SanPham tmp : dsSP)
                if(this.maHD.contains(tmp.maSP)){
                    this.tenSP = tmp.tenSP;
                    if(this.maHD.charAt(2) == '1') this.donGia = tmp.donGia1;
                    else this.donGia = tmp.donGia2;
                }
            this.thanhTien = this.donGia*this.soLuong;
            if(this.soLuong>=150) this.giamGia = Math.round(this.thanhTien*0.5);
            else if(this.soLuong>=100) this.giamGia = Math.round(this.thanhTien*0.3);
            else if(this.soLuong>=50) this.giamGia = Math.round(this.thanhTien*0.15);
            else this.giamGia = 0;
            this.tienTra = this.thanhTien - this.giamGia;
        }
        static String getMaHD(String s,int n){
            String b = String.valueOf(n);
            while(b.length()<3) b = '0'+b;
            return s+"-"+b;
        }
        
        @Override
        public String toString(){
            return this.maHD+' '+this.tenSP+' '+String.format("%d %d",this.giamGia,this.tienTra);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<SanPham> dsSP = new ArrayList<>();
        while(t-->0)
            dsSP.add(new SanPham(sc));
        t = sc.nextInt();
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        while(t-->0)
            dsHD.add(new HoaDon(sc,dsSP));
        for(HoaDon tmp : dsHD)
            System.out.println(tmp);
    }
}
