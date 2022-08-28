package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XauConLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String res = ""+s.charAt(s.length()-1);
        for(int i=s.length()-2;i>=0;i--){
            if(res.length()>0 && s.charAt(i) >= res.charAt(0)  )
                res = s.charAt(i) + res;
        }
        System.out.println(res);
    }
}