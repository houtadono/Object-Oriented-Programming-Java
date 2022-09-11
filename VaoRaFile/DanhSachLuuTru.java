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
public class DanhSachLuuTru {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String maKH,tenKH,maPhong,ngayDen,ngayDi;
        private long ngayLuuTru;
        
        public KhachHang(Scanner sc) {
            this.maKH = layMaKH(stt++);
            sc.nextLine();
            this.tenKH = sc.nextLine();
            this.maPhong = sc.next();
            this.ngayDen = sc.next();
            this.ngayDi = sc.next();
            this.ngayLuuTru = layNgayLuuTru(this.ngayDen,this.ngayDi);
        }
        static String layMaKH(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0' + s;
            return "KH" + s;
        }
        static long layNgayLuuTru(String dayIn,String dayOut){
            try {
                DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateIn = simpleDateFormat.parse(dayIn);
                Date dateOut = simpleDateFormat.parse(dayOut);
                return (dateOut.getTime() - dateIn.getTime()) /(24 * 60 * 60 * 1000);
            } catch (ParseException ex) {
                Logger.getLogger(DanhSachLuuTru.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }
        
        @Override
        public String toString(){
            return this.maKH+' '+this.tenKH+' '+this.maPhong+' '+String.valueOf(this.ngayLuuTru);
        }
        @Override
        public int compareTo(KhachHang o) {
            if(this.ngayLuuTru<o.ngayLuuTru) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACH.in"));
        int t = sc.nextInt();
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        while(t-->0) dsKH.add(new KhachHang(sc));
        Collections.sort(dsKH);
        for(KhachHang tmp : dsKH)
            System.out.println(tmp);
    }
}
