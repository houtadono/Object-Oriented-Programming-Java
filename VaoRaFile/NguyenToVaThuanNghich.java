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
public class NguyenToVaThuanNghich {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fileIS1 = new FileInputStream("DATA1.in");
        ObjectInputStream is1 = new ObjectInputStream(fileIS1);
        ArrayList<Integer> a = (ArrayList<Integer>) is1.readObject();
        
        FileInputStream fileIS2 = new FileInputStream("DATA2.in");
        ObjectInputStream is2 = new ObjectInputStream(fileIS2);
        ArrayList<Integer> b = (ArrayList<Integer>) is2.readObject();
        
        TreeMap<Integer,Integer> ar = new TreeMap<>();
        TreeMap<Integer,Integer> br = new TreeMap<>();
        
        for(int i : a)
            if(ar.containsKey(i)) ar.put(i, ar.get(i)+1);
            else if(prime(i)&&thuanNghich(i)&&b.indexOf(i)!=-1) ar.put(i, 1);
        for(int i : b)
            if(br.containsKey(i)) br.put(i, br.get(i)+1);
            else if(ar.containsKey(i)) br.put(i, 1);
        
        for(int tmp : ar.keySet())
            System.out.printf("%d %d %d\n",tmp,ar.get(tmp),br.get(tmp));
    }
    static boolean prime(int n){
        if(n<2) return false;
        if(n==2) return true;
        if(n%2==0) return false;
        for(int i= 3;i*i<=n;i+=2)
            if(n%i==0) return false;
        return true;
    }
    static boolean thuanNghich(int n){
        String s = String.valueOf(n);
        for(int i = 0; i<s.length()/2;i++)
            if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
        return true;
    }
}
