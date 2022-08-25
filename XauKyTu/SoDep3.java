package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoDep3 {
    public static boolean checknto(char c){
        return c!='2'&&c!='3'&&c!='5'&&c!='7';
    }
    public static boolean check(String s){
        for(int i=0;i<=s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1) || checknto(s.charAt(i)))
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String s = sc.nextLine();
            if(check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }
}
