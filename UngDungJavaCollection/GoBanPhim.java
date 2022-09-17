package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class GoBanPhim {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        Stack<Character> stk1 = new Stack<>();
        Stack<Character> stk2 = new Stack<>();
        
        for(int i = 0; i < s.length(); i++)
            switch (s.charAt(i)) {
                case '<':
                    if(!stk1.isEmpty()) stk2.push(stk1.pop());
                    break;
                case '>':
                    if(!stk2.isEmpty()) stk1.push(stk2.pop());
                    break;
                case '-':
                    if(!stk1.isEmpty()) stk1.pop();
                    break;
                default:
                    stk1.push(s.charAt(i));
                    break;
            }
        
        while(!stk1.isEmpty()) stk2.push(stk1.pop());
        while(!stk2.isEmpty()) System.out.print(stk2.pop());
    }
}
