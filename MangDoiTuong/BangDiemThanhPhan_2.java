package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangDiemThanhPhan_2 {
    private static class SinhVien implements Comparable<SinhVien>{
        private String id,name,clas;
        private double score1,score2,score3;

        public SinhVien(String id, String name, String clas, double score1, double score2, double score3) {
            this.id = id;
            this.name = name;
            this.clas = clas;
            this.score1 = score1;
            this.score2 = score2;
            this.score3 = score3;
        }

        @Override
        public int compareTo(SinhVien o) {
            return this.name.compareTo(o.name);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<SinhVien> ds = new ArrayList<>();
        while(t-->0){      
            sc.nextLine();
            ds.add(new SinhVien(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble()));
        }
        Collections.sort(ds);
        int i = 1;
        for(SinhVien tmp : ds){
            System.out.printf("%d %s %s %s %.1f %.1f %.1f\n",i,tmp.id,tmp.name,tmp.clas,tmp.score1,tmp.score2,tmp.score3);
            i++;
        }
    }
}
