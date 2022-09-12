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
public class TinhTienDien {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String maKH,tenKH,loaiHoGD;
        private int chiSoDau,chiSoCuoi,soDien,dinhMuc;
        private long tienDien,tienVuotDM,thueVAT,tienPhaiNop;

        public KhachHang(Scanner sc){
            this.maKH = layMaKH(stt++);
            sc.nextLine();
            this.tenKH = chuanHoaTen(sc.nextLine());
            this.loaiHoGD = sc.next();
            this.chiSoDau = sc.nextInt();
            this.chiSoCuoi = sc.nextInt();
            this.soDien = this.chiSoCuoi - this.chiSoDau;
            if(this.loaiHoGD.contains("A")) this.dinhMuc = 100;
            if(this.loaiHoGD.contains("B")) this.dinhMuc = 500;
            if(this.loaiHoGD.contains("C")) this.dinhMuc = 200;
            if(this.soDien<=this.dinhMuc){
                this.tienDien = this.soDien*450;
                this.tienVuotDM = 0;
                this.thueVAT = 0;
            }
            else{
                this.tienDien = this.dinhMuc*450;
                this.tienVuotDM = (this.soDien-this.dinhMuc)*1000;
                this.thueVAT = this.tienVuotDM*5/100;
            }
            this.tienPhaiNop = this.tienDien+this.tienVuotDM+this.thueVAT;
            
        }
        static String layMaKH(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "KH"+s;
        }
        static String chuanHoaTen(String s){
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
        
        @Override
        public String toString(){
            return String.format("%s %s %d %d %d %d",this.maKH,this.tenKH,this.tienDien,this.tienVuotDM,this.thueVAT,this.tienPhaiNop);
        }

        @Override
        public int compareTo(KhachHang o) {
            if(this.tienPhaiNop<o.tienPhaiNop) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int t = sc.nextInt();
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        while(t-->0) dsKH.add(new KhachHang(sc));
        Collections.sort(dsKH);
        for(KhachHang tmp : dsKH)
            System.out.println(tmp);
    }
}
