package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChuanHoaXauHoTen_2 {
    public static String chuanHoa(String s){
        s=s.trim().toLowerCase();
        String [] datas = s.split("\\s+");
        String res = "";
        for(int i=1;i<datas.length;i++){
            String tmp = datas[i];
            res+= Character.toUpperCase(tmp.charAt(0))+tmp.substring(1)+" ";
        }

        return res.substring(0,res.length()-1)+", "+datas[0].toUpperCase();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String s = sc.nextLine();
            System.out.println(chuanHoa(s));
        }
        sc.close();
    }
}