package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TichMaTranVoiChuyenViCuaNo {
    public static void inMatrix(int [][]a,int n,int m){
        for(int i = 0;i<n; i++){
            for(int j=0;j<m;j++)
                System.out.print(a[i][j]+" ");
            System.out.println();
        }  
    }
    public static int[][] multiMatrix(int [][]a,int[][]b,int n,int m){
        int [][]c = new int[n][n];
        for(int i =0;i<n;i++)
            for(int j=0;j<n;j++){
                c[i][j] = 0;
                for(int k=0;k<m;k++)
                    c[i][j] += a[i][k]*b[k][j];
            }
        return c;
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test = 1 ;test<=t;test++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int [][]a = new int[n][m];
            int [][]b = new int[m][n];
            for(int i = 0;i<n; i++)
                for(int j=0;j<m;j++){
                    a[i][j] = sc.nextInt();
                    b[j][i] = a[i][j];
                }
            int [][]c = multiMatrix(a,b,n,m);
            System.out.printf("Test %d:\n",test);
            inMatrix(c,n,n);
        }
    }
}