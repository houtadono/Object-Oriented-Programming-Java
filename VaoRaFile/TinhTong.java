package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhTong {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        long res = 0;
        while(sc.hasNext()){
            String s = sc.next();
            
            for(int i = 0;i<s.length();i++){
                if( Character.isDigit(s.charAt(i)) ){
                    long tmp = 0;
                    while(i<s.length()&&Character.isDigit(s.charAt(i))){
                        tmp = tmp*10 + s.charAt(i) - '0';
                        i++;
                    }
                    if(tmp==(int) tmp) res += tmp;
                    i--;
                }
            }
        }
        System.out.println(res);
    }
}
