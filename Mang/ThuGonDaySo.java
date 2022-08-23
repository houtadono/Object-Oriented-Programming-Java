package Mang;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ThuGonDaySo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>(n);
        int res = 0;
        for(int i =0;i<n;i++){
            int x = sc.nextInt();
            if(a.isEmpty()){
                a.add(x);
                res++;
            }
            else if((a.get(res-1)+x)%2==0){
                a.remove(res-1);
                res--;
            }else{
                a.add(x);
                res++;
            }
        }
        System.out.println(res);
        
    }
}
