package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhGiaBan_1 {
    static int stt = 1;
    private static class MatHang{
        private String id,name,unit;
        private double unitPrice,sl,fee,intoMoney,price;
        MatHang(Scanner sc){
            this.id = getId(stt++);
            this.name = sc.next();
            this.unit = sc.next();
            this.unitPrice = sc.nextDouble();
            this.sl = sc.nextDouble();
            this.fee = Math.round(this.unitPrice*this.sl*5/100);
            this.intoMoney = Math.round(this.unitPrice*this.sl + this.fee);
            this.price = Math.round(this.intoMoney*102/100);
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "MH" + s;
        }
        
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<MatHang> ds = new ArrayList<>();
        while(t-->0){      
            ds.add(new MatHang(sc));
        }
        for(MatHang tmp : ds)
            System.out.printf("%s %s %s %.0f %.0f %.0f\n",tmp.id,tmp.name,tmp.unit,tmp.fee,tmp.intoMoney,tmp.price);
        
    }
}
