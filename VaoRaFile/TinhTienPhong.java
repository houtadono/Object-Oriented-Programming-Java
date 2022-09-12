package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class TinhTienPhong {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String maKH,tenKH;
        private int room,donGia;
        private String dayIn,dayOut;
        private long serviceFee,day,pay;

        public KhachHang(Scanner sc) {
            this.maKH = layMaKH(stt++); 
            sc.nextLine();
            this.tenKH = chuanHoaTen(sc.nextLine());
            this.room = sc.nextInt();
            this.donGia = layDonGia(room);
            this.dayIn = chuanHoaNgay(sc.next());
            this.dayOut = chuanHoaNgay(sc.next());
            this.day = getDay(dayIn,dayOut);
            this.serviceFee = sc.nextLong();
            this.pay = this.day*this.donGia+this.serviceFee;
        }
        
        static String layMaKH(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "KH"+s;
        }
        static int layDonGia(int n){
            int k = (int) n /100;
            if(k==1) return 25;
            if(k==2) return 34;
            if(k==3) return 50;
            return 80;
        }
        static String chuanHoaTen(String s){
            s = s.trim().toLowerCase();
            String res = "" + Character.toUpperCase(s.charAt(0));
            for(int i=1; i< s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
                    else res += s.charAt(i);
                }
            }
            return res;
        }
        static String chuanHoaNgay(String date){
            String []data = date.split("/");
            if(data[0].length() == 1) data[0] = '0'+data[0];
            if(data[1].length() == 1) data[1] = '0'+data[1];
            return data[0]+'/'+data[1]+'/'+data[2];
        }
        static long getDay(String dayIn,String dayOut){
            try {
                DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                Date dateIn = simpleDateFormat.parse(dayIn);
                Date dateOut = simpleDateFormat.parse(dayOut);
                return (dateOut.getTime() - dateIn.getTime()) /(24 * 60 * 60 * 1000) + 1;
            } catch (ParseException ex) {
                Logger.getLogger(TinhTienPhong.class.getName()).log(Level.SEVERE, null, ex);
            }
            return 0;
        }

        @Override
        public String toString(){
            return this.maKH+' '+this.tenKH+' '
                    +String.format("%d %d %d",this.room,this.day,this.pay);
        }
        @Override
        public int compareTo(KhachHang o) {
            if(this.pay<o.pay) return 1;
            if(this.pay>o.pay) return -1;
            return 0;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("KHACHHANG.in"));
        int t = sc.nextInt();
        ArrayList<KhachHang> dsKH = new ArrayList<>();
        while(t-->0) dsKH.add(new KhachHang(sc));
        Collections.sort(dsKH);
        for(KhachHang tmp : dsKH)
            System.out.println(tmp);
    }
}
