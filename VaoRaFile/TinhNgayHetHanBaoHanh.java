package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhNgayHetHanBaoHanh {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MUAHANG.in"));
        int t = sc.nextInt();
        ArrayList<SanPham> dsSP = new ArrayList<>();
        while(t-->0) dsSP.add(new SanPham(sc));
        
        t = sc.nextInt();
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        int stt = 1;
        while(t-->0) dsKH.add(new KhachHang(sc,stt++,dsSP));
        Collections.sort(dsKH);
        for(KhachHang tmp : dsKH)
            System.out.println(tmp);
    }
}

class SanPham{
    public String maSp,tenSP;
    public long giaBan,thoiHanBaoHanh;

    public SanPham(Scanner sc) {
        this.maSp = sc.next();
        sc.nextLine();
        this.tenSP = sc.nextLine();
        this.giaBan = sc.nextLong();
        this.thoiHanBaoHanh = sc.nextLong();
    }
}

class KhachHang implements Comparable<KhachHang>{
    private String maKH,tenKH,diaChi,maSP;
    private long soLuong,soTien;
    private LocalDate ngayMua,ngayHetHan;
    private SanPham sp;

    public KhachHang(Scanner sc, int stt, ArrayList<SanPham> dsSP) {
        this.maKH = "KH" + String.format("%02d", stt);
        sc.nextLine();
        this.tenKH = sc.nextLine();
        this.diaChi = sc.nextLine();
        this.maSP = sc.next();
        this.soLuong = sc.nextLong();
        this.ngayMua = DateTimeFormatter.ofPattern("dd/MM/yyyy").parse(sc.next(), LocalDate::from) ;
        for(SanPham tmp : dsSP)
            if(tmp.maSp.contentEquals(this.maSP)){
                this.sp = tmp;
                break;
            }
        this.soTien = this.soLuong*this.sp.giaBan;
        this.ngayHetHan = this.ngayMua.plusMonths(this.sp.thoiHanBaoHanh);
    }

    @Override
    public String toString(){
        return this.maKH+' '+this.tenKH+' '+this.diaChi+' '+this.maSP+' '+String.format("%d", this.soTien) 
            +' '+ DateTimeFormatter.ofPattern("dd/MM/yyyy").format(this.ngayHetHan);
    }

    @Override
    public int compareTo(KhachHang o) {
        if(this.ngayHetHan.compareTo(o.ngayHetHan)==0)
            return this.maKH.compareTo(o.maKH);
        return this.ngayHetHan.compareTo(o.ngayHetHan);
    }
}