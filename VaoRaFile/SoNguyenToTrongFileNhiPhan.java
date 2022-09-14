package VaoRaFile;
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
public class SoNguyenToTrongFileNhiPhan {
    static boolean prime(int n){
        if(n<2) return false;
        for(int i= 2;i*i<=n;i++)
            if(n%i==0) return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream FileIS = new FileInputStream("SONGUYEN.in");
        ObjectInputStream is = new ObjectInputStream(FileIS);
        ArrayList<Integer> a = (ArrayList<Integer>) is.readObject();
        TreeMap<Integer,Integer> mp = new TreeMap<>();
        for(int k: a)
            if(prime(k)){
                if(mp.containsKey(k)) mp.put(k, mp.get(k)+1);
                else mp.put(k, 1);
            }
        for(Integer i : mp.keySet())
            System.out.printf("%d %d\n",i,mp.get(i));
        is.close();
    }
}
