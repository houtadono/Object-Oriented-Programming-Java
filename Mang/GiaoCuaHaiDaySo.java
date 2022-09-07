package Mang;
import java.util.Scanner;
import java.util.TreeSet;
/**
 *
 * @author Houta
 */
public class GiaoCuaHaiDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        TreeSet<Integer> tree1 = new TreeSet<>();
        TreeSet<Integer> tree = new TreeSet<>();
        for(int i = 0; i<m ;i++)
            tree1.add(sc.nextInt());
        for(int i = 0; i<n ;i++){
            int x = sc.nextInt();
            for(int j : tree1)
                if(j==x){
                    tree.add(j);
                }else if(j>x) break;
        }
        for(int i : tree){
            System.out.printf("%d ",i);
        }
    }
}
