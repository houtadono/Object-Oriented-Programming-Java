package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class MaHoaDRM {
    public static String rotate(String s){
        int xoay = 0;
        for(int i = 0; i<s.length();i++)
            xoay += s.charAt(i)-'A';
        xoay %= 26;
        String res = "";
        for(int i = 0; i<s.length();i++){
            int k = s.charAt(i)+xoay;
            if(k>'Z') k-=26;
            res+= (char)k;
        }
        return res;
    }
    public static String merge(String a,String b){
        String res = "";
        for(int i = 0; i<a.length();i++){
            int k = a.charAt(i)+ b.charAt(i)-'A';
            if(k>'Z') k-=26;
            res+= (char)k;
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            String s = sc.next();
            String a = s.substring(0,s.length()/2);
            String b = s.substring(s.length()/2);
            System.out.println(merge(rotate(a),rotate(b)));
        }
        sc.close();
    }
}
