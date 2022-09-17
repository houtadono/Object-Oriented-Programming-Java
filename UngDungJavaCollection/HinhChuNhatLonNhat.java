package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class HinhChuNhatLonNhat {
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
        System.out.println(solve(arr,n));
    }
    
    static long solve(int []arr, int n){
        int [] l = new int [n]; l[n-1] = n-1;
        Stack<Integer> s1 = new Stack<>();
        s1.push(n-1);
        
        for(int i = n-2; i >= 0; i--){
            l[i] = i;
            while( !s1.isEmpty() && arr[s1.peek()] >= arr[i]){
                l[i] = l[s1.peek()];
                s1.pop();
            }
            s1.push(i);
        }
        
        int [] r = new int [n]; r[0] = 0;
        Stack<Integer> s2 = new Stack<>();
        s2.push(0);
        
        for(int i = 0; i < n; i++){
            r[i] = i;
            while( !s2.isEmpty() && arr[s2.peek()] >= arr[i]){
                r[i] = r[s2.peek()];
                s2.pop();
            }
            s2.push(i);
        }
        
        long res = 0;
        for(int i = 0; i < n; i++){
            long hcn = (long) arr[i] * ( Math.abs( i - l[i] ) + Math.abs( i - r[i] ) + 1 );
            res = Math.max(res, hcn);
        }
        
        return res;
    }
}
