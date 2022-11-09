package ThucHanhNhom8_To2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhTongCacChuSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            String s = sc.next();
            ArrayList<Character> arr = new ArrayList<>();
            int sum = 0;
            for(int i = 0; i < s.length(); i++)
                if(Character.isDigit(s.charAt(i))){
                    sum += s.charAt(i) - '0';
                }else arr.add(s.charAt(i));
            Collections.sort(arr);
            for(char i : arr)
                System.out.print(i);
            System.out.println(sum);
        }
    }
}
