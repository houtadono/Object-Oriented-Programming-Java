package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhTien {
    static int stt = 1;
    private static class MatHang implements Comparable<MatHang>{
        private String id,name;
        private long amount,unitPrice,discount,pay;

        public MatHang(String id, String name, long amount, long unitPrice, long discount) {
            this.id = id;
            this.name = name;
            this.amount = amount;
            this.unitPrice = unitPrice;
            this.discount = discount;
            this.pay = this.unitPrice*this.amount - this.discount;
        }
        
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+ String.valueOf(this.amount)+' '+ String.valueOf(this.unitPrice)
                    +' '+ String.valueOf(this.discount)+' '+ String.valueOf(this.pay);
        }

        @Override
        public int compareTo(MatHang o) {
            if(this.pay<o.pay) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<MatHang> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new MatHang(sc.nextLine(),sc.nextLine(),sc.nextLong(),sc.nextLong(),sc.nextLong()));           
        }
        Collections.sort(ds);
        for(MatHang tmp : ds){
            System.out.println(tmp);
        }
    }
}
