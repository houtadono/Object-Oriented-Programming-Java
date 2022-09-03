package MangDoiTuong;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Houta
 */
public class BangDiemHocSinh {
    static int stt = 1;
    private static class HocSinh implements Comparable<HocSinh>{
        private String id,name,type;
        private double score[] = new double[10], totalScore;
        
        HocSinh(Scanner sc){
            this.id = getId(stt++);
            this.name = sc.nextLine();
            for(int i =0; i<10; i++) this.score[i] = sc.nextDouble();
            this.totalScore = 2*(this.score[0]+this.score[1]);
            for(int i =2; i<10; i++) this.totalScore += this.score[i];
            this.totalScore /= 12;
            if(this.totalScore >= 9) this.type = "XUAT SAC";
            else if(this.totalScore >= 8) this.type = "GIOI";
            else if(this.totalScore >= 7) this.type = "KHA";
            else if(this.totalScore >= 5) this.type = "TB";
            else this.type = "YEU";
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "HS"+s;
        }

        @Override
        public int compareTo(HocSinh o) {
            if(this.totalScore<o.totalScore) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<HocSinh> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new HocSinh(sc));           
        }
        Collections.sort(ds);
        for(HocSinh tmp : ds){
            System.out.printf("%s %s %.1f %s\n",tmp.id,tmp.name,tmp.totalScore,tmp.type);
        }
    }
}
