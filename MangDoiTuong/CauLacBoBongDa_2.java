package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class CauLacBoBongDa_2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<CLB> dsCLB = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            dsCLB.add(new CLB(sc.nextLine(),sc.nextLine(),sc.nextInt()));
        }
        t = sc.nextInt(); 
        ArrayList<TranDau> dsTD = new ArrayList<>();
        while(t-->0) dsTD.add(new TranDau(sc.next(),sc.nextLong(),dsCLB));
        Collections.sort(dsTD);
        for(TranDau tmp : dsTD)
            System.out.println(tmp);   
    }
}

class CLB {
    protected String idCLB,nameCLB;
    protected int giaVe;

    public CLB(String idCLB, String name, int giaVe) {
        this.idCLB = idCLB;
        this.nameCLB = name;
        this.giaVe = giaVe;
    }
}
class TranDau implements Comparable<TranDau>{
    private String id;
    private long soVe, doanhThu;
    private CLB clb;
    TranDau(String id, long soVe, ArrayList<CLB> dsCLB) {
        this.id = id;
        this.soVe = soVe;
        for(CLB tmp : dsCLB) 
            if(this.id.substring(1,3).contentEquals(tmp.idCLB)){
                this.clb = tmp;
                break;
            }
        this.doanhThu = this.clb.giaVe*this.soVe;
    }

    @Override
    public int compareTo(TranDau o) {
        if(this.doanhThu < o.doanhThu) return 1;
        if(this.doanhThu > o.doanhThu) return -1;
        return this.clb.nameCLB.compareTo(o.clb.nameCLB);
    }

    @Override
    public String toString() {
        return String.format("%s %s %d",id,clb.nameCLB,doanhThu);
    }
}
