package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XepHangVanDongVien_1 {
    static int stt = 1;
    private static class VanDongVien implements Comparable<VanDongVien>{
        private String id,name,birthDay,timeStart,timeEnd;
        private long thanhTich,uuTien,result;
        private int tuoi,xepHang;
        VanDongVien(Scanner sc){
            this.id = getId(stt++);
            this.name = sc.nextLine();
            this.birthDay = sc.next();
            this.timeStart = sc.next();
            this.timeEnd = sc.next();
            this.tuoi = getTuoi(this.birthDay);
            this.thanhTich = getThanhTich(this.timeStart,this.timeEnd);
            if(this.tuoi>32) this.uuTien = 3;
            else if(this.tuoi>=25) this.uuTien = 2;
            else if(this.tuoi>=18) this.uuTien = 1;
            else this.uuTien = 0;
            this.result = this.thanhTich - this.uuTien;
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "VDV"+s;
        }
        static int getTuoi(String birthDay) {
            String [] data = birthDay.split("/");
            return 2021 - Integer.parseInt(data[2]);
        }
        static long getThanhTich(String timeStart,String timeEnd){
            String [] data1 = timeStart.split(":");
            long start = Long.parseLong(data1[0])*3600+Long.parseLong(data1[1])*60+Long.parseLong(data1[2]);
            String [] data2 = timeEnd.split(":");
            long end = Long.parseLong(data2[0])*3600+Long.parseLong(data2[1])*60+Long.parseLong(data2[2]);
            return end - start;
        }
        static String format(long secs){
            return String.format("%02d:%02d:%02d", secs/3600,(secs%3600)/60,secs%60);
        }
        
        @Override
        public int compareTo(VanDongVien o) {
            if(this.result>o.result) return 1;
            return -1;
        }
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+format(this.thanhTich)+' '+
                format(this.uuTien)+' '+format(this.result)+' '+String.valueOf(this.xepHang);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<VanDongVien> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new VanDongVien(sc));
        }
        ArrayList<VanDongVien> tmp = (ArrayList<VanDongVien>) ds.clone();
        Collections.sort(tmp);
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(tmp.get(0).id, 1);
        for(int i = 1;i<tmp.size();i++){
            if(tmp.get(i).result==tmp.get(i-1).result)
                map.put(tmp.get(i).id, map.get(tmp.get(i-1).id));
            else
                map.put(tmp.get(i).id, i+1);
        }
        for(VanDongVien i: ds){
            i.xepHang = (int) map.get(i.id);
            System.out.println(i);
        } 
    }
}
