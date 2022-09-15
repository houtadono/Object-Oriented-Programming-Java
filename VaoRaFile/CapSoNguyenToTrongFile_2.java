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
public class CapSoNguyenToTrongFile_2 {
    static int N = 1000000;
    static boolean ngto[] = new boolean [N+1];
    static boolean prime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i= 3;i*i<=n;i+=2)
            if(n%i==0) return false;
        return true;
    }
    static void sangNgto(){
        for (int i = 2; i <= N; i++)
            ngto[i] = true;
        for (int i = 2; i <= N; i++)
            if (ngto[i] == true)
            for (int j = 2 * i; j <= N; j += i)
                ngto[j] = false;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException{
        FileInputStream fileIS1 = new FileInputStream("DATA1.in");
        ObjectInputStream is1 = new ObjectInputStream(fileIS1);
        ArrayList<Integer> a = (ArrayList<Integer>) is1.readObject();
        
        FileInputStream fileIS2 = new FileInputStream("DATA2.in");
        ObjectInputStream is2 = new ObjectInputStream(fileIS2);
        ArrayList<Integer> b = (ArrayList<Integer>) is2.readObject();
        
        TreeMap<Integer,Integer> res = new TreeMap<>();
        sangNgto();
        for(int i : a)
            if(i<500000&&ngto[i]&&b.indexOf(i)==-1){
                int j = 1000000 - i;
                if(ngto[j]&&a.indexOf(j)!=-1&&b.indexOf(j)==-1)
                    res.put(i, j);
            }
        for(Integer i : res.keySet())
            System.out.printf("%d %d\n",i,res.get(i));
        is1.close();
        is2.close();
    }
}
