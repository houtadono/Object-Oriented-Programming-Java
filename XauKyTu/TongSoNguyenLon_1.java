package XauKyTu;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TongSoNguyenLon_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            System.out.println( new BigInteger(sc.next()).add(new BigInteger(sc.next())) );
        }
    }
}
