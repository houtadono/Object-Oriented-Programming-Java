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
public class CapSoNguyenToTrongFile_1 {
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
        
        TreeMap<Integer,Integer> res = new TreeMap<>();
        for(int i : a)
            if(prime(i)&&i<500000){
                int j = 1000000 - i;
                if(prime(j)){
                    int k = b.indexOf(j);
                    if(k!=-1) res.put(i, j);
                }
            }
        for(Integer i : res.keySet())
            System.out.printf("%d %d\n",i,res.get(i));
        is1.close();
        is2.close();
    }
}
