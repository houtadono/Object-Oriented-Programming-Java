package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DuaXeDap {
    private static class Cua_ro implements Comparable<Cua_ro>{
        private String id,name,address,arrivalTime;
        private long speed;
        
        public Cua_ro(String name, String address, String arrivalTime) {
            this.name = name;
            this.address = address;
            this.arrivalTime = arrivalTime;
            this.id = getId(name,address);
            this.speed = getSpeed(arrivalTime);
        }
        
        static String getId(String name,String address){
            String [] data1 = address.split(" ");
            String [] data2 = name.split(" ");
            String s = "";
            for(String i : data1) s+= i.charAt(0);
            for(String i : data2) s+= i.charAt(0);
            return s;
        }
        static long getSpeed(String time){
            double h = Integer.parseInt(""+time.charAt(0))-6 + (double) Integer.parseInt(time.substring(2))/60;
            return Math.round((double)120/h);
        }
        
        @Override
        public int compareTo(Cua_ro o) {
            return this.arrivalTime.compareTo(o.arrivalTime);
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); sc.nextLine();
        ArrayList<Cua_ro> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new Cua_ro(sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(ds);
        for(Cua_ro tmp : ds){
            System.out.printf("%s %s %s %d Km/h\n",tmp.id,tmp.name,tmp.address,tmp.speed);
        }
    }
}
