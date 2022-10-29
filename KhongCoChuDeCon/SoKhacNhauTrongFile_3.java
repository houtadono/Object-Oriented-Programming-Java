package KhongCoChuDeCon;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.TreeMap;
/**
 *
 * @author Houta
 */
public class SoKhacNhauTrongFile_3 {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream FileIS = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(FileIS);
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        ArrayList<Integer> a = (ArrayList<Integer>) is.readObject();
        for(int k : a){
            if(mp.containsKey(k)) mp.put(k, mp.get(k)+1);
            else mp.put(k, 1);
        }
        for(Integer i : mp.keySet())
            System.out.printf("%d %d\n",i,mp.get(i));
        is.close();
    }
}
