package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */

public class DienTichDaGiac {
    private static class Point{
        private double x;
        private double y;

        Point(double x, double y){
            this.x=x;
            this.y=y;
        }
        static double dtichDaGiac(ArrayList<Point> daGiac,int n){
            double res = daGiac.get(n-1).x*daGiac.get(0).y;
            for(int i = 0;i<n-1;i++)
                res += daGiac.get(i).x*daGiac.get(i+1).y;
            res -= daGiac.get(n-1).y*daGiac.get(0).x;
            for(int i = 0;i<n-1;i++)
                res -= daGiac.get(i).y*daGiac.get(i+1).x;
            return res/2;
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            ArrayList<Point> daGiac = new ArrayList<>();
            for(int i = 0;i<n;i++){
                daGiac.add(new Point(sc.nextDouble(),sc.nextDouble()));
            }
            System.out.printf("%.4f\n",Point.dtichDaGiac(daGiac,n));
        }
    }  
}
