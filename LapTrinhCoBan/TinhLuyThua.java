package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhLuyThua {
    public static  long p = 100000007;
    public  static long pow(long a,long b){
        if(b==1) return a%p;
        if(b==0) return 1;
        long c = pow(a,(long)b/2);
        if(b%2==0) return (c*c)%p;
        else return ((c*c)%p*a)%p;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            long a = sc.nextLong();
            long b = sc.nextLong();
            if(a==0&&b==0) break;
            System.out.println(pow(a,b));
        }
    }
}
