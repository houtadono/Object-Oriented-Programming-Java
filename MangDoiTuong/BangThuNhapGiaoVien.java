package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangThuNhapGiaoVien {
    private static class GiaoVien{
        private String id,name;
        private long luongCoBan,heSoLuong,phuCap,thuNhap;

        GiaoVien(String id, String name,long luongCoBan) {
            this.id = id;
            this.name = name;   
            this.luongCoBan = luongCoBan;
            this.heSoLuong = Long.parseLong(this.id.substring(2));
            if(this.id.startsWith("HT")) this.phuCap = 2000000;
            else if(this.id.startsWith("HP")) this.phuCap = 900000;
            else this.phuCap = 500000;
            this.thuNhap = this.luongCoBan*this.heSoLuong + this.phuCap;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<GiaoVien> ds = new ArrayList<>();
        int soHT = 0,soHP = 0;
        while(t-->0){
            String id = sc.next(); sc.nextLine();
            if(id.startsWith("HT")){
                if(soHT==1){
                    sc.nextLine();
                    sc.nextLong();
                    continue;
                }
                soHT++;
            }
            if(id.startsWith("HP")){
                if(soHT==2){
                    sc.nextLine();
                    sc.nextLong();
                    continue;
                }
                soHP++;
            }
            ds.add(new GiaoVien(id,sc.nextLine(),sc.nextLong()));
        }
        for(GiaoVien tmp : ds){
            System.out.printf("%s %s %d %d %d\n",tmp.id,tmp.name,tmp.heSoLuong,tmp.phuCap,tmp.thuNhap);
        }
    }
}
