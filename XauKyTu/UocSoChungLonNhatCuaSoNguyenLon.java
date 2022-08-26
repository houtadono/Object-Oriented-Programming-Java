package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class UocSoChungLonNhatCuaSoNguyenLon {
    public static long gcd(long a,long b){
        while(a*b!=0){
            long tmp = a%b;
            a=b;
            b=tmp;
        }
        return a+b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            long a = sc.nextLong();
            sc.nextLine();
            String s = sc.nextLine();
            long b=0;
            for(int i=0;i<s.length();i++){
                b=(b*10+s.charAt(i)-'0')%a;
            }
            System.out.println(gcd(a,b));
        }
        sc.close();
    }
}
