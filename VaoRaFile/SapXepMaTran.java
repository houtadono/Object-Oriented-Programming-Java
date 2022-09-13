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
public class SapXepMaTran {
    
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("MATRIX.in"));
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt() - 1;
            int arr[][] = new int [n][m];
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i = 0;i<n;i++)
                for(int j=0;j<m;j++){
                    arr[i][j] = sc.nextInt();
                    if(j==k) tmp.add(arr[i][j]);
                }
            Collections.sort(tmp);
            for(int i = 0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(j==k) System.out.print(tmp.get(i)+" ");
                    else System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
