package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeNhanVienTheoNhom {
    static int soGD=0,soTP=0,soPP=0;
    private static class NhanVien implements Comparable<NhanVien>{
        private String id,name,chucVu,soHieuNV,heSoLuong;

        public NhanVien(String id, String name) {
            this.id = getId(id);
            this.name = name;
            this.chucVu = this.id.substring(0,2);
            this.soHieuNV = this.id.substring(4);
            this.heSoLuong = this.id.substring(2,4);
        }
        
        static String getId(String s){
            if(s.startsWith("GD")){
                if(soGD == 1){
                    return "NV"+s.substring(2);
                }
                soGD++;
            }
            if(s.startsWith("TP")){
                if(soTP == 3){
                    return "NV"+s.substring(2);
                }
                soTP++;
            }
            if(s.startsWith("PP")){
                if(soPP == 3){
                    return "NV"+s.substring(2);
                }
                soPP++;
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
        t = sc.nextInt(); 
        while(t-->0){
            String chucVu = sc.next();
            for(NhanVien tmp : ds)
                if(tmp.chucVu.contains(chucVu))
                    System.out.printf("%s %s %s %s\n",tmp.name,tmp.chucVu,tmp.soHieuNV,tmp.heSoLuong);
            System.out.println();
        }
    }
}
