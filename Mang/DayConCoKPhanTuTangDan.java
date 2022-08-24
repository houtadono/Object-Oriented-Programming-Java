package Mang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Houta
 */
public class DayConCoKPhanTuTangDan {
    public static int n,k;
    public static int arr[]; 
    public static int res[]; 
    public static void backtracking(int i){
        for(int j=res[i-1]+1;j<=n-k+i;j++){
            res[i] = j;
            if(i==k){
                for(int p=1;p<=k;p++)
                    System.out.print(arr[res[p]]+" ");
                System.out.println();
            }else backtracking(i+1);
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            n = sc.nextInt();
            k = sc.nextInt();
            arr = new int [n+1];
            res = new int [n+1];
            for(int i=1;i<=n;i++)
                arr[i] = sc.nextInt();
            Arrays.sort(arr);
            res[0] = 0;
            backtracking(1);
        }
    }
}
