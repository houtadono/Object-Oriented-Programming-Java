package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachMatHang {
    static int stt = 1;
    private static class MatHang implements Comparable<MatHang>{
        private String id,name,donVi;
        private long giaMua,giaBan,loiNhuan;

        public MatHang(String name, String donVi, long giaMua, long giaBan) {
            this.id = getId(stt++);
            this.name = name;
            this.donVi = donVi;
            this.giaMua = giaMua;
            this.giaBan = giaBan;
            this.loiNhuan = this.giaBan-this.giaMua;
        }
        static String getId(int n){
            String s = String.valueOf(n);
            while(s.length()<3) s = '0'+s;
            return "MH"+s;
        }

        @Override
        public int compareTo(MatHang o) {
            if(this.loiNhuan<o.loiNhuan) return 1;
            if(this.loiNhuan>o.loiNhuan) return -1;
            return this.id.compareTo(o.id);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<MatHang> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine(); 
            ds.add(new MatHang(sc.nextLine(),sc.next(),sc.nextLong(),sc.nextLong()));
        }
        Collections.sort(ds);
        for(MatHang tmp : ds)
            System.out.printf("%s %s %s %d %d %d\n",tmp.id,tmp.name,tmp.donVi,tmp.giaBan,tmp.giaMua,tmp.loiNhuan);
    }
}
