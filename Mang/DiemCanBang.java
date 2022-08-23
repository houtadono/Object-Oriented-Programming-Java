package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DiemCanBang {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int []arr = new int[n+3];
            arr[0] = sc.nextInt();;
            for(int i =1;i<n;i++){
                int x = sc.nextInt();
                arr[i] = arr[i-1]+x;
            }
            int res = -1;
            for(int i = 1;i<n-1;i++){
                int x = arr[i-1];
                int y = arr[n-1] - arr[i];
                if(x==y){
                    res = i+1;
                    break;
                }
            }
            System.out.println(res);
            
        }
    }
}