package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepKetQuaXetTuyen {
    static int stt = 1;
    private static class PhuHo implements Comparable<PhuHo>{
        private String id,name,birthDay,type;
        private double scoreT,scoreH,priorityScore;
        private int totalScore,tuoi;

        PhuHo(String name, String birthDay, double scoreT, double scoreH) {
            this.id = getId(stt++);
            this.name = name;
            this.birthDay = birthDay;
            this.scoreT = scoreT;
            this.scoreH = scoreH;
            this.tuoi = getTuoi(this.birthDay);
            if(this.scoreT>=8 && this.scoreH>=8) this.priorityScore = 1;
            else if(this.scoreT>=7.5 && this.scoreH>=7.5) this.priorityScore = 0.5;
            else this.priorityScore = 0;
            this.totalScore = (int) Math.round((this.scoreH + this.scoreT)/2 + this.priorityScore);
            if(this.totalScore > 10) this.totalScore = 10;
            if(this.totalScore >8) this.type = "Xuat sac";
            else if(this.totalScore >7) this.type = "Gioi";
            else if(this.totalScore >6) this.type = "Kha";
            else if(this.totalScore >=5) this.type = "Trung binh";
            else this.type = "Truot";
        }  
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "PH"+s;
        }
        static int getTuoi(String birthDay){
            String [] data = birthDay.split("/");
            return 2021 - Integer.parseInt(data[2]);
        }

        @Override
        public int compareTo(PhuHo o) {
            if(this.totalScore<o.totalScore) return 1;
            if(this.totalScore>o.totalScore) return -1;
            return this.id.compareTo(o.id);
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<PhuHo> ds = new ArrayList<>();
        int t = sc.nextInt();
        while(t-->0){
            sc.nextLine();
            ds.add(new PhuHo(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble()));
        }
        Collections.sort(ds);
        for(PhuHo tmp : ds) 
            System.out.printf("%s %s %d %d %s\n",tmp.id,tmp.name,tmp.tuoi,tmp.totalScore,tmp.type);
    }
}
