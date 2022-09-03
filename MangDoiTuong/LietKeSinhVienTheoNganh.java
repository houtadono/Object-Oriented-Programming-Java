package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeSinhVienTheoNganh {
    private static class SinhVien{
        private String id,name,clas,email,industry;

        public SinhVien(String id, String name, String clas, String email) {
            this.id = id;
            this.name = name;
            this.clas = clas;
            this.email = email;
            this.industry = getIndustry(id);
        }    
        static String getIndustry(String id){
            String s = "";
            if(id.contains("DCKT"))  s = "Ke toan";
            if(id.contains("DCVT"))  s = "Vien thong";
            if(id.contains("DCDT"))  s = "Dien tu";
            if(id.contains("DCCN") && id.charAt(0) != 'E')  s = "Cong nghe thong tin";
            if(id.contains("DCAT") && id.charAt(0) != 'E')  s = "An toan thong tin";
            return s;
        }
        
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+this.clas+' '+this.email;
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> ds = new ArrayList<>();
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){        
            ds.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        int q = sc.nextInt(); sc.nextLine();
        while(q-->0){
            String industry = sc.nextLine();
            System.out.printf("DANH SACH SINH VIEN NGANH %s:\n",industry.toUpperCase());
            for(SinhVien tmp : ds)
                if(tmp.industry.equalsIgnoreCase(industry))
                    System.out.println(tmp);
        }
    }
}
