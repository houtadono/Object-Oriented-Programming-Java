package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoUuThe {
    public static int check(String s){
        int countEven = 0;
        int n =s.length();
        for(int i=0;i<n;i++)
            if(Character.isDigit(s.charAt(i))){
                if(s.charAt(i)%2==0) countEven++;
            }else return -1;
        if(n%2==0 && 2*countEven>n) return 1;
        if(n%2==1 && 2*countEven<n) return 1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String s = sc.next();
            int k = check(s);
            if (k!=1)if(k==0){
                System.out.println("NO");
            }else System.out.println("INVALID");else {
                System.out.println("YES");
            }
            // can't use switch-case
        }
    }
}
