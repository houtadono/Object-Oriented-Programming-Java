package KhaiBaoLopVaDoiTuong;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TongDaThuc {
    private static class DaThuc {
        private ArrayList<Integer> soMu;
        private ArrayList<Integer> heSo;

        public DaThuc(ArrayList<Integer> soMu, ArrayList<Integer> heSo) {
            this.soMu = soMu;
            this.heSo = heSo;
        }
        
        public DaThuc(String s) {
            String [] data = s.split(" \\+ ");
            ArrayList<Integer> hs = new ArrayList<>();
            ArrayList<Integer> sm = new ArrayList<>();
            for(String i : data){
                hs.add(Integer.parseInt(i.substring(0, i.indexOf('*'))));
                sm.add(Integer.parseInt(i.substring(i.indexOf('^')+1)));
            }
            this.heSo = hs;
            this.soMu = sm;
        }
        
        public DaThuc cong(DaThuc p){
            ArrayList<Integer> hs = new ArrayList<>();
            ArrayList<Integer> sm = new ArrayList<>();
            int i = 0, j = 0;
            while(i<this.soMu.size() && j<p.soMu.size() ){
                if(Objects.equals(this.soMu.get(i), p.soMu.get(j)) ){
                    sm.add(this.soMu.get(i));
                    hs.add(this.heSo.get(i)+p.heSo.get(j));
                    i++; j++;
                }else if(this.soMu.get(i)> p.soMu.get(j)){
                    sm.add(this.soMu.get(i));
                    hs.add(this.heSo.get(i));
                    i++;
                }else{
                    sm.add(p.soMu.get(j));
                    hs.add(p.heSo.get(j));
                    j++;
                }
            }
            while(i<this.soMu.size()){
                sm.add(this.soMu.get(i));
                hs.add(this.heSo.get(i));
                i++;
            }
            while(j<p.soMu.size() ){
                sm.add(p.soMu.get(j));
                hs.add(p.heSo.get(j));
                j++;
            }
            return new DaThuc(sm,hs);
        }
        
        @Override
        public String toString(){
            String s = "";
            for(int i=0; i<this.soMu.size();i++){
                s += this.heSo.get(i) + "*x^" +this.soMu.get(i) ;
                if(i < this.soMu.size()-1) s += " + ";
            }
            return s;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while(t-->0){
            DaThuc p = new DaThuc(sc.nextLine());
            DaThuc q = new DaThuc(sc.nextLine());
            DaThuc r = p.cong(q);
            System.out.println(r);
        }
    }
}
