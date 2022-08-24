package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class InMaTran {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int []arr = new int[n];
            for(int i =0;i<n;i++){
                if(i%2==0){
                    for(int j =0;j<n;j++){
                        int x = sc.nextInt();
                        System.out.print(x+" ");
                    }
                }else{
                    for(int j =0;j<n;j++){
                        arr[j] = sc.nextInt();
                    }
                    for(int j =n-1;j>=0;j--){
                        System.out.print(arr[j]+" ");
                    }
                }
                
            }
            System.out.println();
        }
    }
}
