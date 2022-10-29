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
public class SapXepKetQuaXetTuyen {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<PhuHo> ds = new ArrayList<>();
        int t = sc.nextInt();
        while(t-->0){
            sc.nextLine();
            ds.add(new PhuHo(sc.nextLine(),sc.nextLine(),sc.nextDouble(),sc.nextDouble()));
        }
        Collections.sort(ds);
        for(PhuHo tmp : ds) 
            System.out.println(tmp);
    }
}

class PhuHo implements Comparable<PhuHo>{
    private String id,name,type;
    private Date birthDay;
    private double scoreT,scoreH,priorityScore;
    private int totalScore,tuoi;
    private static int stt = 1;
    
    PhuHo(String name, String birthDay, double scoreT, double scoreH) {
        this.id = String.format("PH%02d", stt++);
        this.name = name;
        try {
            this.birthDay = new SimpleDateFormat("dd/MM/yyyy").parse(birthDay);
        } catch (ParseException ex) {
            Logger.getLogger(PhuHo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.scoreT = scoreT;
        this.scoreH = scoreH;
        this.tuoi = getTuoi(this.birthDay);
        if(this.scoreT>=8 && this.scoreH>=8) this.priorityScore = 1;
        else if(this.scoreT>=7.5 && this.scoreH>=7.5) this.priorityScore = 0.5;
        else this.priorityScore = 0;
        this.totalScore = (int) Math.round((this.scoreH + this.scoreT)/2 + this.priorityScore);
        if(this.totalScore > 10) this.totalScore = 10;
        if(this.totalScore >8) this.type = "Xuat sac";
        else if(this.totalScore >7) this.type = "Gioi";
        else if(this.totalScore >6) this.type = "Kha";
        else if(this.totalScore >=5) this.type = "Trung binh";
        else this.type = "Truot";
    } 
    
    @Override
    public String toString(){
        return String.format("%s %s %d %d %s",id,name,tuoi,totalScore,type);
    }
    
    @Override
    public int compareTo(PhuHo o) {
        if(this.totalScore<o.totalScore) return 1;
        if(this.totalScore>o.totalScore) return -1;
        return this.id.compareTo(o.id);
    }
    
    static int getTuoi(Date birthDay){
        Calendar x = Calendar.getInstance();
        x.setTime(birthDay);
        return 2021 - x.get(Calendar.YEAR);
    }
}