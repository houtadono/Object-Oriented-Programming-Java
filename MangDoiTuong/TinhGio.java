package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhGio {
    private static class GameThu implements Comparable<GameThu>{
        private String id,name,timein,timeout;
        private int hour,min;
        public GameThu(String id, String name, String timein, String timeout) {
            this.id = id;
            this.name = name;
            this.timein = timein;
            this.timeout = timeout;
            this.hour = Integer.parseInt(timeout.substring(0,2)) - Integer.parseInt(timein.substring(0,2));
            this.min = Integer.parseInt(timeout.substring(3)) - Integer.parseInt(timein.substring(3));
            if(this.min<0){
                this.min += 60;
                this.hour--;
            }
        }
        
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+ String.valueOf(this.hour) + " gio "+
                    String.valueOf(this.min)+" phut";
        }
        
        @Override
        public int compareTo(GameThu o) {
            if(this.hour<o.hour) return 1;
            if(this.hour>o.hour) return -1;
            if(this.min<o.min) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        ArrayList<GameThu> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new GameThu(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()));           
        }
        Collections.sort(ds);
        for(GameThu tmp : ds){
            System.out.println(tmp);
        }
    }
}
