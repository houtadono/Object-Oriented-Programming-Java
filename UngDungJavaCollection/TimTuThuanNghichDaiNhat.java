package UngDungJavaCollection;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TimTuThuanNghichDaiNhat {
    private static class TuThuanNghich{
        private String str;
        private int count;

        public TuThuanNghich(String str) {
            this.str = str;
            this.count = 1;
        }
        
        static boolean isThuanNghich(String s){
            return new StringBuilder(s).reverse().toString().contentEquals(s);
        }
        @Override
        public boolean equals(Object o) {
            if( getClass() == o.getClass()){
                TuThuanNghich other = (TuThuanNghich) o;
                return this.str.contentEquals(other.str);
            }
            return false;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 79 * hash + Objects.hashCode(this.str);
            return hash;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sizeMax = 0;
        ArrayList<TuThuanNghich> ds = new ArrayList<>();
        while(sc.hasNext()){
            String s = sc.next();
            if(s.length()>=sizeMax && TuThuanNghich.isThuanNghich(s)){
                if(s.length()>sizeMax){
                    sizeMax = s.length();
                    ds.clear();
                    ds.add(new TuThuanNghich(s));
                }else{
                    int k = ds.indexOf(new TuThuanNghich(s));
                    if(k<0){
                        ds.add(new TuThuanNghich(s));
                    }else{
                        ds.get(k).count++;
                    }
                }
            }
        }
        for(TuThuanNghich tmp : ds)
            System.out.printf("%s %d\n",tmp.str,tmp.count);
    }
}
