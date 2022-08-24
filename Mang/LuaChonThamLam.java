package Mang;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author Houta
 */
public class LuaChonThamLam {
    public static void soMaxMin(int n,int s){
        Stack<Integer> stk = new Stack<>();
        int dem = 0;
        String max_tmp = " ";
        while(s>0){
            if(s>9){
                stk.push(9);
                s-=9;
            }else{
                stk.push(s);
                s=0;
            }
            max_tmp += stk.peek();
            dem++;
        }
        if(dem == n){
            String max = "";
            while(!stk.empty()){
                System.out.print(stk.peek());
                max= stk.peek()+max;
                stk.pop();
            }
            System.out.print(" "+max);
        }else if(dem > n){
            System.out.print("-1 -1");
        }else{
//            min
            Stack<Integer> tmp = stk;
            System.out.print(1);
            int dem1 = dem;
            while(dem<n-1){
                System.out.print(0);
                dem++;
            }
            System.out.print(tmp.peek()-1);
            tmp.pop();
            while(!stk.empty()){
                System.out.print(stk.peek());
                stk.pop();
            }
//            max
            System.out.print(max_tmp);
            while(dem1<n){
                System.out.print(0);
                dem1++;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        if(9*n<s|| n>1&&s==0){
            System.out.print("-1 -1");
            return;
        }
        if(n==1&&s==0){
            System.out.print("0 0");
            return;
        }
        soMaxMin(n,s);
    }
}
