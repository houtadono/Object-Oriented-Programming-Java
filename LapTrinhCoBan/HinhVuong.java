package LapTrinhCoBan;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class HinhVuong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j;
        int [] a = new int [10];
        int []b = new int [5];
	for(i=1;i<=8;i++){
            a[i] = sc.nextInt();
	}
	for(j=1;j<=2;j++){
            int max=a[j];
            int min=a[j];
            for(i=j;i<=8;i=i+2){
                if(max<a[i]){
                    max=a[i];	
                }
                if(min>a[i]){
                    min=a[i];
                }
            }
            b[j]=max-min;
	}
        int res = (b[1]>=b[2])? b[1]:b[2];
	System.out.println(res*res);
    }
}