package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class XepHangHocSinh {
    static int stt = 1;
    private static class HocSinh implements Comparable<HocSinh>{
        private String id,name,type;
        private double diemTB;
        
        HocSinh(Scanner sc){
            this.id = getId(stt++);
            this.name = sc.nextLine();
            this.diemTB = sc.nextDouble();
            if(this.diemTB<5) this.type = "Yeu";
            else if(this.diemTB<7) this.type = "Trung Binh";
            else if(this.diemTB<9) this.type = "Kha";
            else this.type = "Gioi";
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "HS"+s;
        }

        @Override
        public int compareTo(HocSinh o) {
            if(this.diemTB<o.diemTB) return 1;
            return -1;
        }
        
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<HocSinh> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            ds.add(new HocSinh(sc));
        }
        ArrayList<HocSinh> tmp = (ArrayList<HocSinh>) ds.clone();
        Collections.sort(tmp);
        Map map = new HashMap();
        map.put(tmp.get(0).id, 1);
        for(int i = 1;i<tmp.size();i++){
            if(tmp.get(i).diemTB==tmp.get(i-1).diemTB)
                map.put(tmp.get(i).id, map.get(tmp.get(i-1).id));
            else
                map.put(tmp.get(i).id, i+1);
        }
        for(HocSinh i: ds) 
            System.out.printf("%s %s %.1f %s %d\n",i.id,i.name,i.diemTB,i.type,map.get(i.id));
    }
}
