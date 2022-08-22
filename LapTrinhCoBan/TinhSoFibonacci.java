package java_oop;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhSoFibonacci {
    public static void  fibonacci(long fibo[]){
        fibo[0] = 0;
        fibo[1] = 1;
        for(int i = 2;i<=92;i++){
            fibo[i] = fibo[i-1] + fibo[i-2];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        long []fibo = new long[93];
        fibonacci(fibo);
        while(t>0){
            t--;
            int n = sc.nextInt();
            System.out.println(fibo[n]);
        }
    }
}
