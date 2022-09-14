package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;
/**
 *
 * @author Houta
 */
public class LoaiBoSoNguyen {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DATA.in"));
        Vector<String> result = new Vector<>();
        while(sc.hasNext()){
            String s = sc.next();
            try{
                Integer.parseInt(s);
            }catch(NumberFormatException e){
                result.add(s);
            }
        }
        Collections.sort(result);
        for(String tmp : result)
            System.out.print(tmp+" ");
    }
}
