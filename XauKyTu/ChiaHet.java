package XauKyTu;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChiaHet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            BigInteger a = new BigInteger(sc.next());
            BigInteger b = new BigInteger(sc.next());
            BigInteger c = a.mod(b);
            BigInteger d = b.mod(a);
            if(c.toString().contentEquals("0")||d.toString().contentEquals("0"))
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
    }
}
