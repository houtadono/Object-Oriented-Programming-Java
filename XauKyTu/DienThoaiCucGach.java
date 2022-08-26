package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DienThoaiCucGach {
    public static int dir[]={2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,8,8,8,9,9,9,9};
    public static boolean check(String s){
        for(int i=0;i<=s.length()/2;i++)
            if(dir[s.charAt(i)-'A'] != dir[s.charAt(s.length()-i-1)-'A'])
                return false;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String s = sc.next();
            if(check(s.toUpperCase())) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
