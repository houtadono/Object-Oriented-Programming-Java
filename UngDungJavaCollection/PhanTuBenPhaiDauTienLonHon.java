package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class PhanTuBenPhaiDauTienLonHon {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0)
            testCase(sc);
    }
    static void testCase(Scanner sc){
        int n = sc.nextInt();
        int [] arr = new int [n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        solve(arr,n);
    }
    static void solve(int []arr, int n){
        Stack<Integer> stk = new Stack<>();
        int [] res = new int[n];
        
        res[n-1] = -1;
        stk.push(arr[n-1]);
        
        for(int i = n-2; i>=0; i--){
            while( !stk.isEmpty()&& arr[i] >= stk.peek()) 
                stk.pop();
            
            if(stk.isEmpty()) res[i] = -1;
            else res[i] = stk.peek();
            
            stk.push(arr[i]);
        }
        
        for(int i : res)
            System.out.print( i + " " );
        
        System.out.println();
    }
}
