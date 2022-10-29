package KhongCoChuDeCon;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LuaChonThamLam {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int numberCanDiff9 = (s%9 == 0)? 9 : s%9;
        int k = (s+8)/9;
        
        if( k>n || k==0 && n!=1 ){
            System.out.println("-1 -1");
            return;
        }
        if( k==0 && n==1 ){
            System.out.println("0 0");
            return;
        }
        
        System.out.println(getMin(numberCanDiff9,k,n)+" "+getMax(numberCanDiff9,k,n));
    }
    static String getMin(int numberCanDiff9, int k, int n){
        StringBuilder res = new StringBuilder("");
        
        if(k<n){
            res.append(1);
            while(res.length()<n-k){
                res.append(0);
            }
            res.append(numberCanDiff9-1);
        }else res.append(numberCanDiff9);
        
        while(res.length()<n) res.append(9);
        return res.toString();
    }
    static String getMax(int numberCanDiff9, int k, int n){
        StringBuilder res = new StringBuilder("");
        
        while(res.length()<k-1)
            res.append("9");
        res.append(numberCanDiff9);
        
        while(res.length()<n) res.append(0);
        return res.toString();
    }
}
