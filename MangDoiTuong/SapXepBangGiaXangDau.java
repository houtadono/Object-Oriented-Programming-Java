package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepBangGiaXangDau {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<DonHang> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new DonHang(sc.next(),sc.nextLong()));
        }
        Collections.sort(ds);
        for(DonHang tmp : ds)
            System.out.println(tmp);
           
    }
}

class DonHang implements Comparable<DonHang>{
    private String id,hangSanXuat;
    private long sl,donGia,thue,thanhTien;
    private double phanTramThue;

    public DonHang(String id, long sl) {
        this.id = id;
        this.sl = sl;
        if(this.id.startsWith("X")){
            this.phanTramThue = 0.03;
            this.donGia = 128000;
        }else if(this.id.startsWith("D")){
            this.phanTramThue = 0.035;
            this.donGia = 11200;
        }else{
            this.phanTramThue = 0.02;
            this.donGia = 9700;
        }
        if(this.id.endsWith("TN")){
            this.hangSanXuat = "Trong Nuoc";
            this.phanTramThue = 0;
        }else if(this.id.endsWith("BP")){
            this.hangSanXuat = "British Petro";
        }else if(this.id.endsWith("ES")){
            this.hangSanXuat = "Esso";
        }else if(this.id.endsWith("SH")){
            this.hangSanXuat = "Shell";
        }else if(this.id.endsWith("CA")){
            this.hangSanXuat = "Castrol";
        }else this.hangSanXuat = "Mobil";
        this.thue = (long) (this.sl*this.donGia *this.phanTramThue);
        this.thanhTien = this.sl*this.donGia +this.thue;
    }

    @Override
    public int compareTo(DonHang o) {
        if(this.thanhTien<o.thanhTien) return 1;
        return -1;
    }
    @Override
    public String toString(){
        return String.format("%s %s %d %d %d",id,hangSanXuat,donGia,thue,thanhTien);
    }
}
