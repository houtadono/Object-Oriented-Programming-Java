package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
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
public class ThoiGianOnlineLienTuc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("ONLINE.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<SinhVien> dsSV = new ArrayList<>();
        while(t-->0) dsSV.add(new SinhVien((sc)));
        Collections.sort(dsSV);
        for(SinhVien tmp : dsSV)
            System.out.println(tmp);
    }
}
class SinhVien implements Comparable<SinhVien>{
    private String tenSV;
    Date timeStart,timeEnd;
    private long time;

    public SinhVien(Scanner sc) {
        try {
            this.tenSV = sc.nextLine();
            this.timeStart = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sc.nextLine());
            this.timeEnd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(sc.nextLine());
            this.time = getTime(this.timeStart,this.timeEnd);
        } catch (ParseException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    static long getTime(Date start,Date end){
        return Math.round((end.getTime() - start.getTime())/(1000*60));
    }

    @Override
    public String toString(){
        return String.format("%s %d", this.tenSV,this.time);
    }
    @Override
    public int compareTo(SinhVien o) {
        if(this.time<o.time) return 1;
        if(this.time>o.time) return -1;
        return this.tenSV.compareTo(o.tenSV);
    }
}