package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TimThuKhoaCuaKyThi {
    static int dem = 1;
    private static class ThiSinh{
        private int stt;
        private String name,birthDay;
        private double score1,score2,score3,totalScore;

        ThiSinh(String name, String birthDay, double score1, double score2, double score3) {
            this.stt = dem++;
            this.name = name;
            this.birthDay = birthDay;
            this.score1 = score1;
            this.score2 = score2;
            this.score3 = score3;
            this.totalScore = score1+score2+score3;
        }
        double getTotalScore(){
            return this.totalScore;
        }
        
        @Override
        public String toString(){
            return String.valueOf(this.stt)+' '+this.name+' '+this.birthDay+' '+this.totalScore;
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<ThiSinh> ds = new ArrayList<>();
        double max = 0;
        while(t-->0){
            sc.nextLine();
            ThiSinh ts = new ThiSinh(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble());
            ds.add(ts);
            double tmp = ts.getTotalScore();
            if(max<tmp) max = tmp;
        }
        for(ThiSinh tmp : ds){
            if(tmp.getTotalScore() == max ) System.out.println(tmp);
        }
    }
}
