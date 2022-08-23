package LapTrinhCoBan;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class ToanLopBa {
    public static int ok;
    public static ArrayList<Integer> pos = new ArrayList<>();
    
    public static boolean check(String n){
        int a = (n.charAt(0)-'0')*10+(n.charAt(1)-'0');
        int b = (n.charAt(5)-'0')*10+(n.charAt(6)-'0');
        int c = (n.charAt(10)-'0')*10+(n.charAt(11)-'0');
        if(n.charAt(3)== '+') return a+b==c;
        else return a-b==c;
    }
    public static void backtracking(int i,String n){
        if(ok==0){
            if(i == pos.size()){
                if(check(n)){
                    System.out.println(n);
                    ok=1;  
                }
                return;
            }
            if(pos.get(i)==3){
                String tmp = n;
                backtracking(i+1,tmp.replaceFirst("\\?", "+"));
                tmp = n;
                backtracking(i+1,tmp.replaceFirst("\\?", "-"));
            }else{
                char st = '0';
                if(pos.get(i)== 0||pos.get(i)== 5||pos.get(i)== 10) st++;
                for(;st<='9';st++){
                    String tmp = n;
                    backtracking(i+1,tmp.replaceFirst("\\?",""+st));
                }
            }
        }
    }
    public static void solveTest(String n){
        if(n.charAt(0) == '0' ||n.charAt(3) == '*' ||n.charAt(3) == '/'||n.charAt(5) == '0'||n.charAt(10) == '0'){
            System.out.println("WRONG PROBLEM!");
        }else{
            pos.clear();
            ok = 0;
            for(int i = 0;i<n.length();i++)
                if(n.charAt(i)=='?')
                    pos.add(i);
            backtracking(0,n);
            if(ok==0)
                System.out.println("WRONG PROBLEM!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t>0){
            t--;
            String n = sc.nextLine();
            solveTest(n);
        }
    }
}
