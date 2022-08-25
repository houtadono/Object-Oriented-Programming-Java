package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChuanHoaXauHoTen_1 {
    public static String chuanHoa(String s){
        s=s.strip().toLowerCase();
        String [] datas = s.split("\\s+");
        String res = "";
        for (String tmp : datas) {
            res+= Character.toUpperCase(tmp.charAt(0))+tmp.substring(1)+" ";
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String s = sc.nextLine();
            System.out.println(chuanHoa(" "+s));
        }
        sc.close();
    }
}
