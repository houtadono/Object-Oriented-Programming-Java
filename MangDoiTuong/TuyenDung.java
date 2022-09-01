package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TuyenDung {
    static int stt = 1;
    private static class ThiSinh implements Comparable<ThiSinh> {
        private String id,name,type;
        private double score1,score2,totalscore;

        ThiSinh(String name, double score1, double score2) {
            this.id = getId(stt++);
            this.name = name;
            this.score1 = standardScore(score1);
            this.score2 = standardScore(score2);
            this.totalscore = (this.score1+this.score2)/2;
            if(this.totalscore < 5) this.type = "TRUOT";
            else if(this.totalscore < 8) this.type = "CAN NHAC";
            else if(this.totalscore <= 9.5) this.type = "DAT";
            else  this.type = "XUAT SAC";
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "TS"+s;
        }
        static double standardScore(double n){
            if(n<=10) return n;
            else return n/10;
        }
        
        @Override
        public int compareTo(ThiSinh o) {
            if(this.totalscore<o.totalscore) return 1;
            return -1;
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<ThiSinh> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new ThiSinh(sc.nextLine(),sc.nextDouble(),sc.nextDouble()));
        }
        Collections.sort(ds);
        for(ThiSinh tmp : ds){
            System.out.printf("%s %s %.2f %s\n",tmp.id,tmp.name,tmp.totalscore,tmp.type);
        }
    }
}
