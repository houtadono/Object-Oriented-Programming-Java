package ThucHanhNhom8_To2;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Houta
 */
public class KiemTraSoFibonacci {
    static Set<BigInteger> vs = new HashSet<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sang();
        while(t-->0){
            BigInteger n = new BigInteger(sc.next());
            if(vs.contains(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static void sang(){
        BigInteger f1;
        BigInteger f2 = new BigInteger("0");
        BigInteger fn = new BigInteger("1");
        vs.add(f2);
        BigInteger max = new BigInteger("10").pow(18);
        while(fn.compareTo(max)<=0){
            f1 = f2;
            f2 = fn;
            fn = f1.add(f2);
            vs.add(fn);
        }
    }
}
