package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhGiaBan_2 {
    static int stt = 1;
    private static class MatHang implements Comparable<MatHang>{
        private String id,name,unit;
        private int unitPrice,sl,fee,intoMoney;
        private double price;
        MatHang(Scanner sc){
            this.id = getId(stt++);
            this.name = sc.next();
            this.unit = sc.next();
            this.unitPrice = sc.nextInt();
            this.sl = sc.nextInt();
            this.fee = Math.round(this.unitPrice*this.sl*5/100);
            this.intoMoney = this.unitPrice*this.sl + this.fee;
            this.price = Math.ceil((double)this.intoMoney*1.02/this.sl/100)*100;
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "MH" + s;
        }

        @Override
        public int compareTo(MatHang o) {
            if(this.price<o.price) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<MatHang> ds = new ArrayList<>();
        while(t-->0){      
            ds.add(new MatHang(sc));
        }
        Collections.sort(ds);
        for(MatHang tmp : ds)
            System.out.printf("%s %s %s %d %d %.0f\n",tmp.id,tmp.name,tmp.unit,tmp.fee,tmp.intoMoney,tmp.price);
        
    }
}
