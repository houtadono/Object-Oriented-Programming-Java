package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XauDayDu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String s = sc.next();
            int k = sc.nextInt();
            if(s.length()<26){
                System.out.println("NO");
                continue;
            }
            boolean []c = new boolean[200];
            int dem = 0;
            for(int i = 0;i<s.length();i++)
                if(c[s.charAt(i)] == false){
                    c[s.charAt(i)] = true;
                    dem++;
                }
            if(26-dem>k) System.out.println("NO");
            else  System.out.println("YES");
        }
        sc.close();
    }
}
