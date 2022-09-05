package MangDoiTuong;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachThucTap_3 {
    private static class SinhVien{
        private String idSV,tenSV,clas,email;

        SinhVien(Scanner sc) {
            this.idSV = sc.next();
            sc.nextLine();
            this.tenSV = standardName(sc.nextLine());
            this.clas = sc.nextLine();
            this.email = sc.nextLine();
        }
        static String standardName(String s){
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
    }
    private static class DoanhNghiep{
        private String idDN,tenDN;
        private int soSVnhan;

        DoanhNghiep(Scanner sc) {
            this.idDN = sc.next();
            sc.nextLine();
            this.tenDN = sc.nextLine();
            this.soSVnhan = sc.nextInt();
        }
    }
    private static class ThucTap implements Comparable<ThucTap>{
        private String idSV,idDN;
        private String tenSV,clas,email;
        ThucTap(Scanner sc, ArrayList<SinhVien> dsSV){
            this.idSV =sc.next();
            this.idDN = sc.next();
            for(SinhVien tmp : dsSV)
                if(tmp.idSV.contains(this.idSV)){
                    this.tenSV = tmp.tenSV;
                    this.clas = tmp.clas;
                    this.email = tmp.email;
                    break;
                }
        }
        @Override
        public int compareTo(ThucTap o) {
            return this.idSV.compareTo(o.idSV);
        }
        @Override
        public String toString(){
            return this.idSV+' '+this.tenSV+' '+this.clas;
        }
    }
    
    public static void main(String []args) throws FileNotFoundException{
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = sc.nextInt(); 
        while(t-->0) dsSV.add(new SinhVien(sc));
        
        ArrayList<DoanhNghiep> dsDN = new ArrayList<>();
        sc = new Scanner(new File("DN.in"));
        t = sc.nextInt(); sc.nextLine();
        while(t-->0) dsDN.add(new DoanhNghiep(sc));
        
        ArrayList<ThucTap> dsTT = new ArrayList<>();
        sc = new Scanner(new File("THUCTAP.in"));
        t = sc.nextInt();
        while(t-->0) dsTT.add(new ThucTap(sc,dsSV));
        Collections.sort(dsTT);
        t = sc.nextInt();
        while(t-->0){
            String idDN = sc.next();
            int soSVnhan = 1;
            for(DoanhNghiep tmp : dsDN)
                if(tmp.idDN.contentEquals(idDN)){
                    soSVnhan = tmp.soSVnhan;
                    System.out.printf("DANH SACH THUC TAP TAI %s:\n",tmp.tenDN);
                    break;
                }
            for(ThucTap tmp : dsTT){
                if(tmp.idDN.contentEquals(idDN)){
                    soSVnhan--;
                    System.out.println(tmp);
                    if(soSVnhan == 0) break;
                }
            }
        }
    }
}
