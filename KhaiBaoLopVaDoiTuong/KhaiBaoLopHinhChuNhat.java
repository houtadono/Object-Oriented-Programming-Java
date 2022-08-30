package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class Rectangle{
    private double width;
    private double height;
    private String color;
    
    static String chuanHoaColor(String color){
        color = color.toLowerCase();
        return Character.toUpperCase(color.charAt(0))+color.substring(1);
    }
    
    Rectangle() {
        this.width = 1;
        this.height = 1;
    }
    Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = chuanHoaColor(color);
    }
    
    void setWidth(double width){
        this.width = width;
    }
    void setHeight(double height){
        this.height = height;
    }
    void setColor(String color){
        this.color = chuanHoaColor(color);
    }
    
    double getWidth(){
        return this.width;
    }
    double getHeight(){
        return this.height;
    }
    String getColor(){
        return this.color;
    }
    
    double findArea(){
        return this.width*this.height;
    }
    double findPerimeter(){
        return (this.width+this.height)*2;
    }
}

public class KhaiBaoLopHinhChuNhat {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        Rectangle hcn = new Rectangle(sc.nextDouble(),sc.nextDouble(),sc.next());
        if(hcn.getHeight() != (int)hcn.getHeight() || hcn.getWidth()!= (int)hcn.getWidth()||hcn.getWidth()<=0||hcn.getHeight()<=0)
            System.out.println("INVALID");
        else
            System.out.printf("%.0f %.0f %s\n", 
                hcn.findPerimeter(),hcn.findArea(),hcn.getColor());
    }
}
