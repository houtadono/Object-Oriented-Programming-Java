package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HinhVuong {
    public static int max(int a,int b,int c,int d){
        return Math.max(a, Math.max(b,Math.max(c,d)));
    }
    public static int min(int a,int b,int c,int d){
        return Math.min(a, Math.min(b,Math.min(c,d)));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x11 = sc.nextInt();
        int y11 = sc.nextInt();
        int x12 = sc.nextInt();
        int y12 = sc.nextInt();
        int x21 = sc.nextInt();
        int y21 = sc.nextInt();
        int x22 = sc.nextInt();
        int y22 = sc.nextInt();
        int x2 = max(x11,x12,x21,x21);
        int x1 = min(x11,x12,x21,x21);
        int y2 = max(y11,y12,y21,y21);
        int y1 = min(y11,y12,y21,y21);
        int res = Math.max(x2-x1,y2-y1);
        System.out.println(res*res);
    }
}
