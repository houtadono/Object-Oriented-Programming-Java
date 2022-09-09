package UngDungJavaCollection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeVaDem {
    private static class SoKhongGiam implements Comparable<SoKhongGiam>{
        private int so;
        private int count;

        public SoKhongGiam(int so) {
            this.so = so;
            this.count = 1;
        }
        
        static boolean isSoKhongGiam(int n){
            String s = String.valueOf(n);
            for(int i = 1;i<s.length();i++)
                if(s.charAt(i)<s.charAt(i-1)) return false;
            return true;
        }
        @Override
        public boolean equals(Object o) {
            if( getClass() == o.getClass()){
                SoKhongGiam other = (SoKhongGiam) o;
                return this.so == other.so;
            }
            return false;
        }
        @Override
        public int hashCode() {
            int hash = 3;
            hash = 79 * hash + Objects.hashCode(this.so);
            return hash;
        }
        @Override
        public int compareTo(SoKhongGiam o) {
            if(this.count<o.count) return 1;
            if(this.count>o.count) return -1;
            return 0;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<SoKhongGiam> ds = new ArrayList<>();
        while(sc.hasNextInt()){
            int n = sc.nextInt();
            if(SoKhongGiam.isSoKhongGiam(n)){
                int k = ds.indexOf(new SoKhongGiam(n));
                if(k<0){
                    ds.add(new SoKhongGiam(n));
                }else{
                    ds.get(k).count++;
                }
            }
        }
        Collections.sort(ds);
        for(SoKhongGiam tmp : ds)
            System.out.printf("%d %d\n",tmp.so,tmp.count);
    }
}
