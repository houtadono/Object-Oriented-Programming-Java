package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoKhongLienKe {
    public static boolean check(String n){
        int sum = n.charAt(0) -'0';
        for(int i=1;i<n.length();i++){
            if(Math.abs(n.charAt(i) - n.charAt(i-1))!=2)
                return false;
            sum+= n.charAt(i) -'0';
        }  
        return sum%10==0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String n = sc.nextLine();
            if (check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
