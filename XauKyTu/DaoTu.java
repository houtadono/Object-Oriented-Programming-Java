package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DaoTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String s = sc.nextLine();
            for(String i : s.split("\\s+")){
                StringBuilder tmp = new StringBuilder(i);
                System.out.print(tmp.reverse()+" ");
            }
            System.out.println();
        }
    }
}
