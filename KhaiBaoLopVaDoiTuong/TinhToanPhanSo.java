package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class Fraction{
    private long numerator;
    private long denominator;
    
    Fraction(){
    }
    Fraction(long numerator,long denominator){
        long tmp = gcd(numerator,denominator);
        this.numerator = numerator/tmp;
        this.denominator = denominator/tmp;
    }
    
    static long gcd(long a,long b){
        while(a*b!=0){
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a+b;
    }
    
    Fraction add(Fraction p){
        long numera = this.numerator*p.denominator + this.denominator*p.numerator;
        long denomina = this.denominator*p.denominator;
        return new Fraction(numera,denomina);
    }
    Fraction mul(Fraction p){
        long numera = this.numerator*p.numerator;
        long denomina = this.denominator*p.denominator;
        return new Fraction(numera,denomina);
    }
    
    @Override
    public String toString(){
        return Long.toString(this.numerator)+ '/' + Long.toString(this.denominator) ;
    }
}

public class TinhToanPhanSo {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            Fraction a = new Fraction(sc.nextLong(),sc.nextLong());
            Fraction b = new Fraction(sc.nextLong(),sc.nextLong());
            Fraction c = a.add(b);
            c = c.mul(c);
            Fraction d = a.mul(b).mul(c);
            System.out.println(c.toString()+' '+d.toString());
        }    
    }
}
