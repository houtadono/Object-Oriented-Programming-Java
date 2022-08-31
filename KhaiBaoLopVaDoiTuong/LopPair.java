package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class Pair<T1,T2>{
    private T1 first;
    private T2 second;
    
    public Pair(T1 first, T2 second) {
        this.first = first;
        this.second = second;
    }
    boolean isPrime(Integer n){
        if(n<2) return false;
        for(int i=2;i*i<=n;i++)
            if(n%i==0) return false;
        return true;
    }
    boolean isPrime(){
       return isPrime((Integer) this.first)&&isPrime((Integer) this.second) ;
    }
    
    @Override
    public String toString(){
        return String.valueOf(this.first)+' '+String.valueOf(this.second);
    }
}
        
public class LopPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            boolean check = false;
            for(int i = 2; i <= 2*Math.sqrt(n); i++){
                Pair<Integer, Integer> p = new Pair<>(i, n-i);
                if(p.isPrime()){
                    System.out.println(p);
                    check = true;
                    break; 
                }
            }
            if(!check) System.out.println(-1);
        }
    }
}
