package LapTrinhCoBan;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Houta
 */
public class HelloFile {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(new File("Hello.txt"));
            while (scan.hasNextLine()) {
                System.out.print(scan.nextLine() + "\n");
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HelloFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
