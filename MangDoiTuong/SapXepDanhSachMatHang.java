package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepDanhSachMatHang {
    static int stt = 1;
    private static class MatHang implements Comparable<MatHang>{
        private int id;
        private String name,type;
        private double purchasePrice,salePrice;
        public double profit;

        MatHang(String name, String type, double purchasePrice, double salePrice) {
            this.id = stt++;
            this.name = name;
            this.type = type;
            this.purchasePrice = purchasePrice;
            this.salePrice = salePrice;
            this.profit = (double) Math.round((this.salePrice - this.purchasePrice)*100)/100;
        }
        
        @Override
        public String toString(){
            return String.valueOf(this.id)+' '+this.name+' '+this.type+' ';
        }

        @Override
        public int compareTo(MatHang o) {
            if(this.profit<o.profit) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<MatHang> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new MatHang(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble()));           
        }
        Collections.sort(ds);
        for(MatHang tmp : ds){
            System.out.print(tmp);
            System.out.printf("%.2f\n",tmp.profit);
        }
    }
}
