package QuanHeGiuaCacLop;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class QuanLyBanHang_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        while(t-->0) dsKH.add(new KhachHang(sc));
        t = sc.nextInt();
        ArrayList<MatHang> dsMH = new ArrayList<>();
        while(t-->0) dsMH.add(new MatHang(sc));
        t = sc.nextInt();
        ArrayList<HoaDon> dsHD = new ArrayList<>();
        while(t-->0) dsHD.add(new HoaDon(sc,dsKH,dsMH));
        for(HoaDon tmp : dsHD)
            System.out.println(tmp);
    }
}

class KhachHang{
    private String maKH,tenKH,gtKH,nsKH,dcKH;
    static int sttKH = 1;
    public KhachHang(Scanner sc) {
        this.maKH = String.format("KH%03d", sttKH++);
        this.tenKH = sc.nextLine();
        this.gtKH = sc.nextLine();
        this.nsKH = sc.nextLine();
        this.dcKH = sc.nextLine();
    }
    public KhachHang(String s){
        maKH = s;
    }
    
    public String getMaKH() {
        return maKH;
    }
    
    @Override
    public boolean equals(Object o){
        return ((KhachHang) o).maKH.contentEquals(maKH);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 11 * hash + Objects.hashCode(this.maKH);
        return hash;
    }
    
    @Override
    public String toString(){
       return this.tenKH+' '+this.dcKH;
    }
}


class MatHang{
    private String maMH,tenMH,donVi;
    private int giaMua,giaBan;
    static int sttMH = 1;
    
    public MatHang(Scanner sc) {
        sc.nextLine();
        this.maMH = String.format("MH%03d", sttMH++);
        this.tenMH = sc.nextLine();
        this.donVi = sc.next();
        this.giaMua = sc.nextInt();
        this.giaBan = sc.nextInt();
    }
    
    public MatHang(String s){
        maMH = s;
    }
    
    public String getMaMH() {
        return maMH;
    }

    public int getGiaBan() {
        return giaBan;
    }
    
    @Override
    public boolean equals(Object o){
        return ((MatHang) o).maMH.contentEquals(maMH);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.maMH);
        return hash;
    }
    
    @Override
    public String toString(){
        return tenMH+' '+donVi+' '+giaMua+' '+giaBan;          
    }
}

class HoaDon{
    private String maHD;
    private int soLuong;
    private KhachHang khachHang;
    private MatHang matHang;
    private long thanhTien;
    static int sttHD = 1;

    public HoaDon(Scanner sc,ArrayList<KhachHang> dsKH,ArrayList<MatHang> dsMH) {
        this.maHD = String.format("HD%03d", sttHD++);
        String maKH = sc.next();
        String maMH = sc.next();
        this.soLuong = sc.nextInt();
        
        this.khachHang = dsKH.get(dsKH.indexOf(new KhachHang(maKH)));
        this.matHang = dsMH.get( dsMH.indexOf(new MatHang(maMH)) );
        this.thanhTien = this.matHang.getGiaBan()*this.soLuong;
    }

    @Override
    public String toString(){
        return maHD+' '+khachHang+' '+matHang+' '+soLuong+' '+thanhTien;
    }
}
        