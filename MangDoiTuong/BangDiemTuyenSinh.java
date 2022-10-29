package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangDiemTuyenSinh {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<ThiSinh> ds = new ArrayList<>();
        int t = sc.nextInt();
        while(t-->0){
            sc.nextLine();
            ds.add(new ThiSinh(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble(),sc.nextDouble()));
        }
        for(ThiSinh tmp : ds)
            System.out.println(tmp);
    }
}

class ThiSinh{
    private String id,name;
    private double scoreT,scoreL,scoreH,priorityScore,totalScore;
    private String tt;

    ThiSinh(String id, String name, double scoreT, double scoreL, double scoreH) {
        this.id = id;
        this.name = name;
        this.scoreT = scoreT;
        this.scoreL = scoreL;
        this.scoreH = scoreH;
        this.priorityScore = 0;
        if(id.startsWith("KV1")) this.priorityScore = 0.5;
        if(id.startsWith("KV2")) this.priorityScore = 1.0;
        if(id.startsWith("KV3")) this.priorityScore = 2.5;
        this.totalScore = scoreT*2+scoreL+scoreH;
        if(this.totalScore + this.priorityScore >=24) this.tt = "TRUNG TUYEN";
        else this.tt = "TRUOT";
    }

    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append(this.id).append(' ').append(this.name).append(' ');
        s.append( ((int)this.priorityScore == this.priorityScore )? String.format("%.0f ",this.priorityScore) : String.format("%.1f ",this.priorityScore));
        s.append( ((int)this.totalScore == this.totalScore )? String.format("%.0f ",this.totalScore) : String.format("%.1f ",this.totalScore));
        s.append(this.tt);
        return s.toString();
    }
}