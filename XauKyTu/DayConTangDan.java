package XauKyTu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class DayConTangDan {
    public static int x[] = new int[100];
    public static int arr[] = new int[100];
    public static int n;
    public static String res = "" ;
    public static ArrayList<String> result = new ArrayList<>();
    
    public static void backtracking(int i){
        if(i>=n){
            
            return;
        }
        for(int j=i+1;j<=n;j++){
            if(arr[j]<arr[i]) continue;
            String tmp = res;
            res+= arr[j]+" ";
            if(res.split("\\s+").length>1)
                result.add(res);
            backtracking(j);
            res = tmp;
        }
    }
    public static void main(String []args){
        try {
            Scanner sc = new Scanner(new File("DAYSO.in"));
            n = sc.nextInt();
            arr[0] = 0;
            for(int i=1;i<=n;i++)
                arr[i] = sc.nextInt();
            backtracking(0);
            Collections.sort(result);
            System.out.print(result);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DayConTangDan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
