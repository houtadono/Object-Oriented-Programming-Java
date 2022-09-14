package XauKyTu;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LoaiBo100 {
    static void testCase(Scanner sc){
        String s = sc.nextLine();
        int res = 0;
        ArrayList<Integer> z = new ArrayList<>();
        z.add(-1);
        String s1 = "";
        for(int i=0; i<s.length(); i++){
            s1 += s.charAt(i);
            z.add(i);
            while(s1.length()>0&& s1.endsWith("100")){
                s1 = s1.substring(0,s1.length()-3);
                z.remove(z.size()-3);
                z.remove(z.size()-2);
                z.remove(z.size()-1);
            }
            res = Math.max(res, i-z.get(z.size()-1));
        }
        System.out.println(res);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-->0)
            testCase(sc);
    }
}
