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
public class SoNguyenToTrongHaiFileNhiPhan {
    static boolean prime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i= 3;i*i<=n;i+=2)
            if(n%i==0) return false;
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fileIS1 = new FileInputStream("DATA1.in");
        ObjectInputStream is1 = new ObjectInputStream(fileIS1);
        ArrayList<Integer> a = (ArrayList<Integer>) is1.readObject();
        
        FileInputStream fileIS2 = new FileInputStream("DATA2.in");
        ObjectInputStream is2 = new ObjectInputStream(fileIS2);
        ArrayList<Integer> b = (ArrayList<Integer>) is2.readObject();
        
        TreeMap<Integer,Integer> aTree = new TreeMap<>();
        TreeMap<Integer,Integer> bTree = new TreeMap<>();
        
        for(int i : a)
            if(aTree.containsKey(i)) aTree.put(i, aTree.get(i)+1);
            else if(prime(i)&&b.indexOf(i)!=-1) aTree.put(i, 1);
        
        for(int i : b)
            if(bTree.containsKey(i)) bTree.put(i, bTree.get(i)+1);
            else if(aTree.containsKey(i)) bTree.put(i, 1);
        
        
        for(Integer i : aTree.keySet())
            System.out.printf("%d %d %d\n",i,aTree.get(i),bTree.get(i));
        
        is1.close();
        is2.close();
    }
}
