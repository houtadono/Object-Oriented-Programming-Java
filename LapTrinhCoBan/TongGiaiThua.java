package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TongGiaiThua {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0, gt = 1;
        for (int i = 1; i <= n; i++) {
            gt *= i;
            result += gt;
        }
        System.out.println(result);
    }
}
