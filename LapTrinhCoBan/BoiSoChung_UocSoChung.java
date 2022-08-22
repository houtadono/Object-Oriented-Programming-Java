package java_oop;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BoiSoChung_UocSoChung {
    public static long GCD(long a,long b){
        while(a*b!=0){
            long c = a%b;
            a = b;
            b = c;
        }
        return a+b;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            long a = sc.nextLong();
            long b = sc.nextLong();
            long uc = GCD(a,b);
            long bc = a/uc * b;
            System.out.println(bc+" "+uc);
        }
    }
    
}
