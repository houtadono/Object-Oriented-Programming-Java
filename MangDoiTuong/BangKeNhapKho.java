package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BangKeNhapKho {
    static int stt = 1;
    private static class LoHang{
        private String id,name;
        private long sl,unitPrice,discount,price;

        public LoHang(String id, String name, long sl, long unitPrice) {
            this.id = id;
            this.name = name;
            this.sl = sl;
            this.unitPrice = unitPrice;
            if(sl>10) this.discount = (long) unitPrice*sl *5/100;
            else if(sl>=8) this.discount = (long) unitPrice*sl *2/100;
            else if(sl>=5) this.discount = (long) unitPrice*sl *1/100;
            else this.discount = 0;
            this.price = unitPrice*sl - this.discount;
        }
    }
    static String getId(String name){
        String [] data = name.split(" ");
        return ""+Character.toUpperCase(data[0].charAt(0)) +Character.toUpperCase(data[1].charAt(0))+'0';
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<LoHang> ds = new ArrayList<>();
        ArrayList<String> listId = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            String name = sc.nextLine();
            String id = getId(name);
            int dem = 1;
            for(String i: listId) if(i.contains(id)) dem++;
            ds.add(new LoHang(id+String.valueOf(dem),name,sc.nextLong(),sc.nextLong()));
            listId.add(id);
        }
        for(LoHang tmp : ds)
            System.out.printf("%s %s %d %d\n",tmp.id,tmp.name,tmp.discount,tmp.price);
    }
}
