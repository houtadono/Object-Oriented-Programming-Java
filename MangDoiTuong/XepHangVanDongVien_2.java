package MangDoiTuong;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class XepHangVanDongVien_2 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<VanDongVien> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new VanDongVien(sc));
        }
        Collections.sort(ds);
        ds.get(0).xepHang = 1;
        System.out.println(ds.get(0));
        for(int i = 1;i<ds.size();i++){
            if(ds.get(i).getResult() == ds.get(i-1).getResult()) ds.get(i).xepHang = ds.get(i-1).xepHang;
            else ds.get(i).xepHang = i+1;
            System.out.println(ds.get(i));
        } 
    }
}

class VanDongVien implements Comparable<VanDongVien>{
    private String id,name,timeStart,timeEnd;
    private Date birthDay;
    private long thanhTich,uuTien,result;
    public int tuoi,xepHang;
    static int stt = 1;
    
    VanDongVien(Scanner sc){
        this.id = String.format("VDV%02d", stt++);
        this.name = sc.nextLine();
        try {
            this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
        } catch (ParseException ex) {
            Logger.getLogger(VanDongVien.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    static int getTuoi(Date birthDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(birthDay);
        return 2021 - cal.get(Calendar.YEAR);
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

    public long getResult(){
        return this.result;
    }
    
    @Override
    public int compareTo(VanDongVien o) {
        if(this.result==o.result) return this.id.compareTo(o.id);
        if(this.result>o.result) return 1;
        return -1;
    }
    @Override
    public String toString(){
        return this.id+' '+this.name+' '+format(this.thanhTich)+' '+
            format(this.uuTien)+' '+format(this.result)+' '+String.valueOf(this.xepHang);
        }
}

