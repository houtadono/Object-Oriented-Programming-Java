package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class BienSoDep {
    public static boolean check(String s){
        int tang = 1,lp=1,bang=0;
        for(int i=0;i<5;i++){
            if(s.charAt(i)!='6'&&s.charAt(i)!='8') lp=0;
            if(i>0&&s.charAt(i)<=s.charAt(i-1)) tang=0;
        }
        if(s.charAt(0)==s.charAt(1)&&s.charAt(1)==s.charAt(2)&&s.charAt(3)==s.charAt(4)) bang=1;
        return lp+tang+bang>0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String n = sc.next();
            String s = n.substring(5, 8)+n.substring(9);
            if(check(s)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
