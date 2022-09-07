package Mang;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class HopCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i = 0; i<m ;i++)
            tree.add(sc.nextInt());
        for(int i = 0; i<n ;i++)
            tree.add(sc.nextInt());
        for(int i : tree){
            System.out.printf("%d ",i);
        }
    }
}
