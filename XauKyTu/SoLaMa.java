package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoLaMa {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String[] ArrLama = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
            int[] ArrNumber = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
            String s = sc.next();
            int res = 0;
            for(int i=0;i<ArrLama.length;i++){
                while(s.startsWith(ArrLama[i])){
                    res += ArrNumber[i];
                    s = s.substring(ArrLama[i].length());
                    if("".equals(s)) break;
                }
            }
            System.out.println(res);
        }
    }
}
