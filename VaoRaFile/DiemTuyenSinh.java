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
public class DiemTuyenSinh {
    static int stt = 1;
    private static class ThiSinh implements Comparable<ThiSinh>{
        private String maTS,tenTS;
        private double diemThi,diemCong,tongDiem;
        private String danToc,trangThai;
        private int khuVuc;

        public ThiSinh(Scanner sc) {
            this.maTS = layMaTS(stt++);
            sc.nextLine();
            this.tenTS = chuanHoaTen(sc.nextLine());
            this.diemThi = sc.nextDouble();
            sc.nextLine();
            this.danToc = sc.nextLine();
            this.khuVuc = sc.nextInt();
            if(!this.danToc.contentEquals("Kinh")) this.diemCong = 1.5;
            else this.diemCong = 0;
            if(this.khuVuc == 1) this.diemCong += 1.5;
            if(this.khuVuc == 2) this.diemCong += 1;
            this.tongDiem = this.diemThi + this.diemCong;
            if(this.tongDiem>=20.5) this.trangThai = "Do";
            else this.trangThai = "Truot";
        }
        static String layMaTS(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "TS"+s;
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
            return String.format("%s %s %.1f %s", this.maTS,this.tenTS,this.tongDiem,this.trangThai);
        }

        @Override
        public int compareTo(ThiSinh o) {
            if(this.tongDiem<o.tongDiem) return 1;
            if(this.tongDiem>o.tongDiem) return -1;
            return this.maTS.compareTo(o.maTS);
        }
        
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("THISINH.in"));
        int t = sc.nextInt();
        ArrayList<ThiSinh> dsTS = new ArrayList<>();
        while(t-->0) dsTS.add(new ThiSinh(sc));
        Collections.sort(dsTS);
        for(ThiSinh tmp : dsTS)
            System.out.println(tmp);
    }
}
