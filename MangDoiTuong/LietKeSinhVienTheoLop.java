package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeSinhVienTheoLop {
    private static class SinhVien{
        private String id,name,clas,email;

        public SinhVien(String id, String name, String clas, String email) {
            this.id = id;
            this.name = name;
            this.clas = clas;
            this.email = email;
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
        int q = sc.nextInt();
        while(q-->0){
            String clas = sc.next();
            System.out.printf("DANH SACH SINH VIEN LOP %s:\n",clas);
            for(SinhVien tmp : ds)
                if(tmp.clas.contentEquals(clas))
                    System.out.println(tmp);
        }
    }
}
