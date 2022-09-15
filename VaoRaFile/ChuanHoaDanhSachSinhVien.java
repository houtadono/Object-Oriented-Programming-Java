package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class ChuanHoaDanhSachSinhVien {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("SINHVIEN.in"));
        int t = sc.nextInt();
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        while(t-->0) dsSV.add(new SinhVien(sc));
        for(SinhVien tmp : dsSV)
            System.out.println(tmp);
    }
    static int stt = 1;
    private static class SinhVien{
        private String maSV,tenSV,clas;
        private Date birthday;
        private double gpa;

        public SinhVien(Scanner sc){
            this.maSV = "B20DCCN"+String.format("%03d", stt++);
            sc.nextLine();
            this.tenSV = chuanHoaTen(sc.nextLine());
            this.clas = sc.next();
            try {
                this.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
            } catch (ParseException ex) {
                Logger.getLogger(ChuanHoaDanhSachSinhVien.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.gpa = sc.nextDouble();
        }
        private static String chuanHoaTen(String s){
            s = s.trim().toLowerCase();
            String res = "" + Character.toUpperCase(s.charAt(0));
            for(int i=1; i< s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
                    else res += s.charAt(i);
                }
            }
            return res;
        }
        
        @Override
        public String toString(){
            return this.maSV+' '+this.tenSV+' '+this.clas+' '+
                new SimpleDateFormat("dd/MM/yyyy").format(this.birthday)+' '+String.format("%.2f", this.gpa);
        }
    }
}
