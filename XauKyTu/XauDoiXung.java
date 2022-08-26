package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XauDoiXung {
    public static boolean check(String s){
        int dem = 0;
        for(int i=0;i<=s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                dem++;
        return dem==1||dem==0&&s.length()%2==1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String s = sc.next();
            if(check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
