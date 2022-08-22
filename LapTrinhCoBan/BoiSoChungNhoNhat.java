package LapTrinhCoBan;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BoiSoChungNhoNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String m = sc.nextLine();
            String n = sc.nextLine();
            BigInteger a = new BigInteger(m);
            BigInteger b = new BigInteger(n);
            BigInteger uc = a.gcd(b);
            BigInteger bc = a.multiply(b).divide(uc);
            System.out.println(bc);
        }
    }
}
