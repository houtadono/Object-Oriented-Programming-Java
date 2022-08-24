package Mang;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DayConCoTongNguyenTo {
    public static int n;
    public static int []arr;
    public static int []nt;
    public static String res= "";
    public static ArrayList<String> result = new ArrayList<String>();
    public static void  backtracking(int i,int sum){
        if(i>=n) return;
        if(nt[sum]==0){
            result.add(res);
        }
        for(int j=i+1;j<n;j++){
            String tmp = res;
            res+= arr[j]+" ";
            backtracking(j, sum+arr[j]);
            res = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        nt = new int[1500];
        sangnt();
        while(t>0){
            t--;
            n = sc.nextInt();
            arr = new int[n];
            for(int i =0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            Arrays. sort(arr);
            for(int l = 0, r= arr.length-1; l<r;l++,r--){
                int tmp = arr[l];
                arr[l] = arr[r];
                arr[r] = tmp;
            }
            backtracking(-1,0);
            
            Comparator<String> cmp = new Comparator<String>() {
                @Override
                public int compare(String s1,String s2){
                    String[]a = s1.split(" ");
                    String[]b = s2.split(" ");
                    for(int i=0;i<a.length&&i<b.length;i++)
                    if(Integer.parseInt(a[i]) !=Integer.parseInt(b[i]) )
                        return Integer.parseInt(a[i]) - Integer.parseInt(b[i]);
                    return a.length - b.length;
                }
            };
            Collections.sort(result,cmp);
            for (String i : result) {
                System.out.println(i);
            }
            result.clear();
        }
        sc.close();
    }
    public static void sangnt(){
        nt[0]=1;
        nt[1]=1;
        for(int i=2;i<1500;i++){
            if(nt[i]==0)
                for(int j=i*i;j<1500;j+=i)
                    nt[j]=1;
        }
    }
}
