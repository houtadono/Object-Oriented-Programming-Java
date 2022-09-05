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
public class SoKhacNhauTrongFile_1 {
    private static class Number implements Comparable<Number> {
        int value;
        int count;
        Number(int gtr) {
            this.value = gtr;
            this.count = 1;
        }

        @Override
        public int compareTo(Number o){
            if(this.value>o.value) return 1;
            return -1;
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        ArrayList<Number> ds = new ArrayList<>();
        while(sc.hasNextInt()){
            int k = sc.nextInt();
            int check = 0;
            for(Number tmp : ds)
                if(tmp.value == k){
                    tmp.count++;
                    check = 1;
                    break;
                }
            if(check == 0) ds.add(new Number(k));
        }
        Collections.sort(ds);
        for(Number tmp : ds)
            System.out.printf("%d %d\n",tmp.value,tmp.count);
    }
}
