package MangDoiTuong;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachKhachHang {
    static int stt = 1;
    private static class KhachHang implements Comparable<KhachHang>{
        private String id,name,sex,birthday,address,date;

        public KhachHang(String name, String sex, String birthday, String address) {
            this.id = getId(stt++);
            this.name = standardName(name);
            this.sex = sex;
            this.birthday = standardDay(birthday);
            this.address = address;
            this.date = getDate(this.birthday);
        }
        static String getId(int n){
            String s = String.valueOf(n);
            while(s.length()<3) s = '0'+s;
            return "KH" + s;
        }
        static String standardName(String s){
            s = s.trim().toLowerCase();
            String res = "" + Character.toUpperCase(s.charAt(0));
            for(int i=1; i< s.length();i++)
                if(Character.isLetter(s.charAt(i))){
                    if(s.charAt(i-1) == ' ') res+= " "+ Character.toUpperCase(s.charAt(i));
                    else res += s.charAt(i);
                }
            return res;
        }
        static String standardDay(String s){
            String []data = s.split("/");
            if(data[0].length()==1) data[0] = '0' + data[0];
            if(data[1].length()==1) data[1] = '0' + data[1];
            return data[0]+'/'+data[1]+'/'+data[2];
        }
        static String getDate(String s){
            String []data = s.split("/");
            return data[2]+'/'+data[1]+'/'+data[0];
        }

        @Override
        public String toString(){
            return this.id+' '+this.name+' '+this.sex+' '+this.address+' '+this.birthday;
        }

        @Override
        public int compareTo(KhachHang o) {
            return this.date.compareTo(o.date);
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        ArrayList<KhachHang> ds = new ArrayList<>();
        while(t-->0){
            ds.add(new KhachHang(sc.nextLine(),sc.nextLine(),sc.nextLine(),sc.nextLine()));
        }
        Collections.sort(ds);
        for(KhachHang tmp: ds)
            System.out.println(tmp);
    }
}
