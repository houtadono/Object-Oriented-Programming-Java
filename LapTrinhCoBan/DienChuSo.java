package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DienChuSo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String a = sc.nextLine();
            String b = sc.nextLine();
            int [] count = new int[10];
            int dem = 0;
            for(int i = a.length()-1;i>=0;i--){
                count[i] = dem;
                if(a.charAt(i)=='?') dem++;
            }
            long res = 0;
            for(int i=0; i<a.length();i++){
                if(a.charAt(i)=='?'){
                    res += ('9'-b.charAt(i))*Math.pow(10,count[i]);
                }else if(a.charAt(i) > b.charAt(i)){
                    res += Math.pow(10,count[i]);
                    break;
                }else if(a.charAt(i) < b.charAt(i)) {
                    break;
                }
            }
            System.out.println(res);
        }
    }
}
