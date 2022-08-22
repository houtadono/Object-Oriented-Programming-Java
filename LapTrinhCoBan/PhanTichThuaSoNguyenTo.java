package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class PhanTichThuaSoNguyenTo {
    public static void phanTich(int n){
        int i = 2;
        while(n!=1){
            int dem = 0;
            while(n%i==0){
                dem+=1;
                n/=i;
            }
            if(dem>0) System.out.print(i+"("+dem+") ");
            i++;
        }
        System.out.println("");
    }     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int n = sc.nextInt();
            System.out.print("Test "+i+": ");
            phanTich(n);
        }
    }
}
