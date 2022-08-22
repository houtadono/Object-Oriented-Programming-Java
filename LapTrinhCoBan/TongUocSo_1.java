package java_oop;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TongUocSo_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long sum = 0;
        while(t>0){
            t--;
            int n = sc.nextInt();
            while (n % 2 == 0) {
                sum += 2;
                n /= 2;
            }
            for(int i = 3; i*i<=n; i+=2){
                while( n%i == 0){
                    sum += i;
                    n /= i;
                }
            }
            if(n>1) sum+=n;
        }
        System.out.print(sum);
    }
}
