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
public class XepLoai {
    static int stt = 1;
    private static class SinhVien implements Comparable<SinhVien>{
        private String maSV,tenSV,xepLoai;
        private double diem1,diem2,diem3,diemTB;

        public SinhVien(Scanner sc) {
            sc.nextLine();
            this.maSV = layMaSV(stt++);
            this.tenSV = chuanHoaTen(sc.nextLine());
            this.diem1 = sc.nextDouble();
            this.diem2 = sc.nextDouble();
            this.diem3 = sc.nextDouble();
            this.diemTB = (this.diem1*25+this.diem2*35+this.diem3*40)/100;
            if(this.diemTB>=8) this.xepLoai = "GIOI";
            else if(this.diemTB>=6.5) this.xepLoai = "KHA";
            else if(this.diemTB>=5) this.xepLoai = "TRUNG BINH";
            else this.xepLoai = "KEM";
        }
        static String layMaSV(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "SV"+s;
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
            return String.format("%s %s %.2f %s",this.maSV,this.tenSV,this.diemTB,this.xepLoai);
        }
        @Override
        public int compareTo(SinhVien o) {
            if(this.diemTB<o.diemTB) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int t = sc.nextInt();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        for(int i = 0; i<t; i++) dsSV.add(new SinhVien(sc));
        Collections.sort(dsSV);
        for(SinhVien tmp : dsSV)
            System.out.println(tmp);
    }
}
