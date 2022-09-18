package UngDungJavaCollection;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class HinhChuNhatDonSac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int [] a = new int [n];
        int [] b = new int [n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
            b[i] = m - a[i];
        }
        System.out.println(Math.max(largestHCN(a,n),largestHCN(b,n)));
    }
    static long largestHCN(int []arr, int n){
        int []l = new int [n]; l[n-1] = n-1;
        Stack<Integer> stk1 = new Stack<>();
        stk1.push(n-1);
        for(int i = n-2; i >= 0; i--){
            l[i] = i;
            while( !stk1.isEmpty() && arr[stk1.peek()] >= arr[i] )
                l[i] = l[stk1.pop()];
            stk1.push(i);
        }
        
        int []r = new int [n]; r[0] = 0;
        Stack<Integer> stk2 = new Stack<>();
        stk2.push(0);
        for(int i = 1; i < n; i++){
            r[i] = i;
            while( !stk2.isEmpty() && arr[stk2.peek()] >= arr[i] )
                r[i] = r[stk2.pop()];
            stk2.push(i);
        }
        
        long res = 0;
        for(int i = 0; i < n; i++){
            long hcn = (long) arr[i]*(Math.abs(i-l[i])+Math.abs(i-r[i])+1);
            res = Math.max(res, hcn);
        }
        return res;
    }
}
