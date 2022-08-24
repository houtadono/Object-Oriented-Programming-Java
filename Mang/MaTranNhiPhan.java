package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class MaTranNhiPhan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count=0;
        for(int i=1;i<=n;i++){
            int dem = 0;
            for(int j=1;j<=3;j++){
                byte x = sc.nextByte();
                if(x==1) dem++; 
            }
            if(dem>1) count++;
        }
        System.out.print(count);   
    }
}
