package Mang;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DemSoLanXuatHien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int test =1;test<=t;test++){
            int n = sc.nextInt();
            int []arr = new int[n];
            int []res = new int[n];
            int []dem = new int[n];
            for(int i=0;i<n ;i++)
                arr[i] = sc.nextInt();
            int size = 0;
            for(int i:arr){
                int check = 1;
                for(int j=0;j<res.length;j++){
                    if(res[j]==i){
                        dem[j]++;
                        check = 0;
                    }
                }
                if(check==1){
                    res[size] = i;
                    dem[size++] = 1;
                }
            }
            System.out.printf("Test %d:\n",test);
            for(int i = 0;i<size;i++)
                System.out.printf("%d xuat hien %d lan\n",res[i],dem[i]);
        }
    }
}
