package java_oop;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class KiemTraSoFibonacci {
    public static String tong(String a,String b){
        int n = (a.length()>=b.length())? a.length():b.length() ;
        while(a.length()<n) a = "0"+a;
        while(b.length()<n) b = "0"+b;
        String c = "";
        int du = 0;
        char d = '0';
        for(int i = n-1;i>=0;i--){
            int x = a.charAt(i) + b.charAt(i) + du - 2*d;
            if(x>9){
                x-=10;
                du = 1;
            }else{
                du = 0;
            }   
            String tmp = String.valueOf(x);
            c = tmp+c;
        }
        if(du==1) c= "1"+c;
        return c;
    }
    public static int soSanh(String a,String b){
        if(a.length()<b.length()) return -1;
        if(a.length()>b.length()) return 1;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)<b.charAt(i)) return -1;
            if(a.charAt(i)>b.charAt(i)) return 1;
        }
        return 1;
    }
    public static boolean  check(String n){
        String f1 = "0",f2 = "1";
        if(n.equals(f1) || n.equals(f2)) return true;
        String fn = f2;
        while(soSanh(fn,n)<0){
            f1 = f2;
            f2 = fn;
            fn = tong(f1,f2);
        }
        return n.equals(fn);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String n = sc.nextLine();
            if(check(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }  
}
