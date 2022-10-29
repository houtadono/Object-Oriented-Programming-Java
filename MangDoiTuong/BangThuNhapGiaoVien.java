package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangThuNhapGiaoVien {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine()); 
        ArrayList<GiaoVien> ds = new ArrayList<>();
        while(t-->0){
            GiaoVien a = new GiaoVien(sc.nextLine(),sc.nextLine(), Long.parseLong(sc.nextLine()));
            if(a.canAdd)
                ds.add(a);
        }
        for(GiaoVien tmp : ds){
            System.out.println(tmp);
        }
    }
}
class GiaoVien{
    private String id,name;
    private long luongCoBan,heSoLuong,phuCap,thuNhap;
    public boolean canAdd = true;
    private static int soHT = 0;
    private static int soHP = 0;
    
    public GiaoVien(String id, String name,long luongCoBan) {
        this.id = id;
        if(id.startsWith("HT")){
            soHT++;
            if(soHT>1){
                this.canAdd = false;
                return;
            }
        }
        if(id.startsWith("HP")){
            soHP++;
            if(soHP>2){
                this.canAdd = false;
                return;
            }
        }
        this.name = name;   
        this.luongCoBan = luongCoBan;
        this.heSoLuong = Long.parseLong(this.id.substring(2));
        if(this.id.startsWith("HT")) this.phuCap = 2000000;
        else if(this.id.startsWith("HP")) this.phuCap = 900000;
        else this.phuCap = 500000;
        this.thuNhap = this.luongCoBan*this.heSoLuong + this.phuCap;
    }
    
    @Override
    public String toString(){
        return String.format("%s %s %d %d %d",id,name,heSoLuong,phuCap,thuNhap);
    }
}
