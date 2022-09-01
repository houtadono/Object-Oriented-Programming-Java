package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TuyenGiaoVien {
    static int stt = 1;
    private static class GiaoVien implements Comparable<GiaoVien> {
        private String id,name,idXet,type;
        private double scoreTinHoc,scoreChuyenMon,totalscore,scorePlus;
        private String subject;

        GiaoVien(String name,String idXet, double scoreTinHoc, double scoreChuyenMon) {
            this.id = getId(stt++);
            this.name = name;
            this.idXet = idXet;
            this.subject = getSubject(this.idXet);
            this.scorePlus = getScorePlus(this.idXet);
            this.scoreTinHoc= scoreTinHoc;
            this.scoreChuyenMon = scoreChuyenMon;
            this.totalscore = this.scoreTinHoc*2 + this.scoreChuyenMon + this.scorePlus;
            if(this.totalscore >= 18) this.type = "TRUNG TUYEN";
            else this.type = "LOAI";            
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "GV"+s;
        }
        static String getSubject(String s){
            if(s.charAt(0)=='A') return "TOAN";
            if(s.charAt(0)=='B') return "LY";
            return "HOA";
        }
        static double getScorePlus(String s){
            if(s.charAt(1)=='1') return 2.0;
            if(s.charAt(1)=='2') return 1.5;
            if(s.charAt(1)=='3') return 1.0;
            return 0;
        }
        
        @Override
        public int compareTo(GiaoVien o) {
            if(this.totalscore<o.totalscore) return 1;
            if(this.totalscore>o.totalscore)return -1;
            return this.id.compareTo(o.id);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<GiaoVien> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new GiaoVien(sc.nextLine(),sc.next(),sc.nextDouble(),sc.nextDouble()));
        }
        Collections.sort(ds);
        for(GiaoVien tmp : ds){
            System.out.printf("%s %s %s %.1f %s\n",tmp.id,tmp.name,tmp.subject,tmp.totalscore,tmp.type);
        }
    }
}
