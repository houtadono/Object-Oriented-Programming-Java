package MangDoiTuong;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Houta
 */
public class NhapXuatHang {
    private static class MatHang{
        private String id,name,type;
        private double laiSuat;

        public MatHang(String id, String name, String type) {
            this.id = id;
            this.name = name;
            this.type = type;
            if(this.type.contains("A")) this.laiSuat = 0.08;
            else if(this.type.contains("B")) this.laiSuat = 0.05;
            else this.laiSuat = 0.02;
        }
    }
    private static class DonHang{
        private String id,name;
        private long slNhap,donGiaNhap,slXuat,gtriNhap,gtriXuat;
        
        public DonHang(String id, long slNhap, long donGiaNhap, long slXuat, ArrayList<MatHang> dsMH) {
            this.id = id;
            this.slNhap = slNhap;
            this.donGiaNhap = donGiaNhap;
            this.slXuat = slXuat;
            this.gtriNhap = this.slNhap*this.donGiaNhap;
            for(MatHang tmp : dsMH)
                if(tmp.id.contains(this.id)){
                    this.name = tmp.name;
                    this.gtriXuat = (long) (this.slXuat*this.donGiaNhap*(1+tmp.laiSuat));
                    break;
                }
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        ArrayList<MatHang> dsMH = new ArrayList<>();
        while(t-->0){
            dsMH.add(new MatHang(sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        t = sc.nextInt();
        ArrayList<DonHang> dsDH = new ArrayList<>();
        while(t-->0){
            dsDH.add(new DonHang(sc.next(),sc.nextLong(),sc.nextLong(),sc.nextLong(),dsMH));
        }
        for(DonHang tmp : dsDH)
            System.out.printf("%s %s %d %d\n",tmp.id,tmp.name,tmp.gtriNhap,tmp.gtriXuat);   
    }
}
