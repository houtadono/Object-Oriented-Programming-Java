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
public class ChuanHoaVaSapXep {
    private static class Person implements Comparable<Person>{
        private String tenFull,tenChinh;

        public Person(Scanner sc) {
            this.tenFull = chuanHoaTen(sc.nextLine());
            this.tenChinh = layTenChinh(this.tenFull);
        }
        static String chuanHoaTen(String s){
            s = s.trim().toLowerCase();
            String res = "" + Character.toUpperCase(s.charAt(0));
            for(int i=1; i< s.length();i++){
                if(Character.isLetter(s.charAt(i))){
                    if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
                    else res += s.charAt(i);
                }
            }
            return res;
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
        ArrayList<Person> dsP = new ArrayList<>();
        while(sc.hasNextLine())
            dsP.add(new Person(sc));
        Collections.sort(dsP);
        for(Person tmp: dsP)
            System.out.println(tmp);
    }
}
