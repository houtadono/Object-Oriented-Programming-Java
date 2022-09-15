package VaoRaFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 *
 * @author Houta
 */
public class GiaTriNhiPhan {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(file);
        ArrayList<String> a = (ArrayList<String>) is.readObject();
        for(String tmp : a){
            long value = 0, pow = 1;
            String s = "";
            for(int i = tmp.length()-1; i>=0 ; i--)
                if(tmp.charAt(i)=='0'||tmp.charAt(i)=='1'){
                    s = tmp.charAt(i)+s;
                    value += pow* (tmp.charAt(i)-'0');
                    pow*=2;
                }
            System.out.println(s+" "+value);
        }
    }
}
