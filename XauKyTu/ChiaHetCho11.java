package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChiaHetCho11 {
    public static int check(String s){
        long c =0,l=0;
        int n = s.length();
        if(n%2==1) n--;
        for(int i=0;i<n;i++){
            l+=s.charAt(i++)-'0';
            c+=s.charAt(i)-'0';
        }
        if(s.length()%2==1) l+=s.charAt(n)-'0';
        if(Math.abs(l-c)%11==0) return 1;
        else return 0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            System.out.println(check(sc.next()));
        }
    }
}
