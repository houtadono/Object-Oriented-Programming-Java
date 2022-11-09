package ThucHanhNhom8_To2;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TraCuuDonHang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<DonHang> dsDH = new ArrayList<>();
        while(t-->0) dsDH.add(new DonHang(sc));
        for(DonHang tmp : dsDH)
            System.out.println(tmp);
    }
}

class DonHang{
    String tenDH,maDH,ttDH;
    long donGia,soLuong,giamGia,thanhTien;

    public DonHang(Scanner sc) {
        sc.nextLine();
        this.tenDH = sc.nextLine();
        this.maDH = sc.next();
        this.donGia = sc.nextLong();
        this.soLuong = sc.nextLong();
        this.ttDH = this.maDH.substring(1,4);
        if(this.maDH.endsWith("1")) this.giamGia = Math.round(this.donGia*this.soLuong*30/100);
        else this.giamGia = Math.round(this.donGia*this.soLuong*50/100);
        this.thanhTien = this.donGia*this.soLuong - this.giamGia;
    }
    @Override
    public String toString(){
        return String.format("%s %s %s %d %d", this.tenDH,this.maDH,this.ttDH,this.giamGia,this.thanhTien);
    }
}
