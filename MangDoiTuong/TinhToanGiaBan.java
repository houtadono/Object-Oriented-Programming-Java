package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhToanGiaBan {
    private static class DonHang{
        private String id;
        private double donGia,sl,tienHang,thue,ship,tongChiPhi,giaBan;

        DonHang(String id, double donGia, double sl) {
            this.id = id;
            this.donGia = donGia;
            this.sl = sl;
            this.tienHang = this.sl*this.donGia;
            if(this.id.startsWith("T")){
                this.thue = this.tienHang*29/100.0;
                this.ship = this.tienHang*4/100.0;
            }
            else if(this.id.startsWith("C")){
                this.thue = this.tienHang*10/100.0;
                this.ship = this.tienHang*3/100.0;
            }
            else if(this.id.startsWith("T")){
                this.thue = this.tienHang*8/100.0;
                this.ship = this.tienHang*2.5/100.0;
            }else{
                this.thue = this.tienHang*2/100.0;
                this.ship = this.tienHang*0.5/100.0;
            }
            if(this.id.endsWith("C")) this.thue = this.thue*95/100.0;
            this.tongChiPhi = (this.tienHang+this.thue+this.ship)*1.2;
            this.giaBan = this.tongChiPhi/sl;
        }
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<DonHang> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new DonHang(sc.next(),sc.nextDouble(),sc.nextDouble()));
        }
        for(DonHang tmp : ds)
            System.out.printf("%s %.2f\n",tmp.id,tmp.giaBan);   
    }
}
