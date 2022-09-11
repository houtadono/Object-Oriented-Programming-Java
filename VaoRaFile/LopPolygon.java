package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LopPolygon {
    private static class Point{
        private int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static class Polygon{
        private Point[] daGiac;

        public Polygon(Point[] daGiac) {
            this.daGiac = daGiac;
        }
        String getArea(){
            int n = this.daGiac.length;
            double res = this.daGiac[n-1].x*this.daGiac[0].y - this.daGiac[n-1].y*this.daGiac[0].x;;
            for(int i = 0; i<n-1;i++)
                res += this.daGiac[i].x*this.daGiac[i+1].y - this.daGiac[i].y*this.daGiac[i+1].x;
            res =  Math.abs(res)/2;
            return String.format("%.3f",res);
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("POLYGON.in"));
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            Point p[] = new Point[n];
            for(int i = 0; i < n; i++){
                p[i] = new Point(in.nextInt(),in.nextInt());
            }
            Polygon poly = new Polygon(p);
            System.out.println(poly.getArea());
        }
    }
}
