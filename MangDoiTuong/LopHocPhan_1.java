package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LopHocPhan_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        ArrayList<LopHocPhan> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new LopHocPhan(sc));
        }
        Collections.sort(ds);
        t = sc.nextInt();
        while(t-->0){
            String id = sc.next();
            boolean check = false;
            for(LopHocPhan tmp : ds)
                if(tmp.getId().contains(id)){
                    if(!check){
                        check = true;
                        System.out.printf("Danh sach nhom lop mon %s:\n",tmp.getTenNhom());
                    }
                    System.out.println(tmp);
                }
        }
    }
}
class LopHocPhan implements Comparable<LopHocPhan>{
    private String id,tenNhom,sttNhom,tenGiangVien;

    public LopHocPhan(Scanner sc) {
        this.id = sc.next();
        sc.nextLine();
        this.tenNhom = sc.nextLine();
        this.sttNhom = sc.next();
        sc.nextLine();
        this.tenGiangVien = sc.nextLine();
    }

    public String getId() {
        return id;
    }

    public String getTenNhom() {
        return tenNhom;
    }

    @Override
    public int compareTo(LopHocPhan o) {
        return this.sttNhom.compareTo(o.sttNhom);
    }
    @Override
    public String toString(){
        return sttNhom+' '+tenGiangVien;
    }
}
