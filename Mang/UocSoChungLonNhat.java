package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class UocSoChungLonNhat {
    static int a[],b[],n;
    static boolean check;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            n = sc.nextInt();
            a = new int [n];
            b = new int [n+1];
            for(int i=0; i<n; i++) a[i] = sc.nextInt();
            check = false;
            b[0] = a[0];
            backtracking(0);
            for(int i = 0; i <= n; i++)
                System.out.print(b[i] + " ");
            System.out.println();
        }
    }
    static void backtracking(int i){
        if(i<n-1){
            int x = lcm(a[i],a[i+1]);
            int step = x;
            while(true){
                if(gcd(b[i],x)==a[i]){
                    if(check) return;
                    b[i+1] = x;
                    backtracking(i+1);
                }else x += step;
            }
        }else{
            int x = a[i];
            while(true){
                if(gcd(b[i],x)==a[i]){
                    check = true;
                    b[i+1] = x;
                    return;
                }else x += a[i];
            }
        }
    }

    private static int lcm(int a, int b) {
        return a*b/gcd(a,b);
    }

    private static int gcd(int a, int b) {
        if(b==0) return a;
        return gcd(b,a%b);
    }
}
