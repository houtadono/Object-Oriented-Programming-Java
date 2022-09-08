package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepThoiGian {
    private static class Time implements Comparable<Time>{
        private int h,m,s;
        public Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        @Override
        public int compareTo(Time o) {
            if(this.h>o.h) return 1;
            if(this.h<o.h) return -1;
            if(this.m>o.m) return 1;
            if(this.m<o.m) return -1;
            if(this.s>o.s) return 1;
            return -1;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<Time> ds = new ArrayList<>();
        while(t-->0) ds.add(new Time(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        Collections.sort(ds);
        for(Time tmp:ds) 
            System.out.print(tmp.h+" "+tmp.m+" "+tmp.s+"\n");
    }
}
