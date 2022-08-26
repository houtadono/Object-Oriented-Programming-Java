package XauKyTu;
import java.math.BigInteger;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HieuSoNguyenLon_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String a = sc.next();
            String b = sc.next();
            int n = (a.length()>b.length()) ? a.length(): b.length();
            BigInteger res = new BigInteger(a).subtract(new BigInteger(b)).abs() ;
            String result = res.toString();
            while(result.length()<n){
                result = "0"+result;
            }
            System.out.println(result);
        }
        sc.close();
    }
}
