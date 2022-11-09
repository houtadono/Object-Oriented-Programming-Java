package UngDungJavaCollection;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;
public class TinhGiaTriBieuThuc {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("BIEUTHUC.in"));
		int t = sc.nextInt();
		while(t-->0) {
			String s = sc.next();
			s = trungto_hauto(s);
			System.out.println(tinhHauTo(s));
		}
	}
	
	static long tinhHauTo(String s) {
		Stack<Long> stk = new Stack<>();
		for(int i = 0; i < s.length(); i++ )
			if(Character.isDigit(s.charAt(i))) {
				long tmp = 0;
				while(Character.isDigit(s.charAt(i)) && i < s.length())
					tmp = tmp*10+ s.charAt(i++)-'0';
				if(s.charAt(i)!='#') i--;
				stk.push(tmp);
			}
			else if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'/*||s.charAt(i)=='%'||s.charAt(i)=='^'*/){
				long b = stk.pop();
				long a = stk.pop();
				if(s.charAt(i)=='+') stk.push(a+b);
				if(s.charAt(i)=='-') stk.push(a-b);
				if(s.charAt(i)=='*') stk.push(a*b);
				if(s.charAt(i)=='/') stk.push(a/b);
//				if(s.charAt(i)=='%') stk.push(a%b);
//				if(s.charAt(i)=='^') stk.push((long) Math.pow(a, b));
			}
		return stk.peek();
	}
	
	static String trungto_hauto(String s) {
		StringBuilder res = new StringBuilder();
		Stack<Character> stk = new Stack<>();
		for(int i = 0; i < s.length(); i++)
			if(Character.isDigit(s.charAt(i))) res.append(s.charAt(i));
			else if(s.charAt(i)=='(') stk.push('(');
			else if(s.charAt(i)==')'){
				while(!stk.isEmpty()&&stk.peek()!='(')
					res.append(stk.pop()); 
				stk.pop();
			}else if(s.charAt(i)=='+'||s.charAt(i)=='-'||s.charAt(i)=='*'||s.charAt(i)=='/'/*||s.charAt(i)=='%'||s.charAt(i)=='^'*/){
                                if(Character.isDigit(res.charAt(res.length()-1)))
                                    res.append('#');
				while(!stk.isEmpty() && getDegree(stk.peek()) >= getDegree(s.charAt(i)) ) 
					res.append(stk.pop());
				stk.push(s.charAt(i));
			}
		while(!stk.isEmpty()) {
			if(stk.peek()!='(') res.append(stk.peek());
			stk.pop();
		}
		return res.toString();
	}
	
	static int getDegree(char c) {
		if(c=='^') return 5;
		if(c=='*'||c=='/') return 4;
		if(c=='+'||c=='-') return 3;
		return 2;
	}
}