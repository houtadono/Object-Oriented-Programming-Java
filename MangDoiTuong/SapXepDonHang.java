package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepDonHang {
    private static class DonHang implements Comparable<DonHang>{
        private String name,id,stt;
        private long donGia,sl,giamGia,pay;
        
        DonHang(Scanner sc){
            this.name = sc.nextLine();
            this.id = sc.next();
            this.donGia = sc.nextLong();
            this.sl = sc.nextLong();
            this.stt = this.id.substring(1,4);
            if(this.id.endsWith("1")) this.giamGia = Math.round(this.donGia*this.sl/2);
            else this.giamGia = Math.round(this.donGia*this.sl/10*3);
            this.pay = this.donGia*this.sl - this.giamGia;
        }

        @Override
        public int compareTo(DonHang o) {
            return this.stt.compareTo(o.stt);
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<DonHang> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new DonHang(sc));
        }
        Collections.sort(ds);
        for(DonHang tmp : ds)
            System.out.printf("%s %s %s %d %d\n",tmp.name,tmp.id,tmp.stt,tmp.giamGia,tmp.pay);
    }
}
