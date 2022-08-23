package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BoiSoNhoNhatCuaNSoNguyenDuongDauTien {
    public static long gcd(long a,long b){
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
            int n = sc.nextInt();
            long res = 1;
            for(int i = 2;i<=n;i++){
                res = res/gcd(res,i)*i;
            }
            System.out.println(res);
        }
    }
}
