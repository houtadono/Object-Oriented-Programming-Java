package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SapXepNoiBot {
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
            int check = 1;
            for(int j = 0;j<arr.length-1;j++){
                if(arr[j]>arr[j+1]){
                    check = 0;
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
            if(check == 1) break;
            System.out.printf("Buoc %d: ",i+1);
            in(arr,n);
        }
    }
}
