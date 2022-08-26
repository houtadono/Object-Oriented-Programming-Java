package XauKyTu;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HieuSoNguyenLon_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        BigInteger res = new BigInteger(a).subtract(new BigInteger(b)) ;
        System.out.println(res);
        sc.close();
    }
}
