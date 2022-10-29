package KhongCoChuDeCon;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachSinhVienTrongFile_1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int n = sc.nextInt();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        while(n-->0)
            dsSV.add(new SinhVien(sc));
        
        Collections.sort(dsSV);
        for(SinhVien tmp : dsSV)
            System.out.println(tmp);
    }
}

class SinhVien implements Comparable<SinhVien>{
    private String maSV, tenSV, lopSV, email;

    public SinhVien(Scanner sc ) {
        this.maSV = sc.next();
        sc.nextLine();
        this.tenSV = chuanHoaTen(sc.nextLine());
        this.lopSV = sc.next();
        this.email = sc.next();
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
        return this.maSV+' '+this.tenSV+' '+this.lopSV+' '+this.email;
    }

    @Override
    public int compareTo(SinhVien o) {
        return this.maSV.compareTo(o.maSV);
    }
}