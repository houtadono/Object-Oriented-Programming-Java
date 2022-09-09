package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class KiemTraDayNgoacDung {
    private static boolean checkCapKyTu(char a,char b){
        return a=='('&&b==')' || a=='['&&b==']' || a=='{'&&b=='}';
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            String s = sc.next();
            Stack<Character> stk = new Stack<>();
            int check = 1;
            for(int i=0;i<s.length();i++)
                if(s.charAt(i)==')'||s.charAt(i)==']'||s.charAt(i)=='}'){
                    if(!stk.isEmpty()){
                        char tmp = stk.peek(); stk.pop();
                        if(!checkCapKyTu(tmp,s.charAt(i))){
                            check = 0;
                            break;
                        }
                    }else {
                        check = 0;
                        break;
                    }
                }else stk.add(s.charAt(i));
            if(check==0||!stk.isEmpty()) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}
