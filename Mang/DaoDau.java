package Mang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Houta
 */
public class DaoDau {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int []arrDuong = new int [n];
        int []arrAm = new int [n];
        int ptD=0,ptA=0;
        long sumD=0,sumA=0;
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(x<0){
                arrAm[ptA++] = x;
                sumA+=x;
            }else{
                arrDuong[ptD++] = x;
                sumD+=x;
            }
        }
        Arrays.sort(arrDuong,0,ptD);
        Arrays.sort(arrAm,0,ptA);
        if(k<ptA){
            int i=0;
            while(k>0){
                sumD-=2*arrAm[i++];
                k--;
            }
            sumD+=sumA;
        }else{
            k-=ptA;
            k%=2;
            sumD-=sumA;
            if(k==1){
                if(ptA>0){
                    if(ptD>0){
                        if(-arrAm[ptA-1]<arrDuong[0]) sumD += 2*arrAm[ptA-1];
                        else sumD -= 2*arrDuong[0];
                    }else sumD += 2*arrAm[ptA-1];
                }else sumD -= 2*arrDuong[0];
            }
        }
        System.out.print(sumD);
    }
}
