package UngDungJavaCollection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class So0VaSo9 {
    private static int [] layData(){
        Queue<Integer> q = new LinkedList<>();
        q.add(9);
        int dem = 0;
        int []vs = new int [101];
        int []res = new int [101];
        while(dem<100){
            int tmp = q.poll();
            for(int i = 1;i<101 ;i++)
                if(vs[i]==0 &&tmp%i==0){
                    vs[i] = 1;
                    res[i] = tmp;
                    dem++;
                }
            q.add(tmp*10);
            q.add(tmp*10+9);
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int []res = layData();
        int t = sc.nextInt();
        while(t-->0)
            System.out.println(res[sc.nextInt()]);
    }
}
