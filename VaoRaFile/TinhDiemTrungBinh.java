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
public class TinhDiemTrungBinh {
    static int stt = 1;
    private static class SinhVien implements Comparable<SinhVien>{
        private String maSV,tenSV;
        private double diem1,diem2,diem3,diemTB;
        private int thuHang;

        public SinhVien(Scanner sc) {
            sc.nextLine();
            this.maSV = layMaSV(stt++);
            this.tenSV = chuanHoaTen(sc.nextLine());
            this.diem1 = sc.nextDouble();
            this.diem2 = sc.nextDouble();
            this.diem3 = sc.nextDouble();
            this.diemTB = (this.diem1*3+this.diem2*3+this.diem3*2)/8;
            this.diemTB = (double)Math.round(this.diemTB*100) /100;
        }
        double getDiemTB(){
            return this.diemTB;
        }
        int getThuHang(){
            return this.thuHang;
        }
        void setThuHang(int n){
            this.thuHang = n;
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
            return String.format("%s %s %.2f %d",this.maSV,this.tenSV,this.diemTB,this.thuHang);
        }
        @Override
        public int compareTo(SinhVien o) {
            if(this.diemTB<o.diemTB) return 1;
            if(this.diemTB>o.diemTB) return -1;
            return this.maSV.compareTo(o.maSV);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("BANGDIEM.in"));
        int t = sc.nextInt();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        for(int i = 0; i<t; i++) dsSV.add(new SinhVien(sc));
        Collections.sort(dsSV);
        dsSV.get(0).setThuHang(1);
        System.out.println(dsSV.get(0));
        for(int i = 1; i<t; i++){
            if(dsSV.get(i).getDiemTB() == dsSV.get(i-1).getDiemTB())
                dsSV.get(i).setThuHang(dsSV.get(i-1).getThuHang());
            else 
                dsSV.get(i).setThuHang(i+1);
            System.out.println(dsSV.get(i));
        }
    }
}
