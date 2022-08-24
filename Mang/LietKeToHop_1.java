package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LietKeToHop_1 {
    public static short []arr = new short [14];
    public static short n,k,res=0;
    public static void in(){
        for(short i = 1;i<=k;i++)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
    public static void backtracking(short i){
        for(short j = (short)(arr[i-1]+1) ;j<=n-k+i;j++){
            arr[i] = j;
            if(i==k){
                in();
                res++;
            }else{
                backtracking((short)(i+1));
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextShort();
        k = sc.nextShort();
        arr[0] = 0;
        backtracking((short)1);
        System.out.printf("Tong cong co %d to hop",res);
    }
}
