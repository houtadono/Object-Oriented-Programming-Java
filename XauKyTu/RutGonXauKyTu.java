package XauKyTu;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class RutGonXauKyTu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        Stack<Character> stk = new Stack<>();
        for(int i=0;i<s.length();i++){
            if(!stk.empty()&&stk.peek()==s.charAt(i)) stk.pop();
            else stk.add(s.charAt(i));
        }
        String res = "";
        while(!stk.empty()){
            res = stk.peek()+res;
            stk.pop();
        }
        if(res.isEmpty()) System.out.println("Empty String");
        else System.out.println(res);
    }
}
