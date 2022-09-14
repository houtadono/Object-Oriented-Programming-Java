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
public class SoThuanNghichTrongFile {
    static boolean thuanNghich(int n){
        String s = String.valueOf(n);
        if(s.length()%2==0||s.length()==1) return false;
        for(int i=0 ; i<=s.length()/2; i++)
            if(s.charAt(i)!=s.charAt(s.length()-i-1)||s.charAt(i)%2==0) return false;
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
        
        for(int i : b){
            if(res.containsKey(i)) res.put(i, res.get(i)+1);
            else if(thuanNghich(i)&&a.indexOf(i)!=-1) res.put(i, 1);
        }
        for(int i : a)
            if(res.containsKey(i)) res.put(i, res.get(i)+1);
        
        int dem =0;
        for(Integer i : res.keySet()){
            System.out.printf("%d %d\n",i,res.get(i));
            dem++;
            if(dem==10) break;
        }
        
        is1.close();
        is2.close();
    }
}
