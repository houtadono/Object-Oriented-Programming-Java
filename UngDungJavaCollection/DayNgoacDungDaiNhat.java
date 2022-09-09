package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class DayNgoacDungDaiNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while(n-->0){
            String s = sc.next();
            int res = 0;
            Stack<Integer> stk = new Stack<>();
            stk.add(-1);
            for(int i=0;i<s.length();i++)
                if(s.charAt(i)=='(') stk.add(i);  
                else{
                    stk.pop();
                    if(!stk.isEmpty()){
                        res = Math.max(res,i-stk.peek());
                    }else stk.push(i);
                }
            System.out.println(res);
        }
    }
}
