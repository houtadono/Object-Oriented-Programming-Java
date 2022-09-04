package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TimKiemNhanVienTheoTen {
    static int soGD=0,soTP=0,soPP=0;
    private static class NhanVien implements Comparable<NhanVien>{
        private String id,name,chucVu,soHieuNV,heSoLuong;

        public NhanVien(String id, String name) {
            this.soHieuNV = id.substring(4);
            this.heSoLuong = id.substring(2,4);
            this.id = getId(id,Integer.parseInt(this.soHieuNV));
            this.name = name;
            this.chucVu = this.id.substring(0,2);
        }
        
        static String getId(String s,int soHieu){
            if(s.startsWith("GD")&&soHieu>1){
                return "NV"+s.substring(2);
            }
            if(s.startsWith("PP") &&soHieu>3 ){
                return "NV"+s.substring(2);
            }
            if(s.startsWith("TP") &&soHieu>3 ){
                return "NV"+s.substring(2);
            }
            return s;
        }

        @Override
        public int compareTo(NhanVien o) {
            if(this.heSoLuong.contains(o.heSoLuong))
                return this.soHieuNV.compareTo(o.soHieuNV);
            return o.heSoLuong.compareTo(this.heSoLuong);
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<NhanVien> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new NhanVien(sc.next(),sc.nextLine()));
        }
        Collections.sort(ds);
        t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String tuKhoa = sc.nextLine();
            for(NhanVien tmp : ds)
                if(tmp.name.toLowerCase().contains(tuKhoa.toLowerCase()))
                    System.out.printf("%s %s %s %s\n",tmp.name,tmp.chucVu,tmp.soHieuNV,tmp.heSoLuong);
            System.out.println();
        }
    }
}
