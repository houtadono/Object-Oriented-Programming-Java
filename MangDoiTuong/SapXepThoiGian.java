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
        private String t;
        public Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
            if(h>10) this.t = String.valueOf(h)+' ';
            else this.t = '0'+String.valueOf(h)+' ';
            if(m>10) this.t += String.valueOf(m)+' ';
            else this.t += '0'+String.valueOf(m)+' ';
            if(s>10) this.t += String.valueOf(s);
            else this.t += '0'+String.valueOf(s);
        }

        @Override
        public int compareTo(Time o) {
            return this.t.compareTo(o.t);
        }
        @Override
        public String toString() {
            return this.t;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<Time> ds = new ArrayList<>();
        while(t-->0) ds.add(new Time(sc.nextInt(),sc.nextInt(),sc.nextInt()));
        Collections.sort(ds);
        for(Time tmp:ds) System.out.println(tmp);
    }
}
