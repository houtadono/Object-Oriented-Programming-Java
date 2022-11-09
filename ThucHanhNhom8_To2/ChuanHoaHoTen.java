package ThucHanhNhom8_To2;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChuanHoaHoTen {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0)
            testCase(sc);
    }
    static void testCase(Scanner sc){
        int n = Integer.parseInt(sc.nextLine());
        String s = sc.nextLine();
        System.out.println(chuanHoaTen(s, n));
    }
    static String chuanHoaTen(String s,int n){
        s = s.trim().toLowerCase();
        String res = "";
        int k = s.indexOf(' ');
        if(k == -1) return Character.toUpperCase(s.charAt(0)) + s.substring(1);
        if(n==1){
            k = s.lastIndexOf(" ");
            res = Character.toUpperCase(s.charAt(k+1)) + s.substring(k+2) + " ";
            for(int i = 0; i < k; i++){
                if(s.charAt(i)!=' '){
                    res += Character.toUpperCase(s.charAt(i++));
                    while(i<k && s.charAt(i)!=' ')
                        res += s.charAt(i++);
                    i--;
                    res+= " ";
                }
            }
        }else{
            k = s.indexOf(' ');
            for(int i = k; i<s.length();i++){
                if(s.charAt(i)!=' '){
                    res += Character.toUpperCase(s.charAt(i++));
                    while(i<s.length() && s.charAt(i)!=' ')
                        res += s.charAt(i++);
                    i--;
                    res+= " ";
                }
            }
            res += Character.toUpperCase(s.charAt(0)) + s.substring(1,k);
        }
        
        return res;
    }
}
