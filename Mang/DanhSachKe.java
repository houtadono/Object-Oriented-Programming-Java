package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachKe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=1;i<=n;i++){
            System.out.printf("List(%d) = ",i);
            for(int j=1;j<=n;j++){
                byte x = sc.nextByte();
                if(x==1) System.out.print(j+" ");
            }
            System.out.println();
        }    
    }
}
