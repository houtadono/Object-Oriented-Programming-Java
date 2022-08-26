package XauKyTu;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class TapTuRiengCuaHaiXau {
    public static void solve(String a,String b){
        TreeSet<String> treeSetString = new TreeSet<>(new LinkedHashSet<String>(Arrays.asList(a.split("\\s+"))));
        LinkedHashSet<String> s2 = new LinkedHashSet<String>(Arrays.asList(b.split("\\s+")));
        treeSetString.forEach(x-> System.out.printf( s2.contains(x) ? "" : "%s " ,x) )  ;
        System.out.println();    
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String a = sc.nextLine();
            String b = sc.nextLine();
            solve(a,b);
        }
        sc.close();
    }
}
