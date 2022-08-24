package Mang;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BoBaSoPytago {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short t = sc.nextShort();
        while(t>0){
            t--;
            short n = sc.nextShort();
            long arr[] = new long[n];
            for(short i = 0;i<n;i++)
                arr[i] = sc.nextLong();
            Arrays.sort(arr);
            
            int x = 0, z = n-1, y= z-1;
            while(y!=0 && arr[x]*arr[x]+arr[y]*arr[y]!=arr[z]*arr[z]){
                if(arr[x]*arr[x]+arr[y]*arr[y]>arr[z]*arr[z]) y--;
                else x++;
                if(x==y){
                    x = 0;
                    z--;
                    y=z-1;
                }
            }
            if(y!=0 && arr[x]*arr[x]+arr[y]*arr[y]==arr[z]*arr[z]) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
