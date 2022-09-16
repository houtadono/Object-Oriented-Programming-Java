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
public class SapXepLichThi {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MONTHI.in"));
        int t = sc.nextInt();
        ArrayList<MonThi> dsMT = new ArrayList<>();
        while(t-->0) dsMT.add(new MonThi(sc));
        
        sc = new Scanner(new File("CATHI.in"));
        t = sc.nextInt();
        ArrayList<CaThi> dsCT = new ArrayList<>();
        while(t-->0) dsCT.add(new CaThi(sc));
        
        sc = new Scanner(new File("LICHTHI.in"));
        t = sc.nextInt();
        ArrayList<LichThi> dsLT = new ArrayList<>();
        while(t-->0) dsLT.add(new LichThi(sc,dsMT,dsCT));
        Collections.sort(dsLT);
        for(LichThi tmp : dsLT)
            System.out.println(tmp);
    }
}

class MonThi{
    String maMon,tenMon,hinhThuc;
    
    MonThi(Scanner sc) {
        this.maMon = sc.next();
        sc.nextLine();
        this.tenMon = sc.nextLine();
        this.hinhThuc = sc.nextLine();
    }
}

class CaThi{
    String maCT;
    Date ngayThi,gioThi;
    String phongThi;
    static int stt = 1;
    
    public CaThi(Scanner sc) {
        try {
            this.maCT = "C" + String.format("%03d", stt++);
            this.ngayThi = new SimpleDateFormat("dd/MM/yyyy").parse(sc.next());
            this.gioThi = new SimpleDateFormat("HH:mm").parse(sc.next());
            this.phongThi = sc.next();
        } catch (ParseException ex) {
            Logger.getLogger(CaThi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class LichThi implements Comparable<LichThi>{
    MonThi mt;
    CaThi ct;
    String nhom,soSV;

    public LichThi(Scanner sc,ArrayList<MonThi> dsMT,ArrayList<CaThi> dsCT) {
        String maCT = sc.next();
        for(CaThi tmp : dsCT)
            if(tmp.maCT.equals(maCT)){
                this.ct = tmp;
                break;
            }
        String maMon = sc.next();
        for(MonThi tmp : dsMT)
            if(tmp.maMon.equals(maMon)){
                this.mt = tmp;
                break;
            }
        this.nhom = sc.next();
        this.soSV = sc.next();
    }
    
    @Override
    public String toString(){
        return new SimpleDateFormat("dd/MM/yyyy").format(this.ct.ngayThi) +' '+ 
              new SimpleDateFormat("HH:mm").format(this.ct.gioThi)+' '+ this.ct.phongThi+' '+
              this.mt.tenMon+' '+this.nhom+' '+this.soSV;
    }

    @Override
    public int compareTo(LichThi o) {
        if(this.ct.ngayThi.equals(o.ct.ngayThi)){
            if(this.ct.gioThi.equals(o.ct.gioThi))
                return this.ct.maCT.compareTo(o.ct.maCT);
            else return this.ct.gioThi.compareTo(o.ct.gioThi);
        }
        return this.ct.ngayThi.compareTo(o.ct.ngayThi);
    }
}