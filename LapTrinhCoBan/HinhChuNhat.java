package LapTrinhCoBan;
import java.util.*;        
/**
 *
 * @author Houta
 */
public class HinhChuNhat {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        if ((a<=0)||(b<=0)){
            System.out.print(0);
        }else{
            int chuvi = (a+b)*2;
            int dientich = a*b;
            System.out.print(chuvi+" "+dientich);
        }
    }
    
}

