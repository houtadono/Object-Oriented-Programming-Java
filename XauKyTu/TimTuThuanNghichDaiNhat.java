package XauKyTu;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TimTuThuanNghichDaiNhat {
    public static class Word{
        public String str;
        public int sl;
        public Word(String str,int sl){
            this.str = str;
            this.sl = sl;
        }
    }
    public static boolean check(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!= s.charAt(s.length()-i-1)) 
                return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Word> a = new ArrayList<>();
        int sizee = 0;
        while(sc.hasNext()){
            String s = sc.next();
            if(!check(s)|| sizee>s.length()) continue;
            if(sizee<s.length()){
                sizee=s.length();
                a.add(new Word(s,1));
                continue;
            }
            int laplai = 0;
            for(int i=0;i<a.size();i++)
                if(a.get(i).str.contentEquals(s)){
                    laplai=1;
                    a.get(i).sl++;
                    break;
                }
            if(laplai==0){
                sizee=s.length();
                a.add(new Word(s,1));
            }
        }
        for(Word tmp:a ){
            if(tmp.str.length()== sizee)
                System.out.println(tmp.str+" "+tmp.sl);
        }
        sc.close();
    }
}
