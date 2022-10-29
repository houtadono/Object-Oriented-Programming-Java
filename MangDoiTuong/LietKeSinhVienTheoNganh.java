package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeSinhVienTheoNganh {
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
                if(tmp.getIndustry().equalsIgnoreCase(industry))
                    System.out.println(tmp);
        }
    }
}

class SinhVien{
    private String id,name,clas,email;

    public SinhVien(String id, String name, String clas, String email) {
        this.id = id;
        this.name = name;
        this.clas = clas;
        this.email = email;
    }    
    public String getIndustry(){
        String s = "";
        if(this.id.contains("DCKT"))  s = "Ke toan";
        if(this.id.contains("DCVT"))  s = "Vien thong";
        if(this.id.contains("DCDT"))  s = "Dien tu";
        if(this.id.contains("DCCN") && this.clas.charAt(0) != 'E')  s = "Cong nghe thong tin";
        if(this.id.contains("DCAT") && this.clas.charAt(0) != 'E')  s = "An toan thong tin";
        return s;
    }

    @Override
    public String toString(){
        return this.id+' '+this.name+' '+this.clas+' '+this.email;
    }
}