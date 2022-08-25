package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoDep2 {
    public static boolean check(String s){
        if(s.charAt(0)!='8') return false;
        int sum = 0;
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i)!=s.charAt(s.length()-i-1))
                return false;
            sum+= 2*(s.charAt(i)-'0');
        }
        if(s.length()%2==1) sum+= (s.charAt(s.length()/2+1)-'0');
        return sum%10==0;
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
