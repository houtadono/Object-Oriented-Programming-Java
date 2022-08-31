package MangDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class SoPhuc {
    private int thuc,ao;

    public SoPhuc(){
    }
    public SoPhuc(int thuc, int ao) {
        this.thuc = thuc;
        this.ao = ao;
    }
    
    SoPhuc add(SoPhuc p){
        SoPhuc n = new SoPhuc();
        n.thuc = this.thuc+p.thuc;
        n.ao = this.ao+p.ao;
        return n;
    }
    SoPhuc mul(SoPhuc p){
        SoPhuc n = new SoPhuc();
        n.thuc = this.thuc*p.thuc-this.ao*p.ao;
        n.ao = this.ao*p.thuc+this.thuc*p.ao;
        return n;
    }
    
    @Override
    public String toString(){
        String s = "";
        s += String.valueOf(this.thuc);
        if(this.ao<0) s += " - ";
        else s += " + ";
        s += String.valueOf(Math.abs(this.ao)) + 'i';
        return s;
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            SoPhuc a = new SoPhuc(sc.nextInt(),sc.nextInt());
            SoPhuc b = new SoPhuc(sc.nextInt(),sc.nextInt());
            SoPhuc e = a.add(b);
            System.out.print(e.mul(a));
            System.out.print(", ");
            System.out.println(e.mul(e));
        }
    }
}
