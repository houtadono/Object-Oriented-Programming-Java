package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangLuongTheoPhongBan {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<PhongBan> dsPB = new ArrayList<>();
        while(t-->0){
            dsPB.add(new PhongBan(sc.next(),sc.nextLine()));
        }
        t = sc.nextInt();
        ArrayList<NhanVien> dsNV = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            dsNV.add(new NhanVien(sc.nextLine(),sc.nextLine(),sc.nextLong(),sc.nextLong(),dsPB));
        }
        String pb = sc.next();
        for(PhongBan tmp : dsPB)
            if(tmp.getId().contains(pb)){
                pb = tmp.getName();
                System.out.printf("Bang luong phong %s:\n",pb);
                break;
            }
        for(NhanVien tmp : dsNV)
            if(tmp.getPhongBan().contains(pb))
                System.out.println(tmp);   
    }
}

class PhongBan{
    private String id,name;

    public PhongBan(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

class NhanVien{
    private String id,name,phongBan;
    private long luongCoBan,soNgayCong,heSo,luongThang;

    public NhanVien(String id, String name, long luongCoBan, long soNgayCong, ArrayList<PhongBan> dsPB) {
        this.id = id;
        this.name = name;
        this.luongCoBan = luongCoBan*1000;
        this.soNgayCong = soNgayCong;
        for(PhongBan tmp : dsPB)
            if(this.id.endsWith(tmp.getId())){
                this.phongBan = tmp.getName();
                break;
            }
        this.heSo = getHeSo(this.id.charAt(0),Integer.parseInt(this.id.substring(1,3)));
        this.luongThang = this.heSo*this.soNgayCong*this.luongCoBan;
    }

    public String getPhongBan() {
        return phongBan;
    }
    
    static long getHeSo(char c,int soNam){
        if(soNam<=3){
            if(c=='D') return 8;
            if(c=='C') return 9;
            return 10;
        }else if(soNam<=8){
            if(c=='D') return 9;
            if(c=='C') return 10;
            if(c=='B') return 11;
            return 12;
        }else if(soNam<=15){
            if(c=='D') return 11;
            if(c=='C') return 12;
            if(c=='B') return 13;
            return 14;
        }
        if(c=='D') return 13;
        if(c=='C') return 14;
        if(c=='B') return 16;
        return 20;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + luongThang;
    }
    
}
