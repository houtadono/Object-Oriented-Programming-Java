package VaoRaFile;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.TreeMap;
/**
 *
 * @author Houta
 */
public class SoKhacNhauTrongFile_2 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileInputStream FileIS = new FileInputStream("DATA.IN");
        DataInputStream is = new DataInputStream(FileIS);
        ArrayList<Number> ds = new ArrayList<>();
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int i = 0 ;i<100000;i++){
            int k = is.readInt();
            if(mp.containsKey(k)) mp.put(k, mp.get(k)+1);
            else mp.put(k, 1);
        }
        for(Integer i : mp.keySet())
            System.out.printf("%d %d\n",i,mp.get(i));
        is.close();
    }
}
