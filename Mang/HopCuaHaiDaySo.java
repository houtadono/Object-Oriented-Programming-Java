package Mang;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HopCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int a[] = new int [m];
        int b[] = new int [n];
        for(int i = 0; i<m ;i++)
            a[i] = sc.nextInt();
        for(int i = 0; i<n ;i++)
            b[i] = sc.nextInt();
        Arrays.sort(a);
        Arrays.sort(b);
        int i=0,j=0;
        while(i<a.length && j<b.length){
            if(a[i] ==b[j]){
                System.out.print(a[i]+" ");
                i++;
                j++;
            }else if(a[i]>b[j]){
                System.out.print(b[j]+" ");
                j++;
            }else{
                System.out.print(a[i]+" ");
                i++;
            }
        }
        while(i<a.length){
            System.out.print(a[i]+" ");
            i++;
        }
        while(j<b.length){
            System.out.print(b[j]+" ");
            j++;
        }
    }
}
