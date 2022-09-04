package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DiemDanh_2 {
    private static class SinhVien{
        private String maSV,name,lop,ghiChu;
        private int diemCC;
        public SinhVien(String maSV, String name, String lop) {
            this.maSV = maSV;
            this.name = name;
            this.lop = lop;
            this.ghiChu = "";
        }
        
    }
    
    private static int getDiemCC(String s) {
        int res = 10;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='m') res--;
            if(s.charAt(i)=='v') res-=2;
            if(res<=0) return 0;
        }
        return res;
    }
    
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
            for(SinhVien tmp : ds){
                if(tmp.maSV.contains(maSV)){
                    tmp.diemCC = getDiemCC(diemDanh);
                    if(tmp.diemCC==0) tmp.ghiChu="KDDK";
                    break;
                }
            }
        }
        String lop = sc.next();
        for(SinhVien tmp : ds)
            if(tmp.lop.contains(lop))
                System.out.printf("%s %s %s %d %s\n",tmp.maSV,tmp.name,tmp.lop,tmp.diemCC,tmp.ghiChu);   
    }
}
