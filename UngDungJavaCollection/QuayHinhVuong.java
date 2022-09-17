package UngDungJavaCollection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
/**
 *
 * @author Houta
 */
public class QuayHinhVuong {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0)
            testCase(sc);
    }
    
    static void testCase(Scanner sc){
        String start = sc.nextLine().replace(" ", "");
        String target = sc.nextLine().replace(" ", "");
        System.out.println(solve(start, target));
    }
    static int solve(String start,String target){
        Queue<String> q = new LinkedList<>();
        Set<String> vs = new HashSet<>();
        q.add(start);
        vs.add(start);
        
        int level = 0;
        while(!q.isEmpty()){
            int size = q.size();
            while(size-->0){
                String tmp = q.poll();
                if(tmp.equals(target)) return level;
                String s1 = rotate1(tmp);
                String s2 = rotate2(tmp);
                if(s1.equals(target)||s2.equals(target)) return level + 1;
                if(!vs.contains(s1)){
                    vs.add(s1);
                    q.add(s1);
                }
                if(!vs.contains(s2)){
                    vs.add(s2);
                    q.add(s2);
                }
            }
            level++;
        }
        return level;
    }
    /*
    0 1 2 3 4 5 pos
    1 2 3 4 5 6 start 
    4 1 3 5 2 6 rotate 1 
    1 5 2 4 6 3 rotate 2 
    */
    static String rotate1(String s){
        StringBuilder ro = new StringBuilder("");
        ro.append(s.charAt(3));
        ro.append(s.charAt(0));
        ro.append(s.charAt(2));
        ro.append(s.charAt(4));
        ro.append(s.charAt(1));
        ro.append(s.charAt(5));
        return ro.toString();
    }
    static String rotate2(String s){
        StringBuilder ro = new StringBuilder("");
        ro.append(s.charAt(0));
        ro.append(s.charAt(4));
        ro.append(s.charAt(1));
        ro.append(s.charAt(3));
        ro.append(s.charAt(5));
        ro.append(s.charAt(2));
        return ro.toString();
    }
}
