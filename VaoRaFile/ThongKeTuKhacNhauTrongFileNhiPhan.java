package VaoRaFile;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author Houta
 */
public class ThongKeTuKhacNhauTrongFileNhiPhan {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(file);
        ArrayList<String> a = (ArrayList<String>) is.readObject();
        
        String s = "";
        for(String tmp : a) s += tmp.toLowerCase() + " ";
        String [] data = s.split("\\W\\s*");
        
        Map<String,Integer> res = new HashMap<>();
        for (String i : data)
            if (!i.equals("")) 
                if (res.containsKey(i)) {
                    res.put(i, res.get(i) + 1);
                } else {
                    res.put(i, 1);
                }
        
        //sort by list
        List<Map.Entry<String, Integer>> t = new ArrayList<>(res.entrySet());
        Collections.sort(t, (o1,o2) -> o1.getKey().compareTo(o2.getKey()));
        Collections.sort(t, (o1,o2) -> o2.getValue().compareTo(o1.getValue()));
        
        t.forEach(i -> System.out.println(i.getKey()+" "+i.getValue()));
    }
}
