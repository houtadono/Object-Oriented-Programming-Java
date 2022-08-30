package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class Point{
    private double x;
    private double y;

    Point(){
    }
    Point(double x, double y){
        this.x=x;
        this.y=y;
    }
    Point(Point p){
        this.x = p.x;
        this.y = p.y;
    }

    double getX(){
        return this.x;
    }
    double getY(){
        return this.y;
    }

    double distance(Point p){
        return Math.sqrt( Math.pow(p.x-this.x,2) + Math.pow(p.y-this.y,2) );
    }
    double distance(Point p1, Point p2){
        return Math.sqrt( Math.pow(p1.x-p2.x,2) + Math.pow(p1.y-p2.y,2) );
    }

    @Override
    public String toString(){
        return "Point(x,y): ("+this.x+','+this.y+')';
    }
}

class Triangle{
    public double canh1,canh2,canh3;
    
    Triangle(Point a, Point b, Point c) {
        this.canh1 = a.distance(b);
        this.canh2 = b.distance(c);
        this.canh3 = c.distance(a);
    }
    
    boolean isTriangle(){
        double m = this.canh1;
        double n = this.canh2;
        double p = this.canh3;
        return m+n>p && n+p>m && p+m>n;
    }
    
    double findPerimeter(){
        return this.canh1 + this.canh2 + this.canh3;
    }
}

public class ChuViTamGiac {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            Point a = new Point(sc.nextDouble(),sc.nextDouble());
            Point b = new Point(sc.nextDouble(),sc.nextDouble());
            Point c = new Point(sc.nextDouble(),sc.nextDouble());
            Triangle p = new Triangle(a,b,c);
            if(p.isTriangle()) System.out.printf("%.3f\n",p.findPerimeter());
            else System.out.println("INVALID");
        }
    }
}
