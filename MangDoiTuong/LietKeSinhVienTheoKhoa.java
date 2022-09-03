package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeSinhVienTheoKhoa {
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
            String year = sc.next();
            System.out.printf("DANH SACH SINH VIEN KHOA %s:\n",year);
            for(SinhVien tmp : ds)
                if(tmp.id.substring(1,3).contentEquals(year.substring(2)))
                    System.out.println(tmp);
        }
    }
}
