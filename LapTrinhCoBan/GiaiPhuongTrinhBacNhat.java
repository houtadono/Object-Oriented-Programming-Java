package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class GiaiPhuongTrinhBacNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        if(a==0){
            if(b==0) System.out.println("VSN");
            else System.out.println("VN");
        }else{
            System.out.printf("%.2f",(double)-b/a);
        }
        
    }
}
