package VaoRaFile;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
/**
 *
 * @author Houta
 */
public class LietKeCapSo_2 {
    public static int UCLN(int a, int b){
        while(a*b!=0){
            int c = a%b;
            a = b;
            b = c;
        }
        return a+b;
    }
    public static boolean check(int a, int b){
        if(a>=b) return false;
        return UCLN(a,b)==1;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream file = new FileInputStream("DATA.in");
        ObjectInputStream is = new ObjectInputStream(file);
        ArrayList<Pair> a = (ArrayList<Pair>) is.readObject();
        Collections.sort(a);
        ArrayList<Pair> b = new ArrayList<>();
        for(Pair i : a)
            if(!b.contains(i) && check(i.getFirst(),i.getSecond()) ){
                System.out.println(i);
                b.add(i);
            }
    }
}