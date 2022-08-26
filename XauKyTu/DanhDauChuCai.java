package XauKyTu;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhDauChuCai {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int res = 0;
        char []arr = new char [150];
        for(int i=0;i<s.length();i++){
            int check = 1;
            for(int j=0;j<res;j++)
                if(s.charAt(i)==arr[j]){
                    check=0;
                    break;
                }
            if(check==1) arr[res++] = s.charAt(i);
        }
        System.out.println(res);
    }
}
