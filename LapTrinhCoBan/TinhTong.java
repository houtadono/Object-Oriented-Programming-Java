package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhTong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n>0){
            int x = sc.nextInt();
            System.out.println((long) x*(x+1)/2);
            n--;
        }
    }    
}
