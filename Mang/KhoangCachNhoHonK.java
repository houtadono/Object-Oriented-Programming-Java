package Mang;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class KhoangCachNhoHonK {
    public static int lower_bound(int array[], int key){
        int index = Arrays.binarySearch(array, key);
        if (index < 0) {
            return Math.abs(index) - 2;
        }else{
            while (index > 0) {
                if (array[index] == key)
                    index--;
                else
                    return index;
            }
            return index;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int k = sc.nextInt();
            int []arr = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long res = 0;
            for(int i=0;i<n-1;i++)
                res += lower_bound(arr,arr[i]+k) -i;
            System.out.println(res);
        }
    }
}
