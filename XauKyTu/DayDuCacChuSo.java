package XauKyTu;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Houta
 */
public class DayDuCacChuSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        while(t>0){
            t--;
            long n = sc.nextLong();
            if(n==0){
                System.out.println("Impossible");
                continue;
            }
            Set<Integer> se = new HashSet<>();
            long k = n;
            while(true){
                String s = String.valueOf(k);
                for(int i=0;i<s.length();i++)
                    se.add(s.charAt(i)-'0');
                if(se.size()==10) break;
                k+=n;
            }
            System.out.println(k);
        }
        sc.close();
    }
}
