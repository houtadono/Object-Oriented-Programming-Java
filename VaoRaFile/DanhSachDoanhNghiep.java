package VaoRaFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachDoanhNghiep {
    private static class DoanhNghiep implements Comparable<DoanhNghiep>{
        private String id,name;
        private int receiveNumber;

        public DoanhNghiep(Scanner sc) {
            this.id = sc.next();
            sc.nextLine();
            this.name = sc.nextLine();
            this.receiveNumber = sc.nextInt();
        }

        @Override
        public int compareTo(DoanhNghiep o) {
            return this.id.compareTo(o.id);
        }
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+String.valueOf(this.receiveNumber);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DN.in"));
        int t = sc.nextInt();
        ArrayList<DoanhNghiep> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new DoanhNghiep(sc));
        }
        Collections.sort(ds);
        for(DoanhNghiep tmp : ds) 
            System.out.println(tmp);
    }
}
