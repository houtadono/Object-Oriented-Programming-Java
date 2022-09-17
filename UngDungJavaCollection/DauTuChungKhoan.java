package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class DauTuChungKhoan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
            testCase(sc);
    }
    static void testCase(Scanner sc){
        int n = sc.nextInt();
        int []arr = new int [n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int []res = new int [n];
        Stack<Integer> stk = new Stack<>();
        stk.add(-1);
        for(int i = 0; i < n; i++){
            while(stk.peek() != -1 && arr[stk.peek()] <= arr[i])
                stk.pop();
            res[i] = i - stk.peek();
            stk.add(i);
        }
        for(int i : res)
            System.out.print(i + " ");
        System.out.println();
    }
}
