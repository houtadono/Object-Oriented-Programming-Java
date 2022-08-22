package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class UocSoChiaHetCho2 {
    public static int soUoc(int n){
        int dem = 0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                int j = n/i;
                if(i==j) dem--;
                dem+=2;
            }
        }
        return dem;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int n = sc.nextInt();
            int dem = 0;
            while(n%2==0){
                n/=2;
                dem++;
            }
            System.out.println(dem*soUoc(n));
        }
    }
}
