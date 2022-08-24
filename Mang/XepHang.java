package Mang;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Comparator;
/**
 *
 * @author Houta
 */
public class XepHang {
    public static class Pair{
        public int first;
        public int second;
        public Pair(){
        }
        public Pair(int first,int second){
            this.first = first;
            this.second= second;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair arr[] = new Pair[n];
        for(int i=0;i<n;i++){
            Pair tmp = new Pair(sc.nextInt(),sc.nextInt());
            arr[i]= tmp;
        }
        Comparator<Pair> cmp = new Comparator<Pair>() {
            @Override
            public int compare(Pair s1, Pair s2) {
                if (s1.first!=s2.first)
                    return s1.first-s2.first;
                else return s1.second-s2.second;
            }
        };
        Arrays.sort(arr,cmp);
        int res = 0;
        for(int i=0;i<n;i++){
            if(arr[i].first>=res) res= arr[i].first+ arr[i].second;
            else res+= arr[i].second;
        }
        System.out.println(res);   
    }
}
