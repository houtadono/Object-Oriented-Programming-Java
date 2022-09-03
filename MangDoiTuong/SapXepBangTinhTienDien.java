package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepBangTinhTienDien {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String id,typeSD;
        private long chiSoCu,chiSoMoi,heSo,intoMoney,phuTroi,pay;
        
        KhachHang(Scanner sc){
            this.id = getId(stt++);
            this.typeSD = sc.next();
            this.chiSoCu = sc.nextLong();
            this.chiSoMoi = sc.nextLong();
            
            if(this.typeSD.contains("KD")) this.heSo = 3;
            else if(this.typeSD.contains("NN")) this.heSo = 5;
            else if(this.typeSD.contains("TT")) this.heSo = 4;
            else this.heSo = 2;
            this.intoMoney = (this.chiSoMoi-this.chiSoCu)*this.heSo*550;
            
            if(this.chiSoMoi-this.chiSoCu>100) this.phuTroi = this.intoMoney;
            else if(this.chiSoMoi-this.chiSoCu>=50) this.phuTroi = Math.round(this.intoMoney/100.0*35);
            else this.phuTroi = 0;
            this.pay = this.phuTroi+this.intoMoney;
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "KH"+s;
        }

        @Override
        public int compareTo(KhachHang o) {
            if(this.pay<o.pay) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<KhachHang> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new KhachHang(sc));
        }
        Collections.sort(ds);
        for(KhachHang tmp : ds)
            System.out.printf("%s %d %d %d %d\n",tmp.id,tmp.heSo,tmp.intoMoney,tmp.phuTroi,tmp.pay);
    }
}
