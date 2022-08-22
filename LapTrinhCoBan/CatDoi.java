package java_oop;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class CatDoi {
    public static long catDoi(long n){
        long res=0,dem = 1;
        while(n>0){
            int k = (int)(n%10);
            int c=2;
            if(k==0||k==8||k==9) c=0;
            if(k==1) c=1;
            if(c==2) return 0;
            n/=10;
            res +=dem*c;
            dem*=10;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            long n = sc.nextLong();
            n = catDoi(n);
            if(n==0) System.out.println("INVALID");
            else System.out.println(n);
        }
    }
    
}
