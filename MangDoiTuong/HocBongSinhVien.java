package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HocBongSinhVien {
    private static class SinhVien implements Comparable<SinhVien>{
        private String name,hocBong;
        private double scoreTBC;
        private int scoreRL;

        public SinhVien(String name, double scoreTBC, int scoreRL) {
            this.name = name;
            this.scoreTBC = scoreTBC;
            this.scoreRL = scoreRL;
            if(this.scoreTBC>=3.6&&this.scoreRL>=90) this.hocBong = "XUATSAC";
            else if(this.scoreTBC>=3.2&&this.scoreRL>=80) this.hocBong = "GIOI";
            else if(this.scoreTBC>=2.5&&this.scoreRL>=70) this.hocBong = "KHA";
            else this.hocBong = "KHONG";
        }

        @Override
        public int compareTo(SinhVien o) {
            if(this.hocBong.contains("KHONG")&&!o.hocBong.contains("KHONG")) return 1;
            if(!this.hocBong.contains("KHONG")&&o.hocBong.contains("KHONG")) return -1;
            if(this.scoreTBC<o.scoreTBC) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<SinhVien> ds = new ArrayList<>();
        int t = sc.nextInt();
        int sl = sc.nextInt();
        while(t-->0){
            sc.nextLine();
            ds.add(new SinhVien(sc.nextLine(),sc.nextDouble(),sc.nextInt()));
        }
        ArrayList<SinhVien> sx = (ArrayList<SinhVien>) ds.clone();
        Collections.sort(sx);
        double mocDiem =  sx.get(sl-1).scoreTBC;
        for(SinhVien tmp : ds){
            if(tmp.scoreTBC<mocDiem) tmp.hocBong = "KHONG";
            System.out.printf("%s: %s\n",tmp.name,tmp.hocBong);
        }
            
    }
}
