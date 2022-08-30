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
    
    @Override
    public String toString(){
        return Long.toString(this.numerator)+ '/' + Long.toString(this.denominator) ;
    }
    Fraction add(Fraction p){
        long numera = this.numerator*p.denominator + this.denominator*p.numerator;
        long denomina = this.denominator*p.denominator;
        return new Fraction(numera,denomina);
    }
    Fraction sum(Fraction p1, Fraction p2){
        long numera = p1.numerator*p2.denominator + p1.denominator*p2.numerator;
        long denomina = p1.denominator*p2.denominator;
        return new Fraction(numera,denomina);
    }
}
public class PhanSo {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println(new Fraction(sc.nextLong(),sc.nextLong()).toString());
    }
}
