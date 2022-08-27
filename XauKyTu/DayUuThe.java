package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DayUuThe {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String s = sc.nextLine();
            String []arr = s.split("\\s+");
            int n = arr.length;
            int countEven = 0;
            for(String tmp: arr){
                int x = Integer.parseInt(tmp);
                if(x%2==0) countEven++;
            }
            if(n%2==0 && 2*countEven>n ||n%2==1 && 2*countEven<n )
                System.out.println("YES");
            else 
                System.out.println("NO");
        }
    }
}
