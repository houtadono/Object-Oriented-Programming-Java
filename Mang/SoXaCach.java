package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoXaCach {
    public static int []arr = new int [12];
    public static int []vs = new int [12];
    public static int n,k;
    
    public static void in(){
        for(int i = 1;i<=n;i++)
            System.out.print(arr[i]);
        System.out.println();
    }
    
    public static void backtracking(int i){
        for(int j = 1;j<=n;j++){
            if(vs[j]==0){
                arr[i] = j;
                if(Math.abs(arr[i]-arr[i-1])==1&&i>1) continue;
                vs[j]=1;
                if(i==n) in();
                else backtracking(i+1);
                vs[j]=0;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            n = sc.nextInt();
            backtracking(1);
        }
        sc.close();
    }
}
