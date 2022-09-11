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
public class SapXepMatHang{
    static int sttMH = 1;
    private static class MatHang implements Comparable<MatHang>{
        private String maMH,tenMH,nhomMH;
        private double giaMua,giaBan,loiNhuan;

        public MatHang(Scanner sc) {
            sc.nextLine();
            this.maMH = getMaMH(sttMH++);
            this.tenMH = sc.nextLine();
            this.nhomMH = sc.nextLine();
            this.giaMua = sc.nextDouble();
            this.giaBan = sc.nextDouble();
            this.loiNhuan = this.giaBan - this.giaMua;
        }
        static String getMaMH(int n){
            String s = String.valueOf(n);
            while(s.length()==1) s = '0'+s;
            return "MH" + s;
        }
        
        @Override
        public String toString(){
            return this.maMH+' '+this.tenMH+' '+this.nhomMH+' '+String.format("%.2f", this.loiNhuan);
        }
        @Override
        public int compareTo(MatHang o) {
            if(this.loiNhuan<o.loiNhuan) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATHANG.in"));
        int t = sc.nextInt();
        ArrayList<MatHang> dsMH = new ArrayList<>();
        while(t-->0) dsMH.add(new MatHang(sc));
        Collections.sort(dsMH);
        for(MatHang tmp : dsMH)
            System.out.println(tmp);
    }
}
