package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TongUocSo_2 {
    public static boolean check(int n){
        int dem = 1;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                if(n/i==i) dem+= i;
                else dem+= i+n/i;
            }
        }
        return dem>n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int dem = 0;
        for(int i=a;i<=b;i++){
            if(check(i)) dem++;
            if(i%10==2||i%10==6||i%10==8||i%10==0) i++;
        }
        int arr[] = new int[]{
            81081,
            153153,
            171171,
            189189,
            207207,
            223839,
            243243,
            261261,
            279279,
            297297,
            351351,
            459459,
            513513,
            567567,
            621621,
            671517,
            729729,
            742203,
            783783,
            793611,
            812889,
            837837,
            891891,
            908523,
            960687,
            999999
        };
        for(int i=0;i<arr.length;i++){
            if(arr[i]<a) break;
            if(arr[i]>b) break;
            dem++;
        }
        System.out.println(dem);
       
    }
}
