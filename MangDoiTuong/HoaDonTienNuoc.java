package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HoaDonTienNuoc {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String id,name;
        private long oldNum,newNum,pay;

        public KhachHang(String name, long oldNum, long newNum) {
            this.id = getId(stt++); 
            this.name = name;
            this.oldNum = oldNum;
            this.newNum = newNum;
            this.pay = getPay(newNum-oldNum);
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "KH"+s;
        }
        static long getPay(long n){
            long res = 0;
            if(n>50){
                res = 50*100;
                if(n>100){
                    res += 50*150;
                    res +=  (n-100)*200;
                    res = Math.round(res*1.05);
                }else{
                    res += (n-50)*150;
                    res = Math.round(res*1.03);
                }
            }else{
                res = n*102;
            }
            return res;
        }
        
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+String.valueOf(this.pay);
            
        }
        @Override
        public int compareTo(KhachHang o) {
            if(this.pay<o.pay) return 1;
            if(this.pay>o.pay) return -1;
            return 0;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<KhachHang> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new KhachHang(sc.nextLine(),sc.nextInt(),sc.nextInt()));           
        }
        Collections.sort(ds);
        for(KhachHang tmp : ds){
            System.out.println(tmp);
        }
    }
}
