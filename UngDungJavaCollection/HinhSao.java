package UngDungJavaCollection;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HinhSao {
    private static class Canh{
        private int dinh1,dinh2;

        public Canh(int dinh1, int dinh2) {
            this.dinh1 = dinh1;
            this.dinh2 = dinh2;
        }
    }
    private static class DoThi{
        private ArrayList<Canh> dsCanh;

        public DoThi(Scanner sc) {
            int n = sc.nextInt();
            this.dsCanh = new ArrayList<>();
            while(n-->1){
                int x = sc.nextInt();
                int y = sc.nextInt();
                this.dsCanh.add(new Canh(x,y));
            }
        }
        
        boolean isHinhSao(){
            int dinhChung = this.dsCanh.get(0).dinh1;
            if(dinhChung != this.dsCanh.get(1).dinh1 && dinhChung != this.dsCanh.get(1).dinh2)
                dinhChung = this.dsCanh.get(0).dinh2;
            for(Canh tmp : this.dsCanh)
                if(tmp.dinh1!=dinhChung&&tmp.dinh2!=dinhChung) return false;
            return true;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoThi a = new DoThi(sc);
        if(a.isHinhSao()) System.out.print("Yes");
        else System.out.print("No");
    }
}
