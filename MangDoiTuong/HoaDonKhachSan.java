package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HoaDonKhachSan {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String id,name;
        private int room,unitPrice;
        private String dayIn,dayOut;
        private int serviceFee,day,pay;

        public KhachHang(String name, int room, String dayIn, String dayOut, int serviceFee) {
            this.id = getId(stt++); 
            this.name = name;
            this.room = room;
            this.unitPrice = getUnitPrice(room);
            this.dayIn = dayIn;
            this.dayOut = dayOut;
            this.day = getDay(dayIn,dayOut);
            this.serviceFee = serviceFee;
            this.pay = this.day*this.unitPrice + this.serviceFee;
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "KH"+s;
        }
        static int getUnitPrice(int n){
            int k = (int) n /100;
            if(k==1) return 25;
            if(k==2) return 34;
            if(k==3) return 50;
            return 80;
        }
        static int getDay(String dayIn,String dayOut){
            String []dataIn = dayIn.split("/");
            Date in = Date.valueOf(dataIn[2]+'-'+dataIn[1]+'-'+dataIn[0]);
            String []dataOut = dayOut.split("/");
            Date out = Date.valueOf(dataOut[2]+'-'+dataOut[1]+'-'+dataOut[0]);
            return (int) ((out.getTime() - in.getTime())/(24 * 3600 * 1000)+1);
        }

        @Override
        public String toString(){
            return this.id+' '+this.name+' '+String.valueOf(this.room)
                +' '+String.valueOf(this.day)+' '+String.valueOf(this.pay);
            
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
            ds.add(new KhachHang(sc.nextLine(),sc.nextInt(),sc.next(),sc.next(),sc.nextInt()));           
        }
        Collections.sort(ds);
        for(KhachHang tmp : ds){
            System.out.println(tmp);
        }
    }
}
