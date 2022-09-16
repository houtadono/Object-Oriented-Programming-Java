package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LichGiangDayTheoMonHoc {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = sc.nextInt();
        ArrayList<MonHoc> dsMH = new ArrayList<>();
        while(t-->0) dsMH.add(new MonHoc(sc));
        
        sc = new Scanner(new File("LICHGD.in"));
        t = sc.nextInt();
        ArrayList<LopHocPhan> dsLHP = new ArrayList<>();
        while(t-->0) 
            dsLHP.add(new LopHocPhan(sc,dsMH));
        Collections.sort(dsLHP);
        
        String maMH = sc.next();
        for(MonHoc tmp : dsMH)
            if(tmp.maMH.equals(maMH)){
                System.out.printf("LICH GIANG DAY MON %s:\n",tmp.tenMH);
                break;
            }
        for(LopHocPhan tmp : dsLHP)
            if(tmp.maMH.equals(maMH))
                System.out.println(tmp);
    }
}

class MonHoc{
    public String maMH,tenMH;
    public int soTinChi;
    
    public MonHoc() {
    }
    public MonHoc(Scanner sc) {
        this.maMH = sc.next();
        sc.nextLine();
        this.tenMH = sc.nextLine();
        this.soTinChi = sc.nextInt();
    }
}

class LopHocPhan extends MonHoc implements Comparable<LopHocPhan>{
    public String maLHP,tenGV,phongHoc;
    public int thu,kip;
    public static int stt = 1;
    
    public LopHocPhan(Scanner sc,ArrayList<MonHoc> dsMH) {
        this.maLHP = "HP" + String.format("%03d",stt++);
        String maMon = sc.next();
        for(MonHoc tmp : dsMH)
            if(maMon.contentEquals(tmp.maMH)){
                this.maMH = tmp.maMH;
                this.tenMH = tmp.tenMH;
                this.soTinChi = tmp.soTinChi;
                break;
            }
        this.thu = sc.nextInt();
        this.kip = sc.nextInt();
        sc.nextLine();
        this.tenGV = sc.nextLine();
        this.phongHoc = sc.next();
    }

    @Override
    public String toString(){
        return String.format("%s %d %d %s %s",this.maLHP,this.thu,this.kip,this.tenGV,this.phongHoc);
    }
    @Override
    public int compareTo(LopHocPhan o) {
        if(this.thu>o.thu) return 1;
        if(this.thu<o.thu) return -1;
        if(this.kip>o.kip) return 1;
        if(this.kip<o.kip) return -1;
        return this.tenGV.compareTo(o.tenGV);
    }
}