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
public class DanhSachMonHoc {
    private static class MonHoc implements Comparable<MonHoc>{
        private String maMon,tenMon;
        private int soTinChi;

        public MonHoc(Scanner sc) {
            this.maMon = sc.next();
            sc.nextLine();
            this.tenMon = sc.nextLine();
            this.soTinChi = sc.nextInt();
        }
        
        @Override
        public String toString(){
            return this.maMon+' '+this.tenMon+' '+String.format("%d",this.soTinChi);
        }
        @Override
        public int compareTo(MonHoc o) {
            return this.tenMon.compareTo(o.tenMon);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = sc.nextInt();
        ArrayList<MonHoc> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new MonHoc(sc));
        }
        Collections.sort(ds);
        for(MonHoc tmp : ds) 
            System.out.println(tmp);
    }
}
