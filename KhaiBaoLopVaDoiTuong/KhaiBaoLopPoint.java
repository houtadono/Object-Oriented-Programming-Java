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
public class KhaiBaoLopPoint {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t>0){
            t--;
            System.out.printf("%.4f\n", 
                new Point(sc.nextDouble(),sc.nextDouble()).distance(new Point(sc.nextDouble(),sc.nextDouble())));
            /*
            or using: 
            System.out.printf("%.4f\n", 
                new Point().distance( new Point(sc.nextDouble(),sc.nextDouble()) , new Point(sc.nextDouble(),sc.nextDouble()) ) 
            );
            */
        }
    }
}
