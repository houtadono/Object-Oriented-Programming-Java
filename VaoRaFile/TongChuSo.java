package VaoRaFile;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 *
 * @author Houta
 */
public class TongChuSo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fileIS = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(fileIS);
        ArrayList<String> a = (ArrayList<String>) is.readObject();
        for(String tmp : a){
            tmp = tmp.toUpperCase();
            for(char i = 'A';i<='Z';i++)
                tmp = tmp.replace(i+"", "");
            while(tmp.startsWith("0")) tmp = tmp.substring(1);
            int sum = 0;
            for(int i=0; i<tmp.length();i++)
                sum += tmp.charAt(i) - '0';
            System.out.println(tmp+" "+sum);
        }
    }
}
