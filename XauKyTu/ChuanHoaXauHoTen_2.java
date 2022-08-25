package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChuanHoaXauHoTen_2 {
    public static String chuanHoa(String s){
        String res = "";
        for(int i=1;i<s.length();i++)
            if(Character.isLetter(s.charAt(i))&&s.charAt(i-1) == ' ' ) {
                res+= Character.toUpperCase(s.charAt(i));
                i++;
                while(i<s.length()&&Character.isLetter(s.charAt(i))){
                    res+= Character.toLowerCase(s.charAt(i));
                    i++;
                }
                res+=" ";
                i--;
            }
        res=res.substring(0,res.length()-1);
        String [] result = res.split(" ", 2);
        return result[1]+", "+result[0].toUpperCase();
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
