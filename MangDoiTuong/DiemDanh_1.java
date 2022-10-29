package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DiemDanh_1 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        ArrayList<SinhVien> ds = new ArrayList<>();
        for(int i=0;i<t;i++){
            ds.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        while(t-->0){
            String maSV = sc.next();
            String diemDanh = sc.next();
            SinhVien a = new SinhVien(maSV,"","");
            ds.get( ds.indexOf(a)).setDiemCC(diemDanh);
        }
        for(SinhVien tmp : ds)
            System.out.println(tmp);   
    }
}

class SinhVien{
    private String maSV,name,lop,ghiChu;
    private int diemCC;
    public SinhVien(String maSV, String name, String lop) {
        this.maSV = maSV;
        this.name = name;
        this.lop = lop;
        this.ghiChu = "";
    }
    
    public void setDiemCC(String s) {
        int res = 10;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='m') res--;
            if(s.charAt(i)=='v') res-=2;
            if(res<=0){
                res = 0;
                this.ghiChu = "KDDK";
                break;
            }
        }
        this.diemCC = res;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != getClass()) return false;
        return this.maSV.equals( ((SinhVien)obj).maSV);
    }
    
    @Override
    public String toString() {
        return maSV+' '+name+' '+lop+' '+diemCC+' '+ghiChu;
    }
}
