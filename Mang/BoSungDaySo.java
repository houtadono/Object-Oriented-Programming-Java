package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BoSungDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1,check=1;
        for(int i =0;i<n;i++){
            int x = sc.nextInt();
            while(res<x){
                System.out.println(res++);
                check = 0;
            }
            res++;
        }
        if(check == 1)System.out.println("Excellent!");
        
    }
}
