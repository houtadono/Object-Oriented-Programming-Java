package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepBangTinhCong {
    static int stt=1;
    private static class NhanVien implements Comparable<NhanVien>{
        private String id,name,chucVu;
        private long salaryDay,day,pc,bonus,salaryMonth,salary;

        public NhanVien(Scanner sc) {
            sc.nextLine();
            this.id = getId(stt++);
            this.name = sc.nextLine();
            this.salaryDay = sc.nextLong();
            this.day = sc.nextLong();
            this.chucVu = sc.next();
            this.salaryMonth = this.day*this.salaryDay;
            
            this.bonus = 0;
            if(this.day>=25) this.bonus = this.salaryMonth / 5;
            else if(this.day>=22) this.bonus = this.salaryMonth / 10;
            
            if(this.chucVu.contentEquals("GD")) this.pc = 250000;
            else if(this.chucVu.contains("PGD")) this.pc = 200000;
            else if(this.chucVu.contains("TP")) this.pc = 180000;
            else this.pc = 150000;
            
            this.salary = this.salaryMonth + this.bonus+ this.pc;
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "NV"+s;
        }

        @Override
        public int compareTo(NhanVien o) {
            if(this.salary<o.salary) return 1;
            return -1;
        }
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<NhanVien> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new NhanVien(sc));
        }
        Collections.sort(ds);
        for(NhanVien tmp : ds)
            System.out.printf("%s %s %d %d %d %d\n",tmp.id,tmp.name,tmp.salaryMonth,tmp.bonus,tmp.pc,tmp.salary);
    }
}
