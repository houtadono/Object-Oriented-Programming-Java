package KhongCoChuDeCon;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoChinhPhuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            if(Math.sqrt(n) == (int) Math.sqrt(n))
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
    }
}
