package KhaiBaoLopVaDoiTuong;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachMonThi {
    private static class MonThi implements Comparable<MonThi> {
        private String id,name,form;
        public MonThi(String id, String name, String form) {
            this.id = id;
            this.name = name;
            this.form = form;
        }
        
        @Override
        public int compareTo(MonThi p) {
            return this.id.compareTo(p.id);
        }
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+this.form;
        }
    }
    
    public static void main(String[] args) throws FileNotFoundException{
        Scanner sc = new Scanner(new File("MONHOC.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<MonThi> ds = new ArrayList<>();
        for(int i =0;i<t;i++){
            ds.add(new MonThi(sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(ds);
        for (MonThi i : ds) System.out.println(i);
    }
}
