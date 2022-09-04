package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LopHocPhan_2 {
    private static class LopHocPhan implements Comparable<LopHocPhan>{
        private String id,tenNhom,sttNhom,tenGiangVien;

        public LopHocPhan(Scanner sc) {
            this.id = sc.next();
            sc.nextLine();
            this.tenNhom = sc.nextLine();
            this.sttNhom = sc.next();
            sc.nextLine();
            this.tenGiangVien = sc.nextLine();
        }

        @Override
        public int compareTo(LopHocPhan o) {
            if(this.id.contentEquals(o.id))
                return this.sttNhom.compareTo(o.sttNhom);
            return this.id.compareTo(o.id);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<LopHocPhan> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new LopHocPhan(sc));
        }
        Collections.sort(ds);
        t = sc.nextInt(); sc.nextLine();
        while(t-->0){
            String name = sc.nextLine();
            boolean check = false;
            for(LopHocPhan tmp : ds)
                if(tmp.tenGiangVien.contains(name)){
                    if(!check){
                        check = true;
                        System.out.printf("Danh sach cho giang vien %s:\n",name);
                    }
                    System.out.printf("%s %s %s\n",tmp.id,tmp.tenNhom,tmp.sttNhom);
                }
        }
    }
}
