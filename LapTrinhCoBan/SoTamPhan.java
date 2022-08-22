package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoTamPhan {
    public static boolean check(int n){
        while(n>0){
            int k = n%10;
            if(k>2) return false;
            n/=10;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            if(check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
