package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ThongKeTuKhachNhauTrongFileVanBan {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("VANBAN.in"));
        String s = "";
        int n = Integer.parseInt(sc.nextLine());
        while(n-->0) s += sc.nextLine().toLowerCase()+" ";
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