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
public class TenVietTat {
    private static class Person implements Comparable<Person>{
        private String tenFull,vt,tenChinh;

        public Person(Scanner sc) {
            this.tenFull = sc.nextLine();
            this.vt = layVT(this.tenFull);
            this.tenChinh = layTenChinh(this.tenFull);
        }
        static String layVT(String s){
            String [] data = s.split(" ");
            String res = "";
            for(String tmp : data)
                res += tmp.charAt(0)+".";
            return res.substring(0,res.length()-1);
        }
        static String layTenChinh(String s){
            String [] data = s.split("\\s+");
            return data[data.length-1];
        }
        
        @Override
        public String toString(){
            return this.tenFull;  
        }
        @Override
        public int compareTo(Person o) {
            if(this.tenChinh.contentEquals(o.tenChinh))
                return this.tenFull.compareTo(o.tenFull);
            return this.tenChinh.compareTo(o.tenChinh);
        }
    }
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("DANHSACH.in"));
        int t = Integer.parseInt(sc.nextLine());
        ArrayList<Person> dsP = new ArrayList<>();
        while(t-->0){
            dsP.add(new Person(sc));
        }
        Collections.sort(dsP);
        t = sc.nextInt();
        while(t-->0){
            String q = sc.next();
            int k = q.indexOf("*");
            for(Person tmp: dsP)
                if(k == -1){
                    if( tmp.vt.contentEquals(q)) System.out.println(tmp);
                }else if(tmp.vt.substring(0,k).contentEquals(q.substring(0,k)) && tmp.vt.substring(k+1).contentEquals(q.substring(k+1)) ){
                    System.out.println(tmp);
                }
        }
    }
}
