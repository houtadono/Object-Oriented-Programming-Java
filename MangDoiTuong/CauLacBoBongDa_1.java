package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class CauLacBoBongDa_1 {
    private static class CLB {
        private String idCLB,name;
        private int giaVe;
        
        public CLB(String idCLB, String name, int giaVe) {
            this.idCLB = idCLB;
            this.name = name;
            this.giaVe = giaVe;
        }
    }
    private static class TranDau{
        private String id;
        private CLB clb ;
        private long soVe,doanhThu;

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
        
    }
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
        for(TranDau tmp : dsTD)
            System.out.printf("%s %s %d\n",tmp.id,tmp.clb.name,tmp.doanhThu);   
    }
}
