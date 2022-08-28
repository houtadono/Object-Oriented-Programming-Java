package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XuLyVanBan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = "";
        while(sc.hasNext()){
            s += sc.next()+" ";
        }
        s=s.toLowerCase();
        s= s.replace('?', '.');
        s= s.replace('!', '.');
        s= s.replace(". ", ".");
        String[] res = s.split("\\.");
        for(String tmp : res){
            if(Character.isAlphabetic(tmp.charAt(0))){
                System.out.println(Character.toUpperCase(tmp.charAt(0)) + tmp.substring(1));
                continue;
            }
            for(int i=0;i<tmp.length();i++)
                if(Character.isAlphabetic(tmp.charAt(i))||Character.isDigit(tmp.charAt(i)) ){
                    System.out.println(tmp);
                    break;
                }
        }
        sc.close();
    }
}
