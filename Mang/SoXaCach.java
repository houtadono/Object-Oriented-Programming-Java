package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoXaCach {
    public static short []arr = new short [11];
    public static short []vs = new short [11];
    public static short n,k,res=0;
    
    public static void in(){
        for(short i = 1;i<=n;i++)
            System.out.print(arr[i]);
        System.out.println();
    }
    
    public static void backtracking(short i){
        for(short j = 1;j<=n;j++){
            if(vs[j]==0){
                arr[i] = j;
                if(Math.abs(arr[i]-arr[i-1])==1) continue;
                vs[j]=1;
                if(i==n) in();
                else backtracking((short)(i+1));
                vs[j]=0;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        short t = sc.nextShort();
        while(t>0){
            t--;
            n = sc.nextShort();
            backtracking((short)1);
        }
        
    }
}
