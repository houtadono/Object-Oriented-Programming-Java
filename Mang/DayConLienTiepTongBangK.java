package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DayConLienTiepTongBangK {
    public static void main(String[] args){
       Scanner s = new Scanner(System.in);
       int p = s.nextInt();
       while(p-->0){
           int n = s.nextInt();
           long k = s.nextLong();
           long a[] = new long[n];
           for(int i =0;i<n;i++)
               a[i] = s.nextLong();
           
           int start = 0, end = 1;
           long sum = a[0];
           int c = 0;
           while(end <= a.length){
               while (sum > k && start < end-1){
                   sum -= a[start];
                   start++;
               }
               if(sum == k){
                   c = 1;
                   break;
               }
               if (end < a.length){
                   sum += a[end];
               }
               end++;
           }
           if(c == 0) System.out.println("NO");
           else System.out.println("YES");
       }
    }
}
