package java_oop;
import static java.lang.Math.abs;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoLienKe {
    public static boolean checkSo(String n){
        for(int i = 0; i < n.length()-1;i++){
            int a = n.charAt(i);
            int b = n.charAt(i+1);
            if(abs(a-b)!=1) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String n = sc.nextLine();
            if(checkSo(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
