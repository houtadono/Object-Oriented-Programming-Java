package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepChen {
    public static void in(int arr[],int n){
        for(int i =0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []arr = new int[n];
        for(int i =0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        for(int i= 0;i<arr.length;i++){
            int k = i,tmp = arr[i];
            while(k>0&&arr[k-1]>tmp){
                arr[k] = arr[k-1];
                k--;
            }
            arr[k] = tmp;
            System.out.printf("Buoc %d: ",i);
            in(arr,i+1);
        }
    }
}
