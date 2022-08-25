package Mang;

import java.util.Scanner;

/**
 *
 * @author Houta
 */
public class QuayPhai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            long []arr = new long[n+1];
            int res = 1;
            for(int i =1;i<=n;i++){
                arr[i] = sc.nextLong();
                if(arr[i]<arr[i-1]&&i>0){
                    res = i;
                }
            }
            System.out.println(res-1);
            
        }
    }
}
