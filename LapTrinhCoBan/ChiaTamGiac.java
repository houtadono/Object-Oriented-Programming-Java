package LapTrinhCoBan;
import static java.lang.Math.sqrt;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChiaTamGiac {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            int N=sc.nextInt();
            int H=sc.nextInt();
            for(int i=1;i<N;i++){
                double x = H*sqrt((double)i/N);
                System.out.printf("%.6f " ,x);
            }
            System.out.println("");
        }
    }
}
