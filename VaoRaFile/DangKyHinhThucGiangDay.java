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
public class DangKyHinhThucGiangDay {
    private static class MonHoc implements Comparable<MonHoc>{
        private String maMH,tenMH;
        private int soTinChi;
        private String hthuc1,hthuc2;

        public MonHoc(Scanner sc) {
            this.maMH = sc.next();
            sc.nextLine();
            this.tenMH = sc.nextLine();
            this.soTinChi = Integer.parseInt(sc.nextLine());
            this.hthuc1 = sc.nextLine();
            this.hthuc2 = sc.nextLine();
        }

        @Override
        public String toString(){
            return String.format("%s %s %d %s %s", this.maMH,this.tenMH,this.soTinChi,this.hthuc1,this.hthuc2);
        }
        @Override
        public int compareTo(MonHoc o) {
            return this.maMH.compareTo(o.maMH);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = sc.nextInt();
        ArrayList<MonHoc> dsP = new ArrayList<>();
        while(t-->0)
            dsP.add(new MonHoc(sc));
        Collections.sort(dsP);
        for(MonHoc tmp: dsP)
            if(!tmp.hthuc2.contentEquals("Truc tiep"))
                System.out.println(tmp);
    }
}
