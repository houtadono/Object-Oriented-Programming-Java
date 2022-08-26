package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DiaChiEmail {
    public static String chuanHoa(String s){
        s = s.trim().toLowerCase();
        String data[] = s.split("\\s+");
        String res = data[data.length-1];
        for(int i=0;i<data.length-1;i++)
            res+= data[i].charAt(0);
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        String []res = new String[t+1];
        for(int test = 0;test<t;test++){
            String s = sc.nextLine();
            s= chuanHoa(s);
            int dem=1;
            for(int i= 0;i<test;i++)
                if(s.contentEquals(res[i])) dem++;
            res[test] = s;
            String tmp = "";
            if(dem>1) tmp+=dem;
            System.out.println(s+tmp+"@ptit.edu.vn");
        }
        sc.close();
    }
}
