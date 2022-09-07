package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ChuanHoaXauHoTenTrongFile {
     public static String chuanHoa(String s){
        s=s.trim().toLowerCase();
        String [] datas = s.split("\\s+");
        String res = "";
        for (String tmp : datas) {
            res+= Character.toUpperCase(tmp.charAt(0))+tmp.substring(1)+" ";
        }
        return res;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        while(sc.hasNextLine()){
            String s = sc.nextLine();
            if(s.contentEquals("END")) break;
            System.out.println(chuanHoa(s));
        }
    }
}
