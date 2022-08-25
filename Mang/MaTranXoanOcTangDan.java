package Mang;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Houta
 */
public class MaTranXoanOcTangDan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[]= new int[n*n];
        int matrix[][] = new int[n][n];
        for(int i=0;i<n*n;i++)
            arr[i] = sc.nextInt();
        Arrays.sort(arr);
        int dong=n,cot=n;
        int dem = 0,p=0;
        while(dem<n*n){
            for(int i=p;i<cot;i++) matrix[p][i]= arr[dem++];
            for(int i=p+1;i<dong;i++) matrix[i][cot-1] = arr[dem++];
            for(int i=cot-2;i>=p;i--) matrix[dong-1][i] = arr[dem++];
            for(int i=dong-2;i>p;i--) matrix[i][p] = arr[dem++];
            cot--;
            dong--;
            p++;
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++)
                System.out.print(matrix[i][j]+" ");
            System.out.println();
        }
    }
}
