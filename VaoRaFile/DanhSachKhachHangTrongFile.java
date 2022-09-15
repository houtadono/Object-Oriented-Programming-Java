package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
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
public class DanhSachKhachHangTrongFile {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        int stt = 1;
        while(t-->0) dsKH.add(new KhachHang(sc,stt++));
        Collections.sort(dsKH);
        for(KhachHang tmp : dsKH)
            System.out.println(tmp);
    }
}
class KhachHang implements Comparable<KhachHang>{
    private String maKH,tenKH,gioiTinh;
    private Date birthday;
    private String diaChi;

    public KhachHang(Scanner sc,int stt) {
        this.maKH = "KH"+String.format("%03d", stt);
        this.tenKH = chuanHoaTen(sc.nextLine());
        this.gioiTinh = sc.next();
        try {
            this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
        } catch (ParseException ex) {
            Logger.getLogger(KhachHang.class.getName()).log(Level.SEVERE, null, ex);
        }
        sc.nextLine();
        this.diaChi = sc.nextLine();
    }
    private static String chuanHoaTen(String s){
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
        return this.maKH+' '+this.tenKH+' '+this.gioiTinh+' '+this.diaChi+' '+new SimpleDateFormat("dd/MM/yyyy").format(this.birthday);
    }
    @Override
    public int compareTo(KhachHang o) {
        return this.birthday.compareTo(o.birthday);
    }
}