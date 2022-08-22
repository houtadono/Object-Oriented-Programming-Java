package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class UocSoNguyenToLonNhat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            long n = sc.nextLong();
            long res=0;
            for(long i = 2;i*i<=n;i++){
                while(n%i==0){
                    n/=i;
                    res = i;
                }
                if(i%2==1) i++;
            }
            if(n>1) res = n;
            System.out.println(res);
        }
        sc.close();
    }
    
}
