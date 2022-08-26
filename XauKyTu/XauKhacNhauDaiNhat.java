package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XauKhacNhauDaiNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String a = sc.next();
            String b = sc.next();
            if(a.contentEquals(b)) System.out.println("-1");
            else System.out.println(Math.max(a.length(),b.length()));
        }
    }
}
