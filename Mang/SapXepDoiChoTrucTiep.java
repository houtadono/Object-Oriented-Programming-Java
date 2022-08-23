package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepDoiChoTrucTiep {
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
        for(int i= 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++)
                if(arr[j]<arr[i]){
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            System.out.printf("Buoc %d: ",i+1);
            in(arr,n);
        }
    }
}
