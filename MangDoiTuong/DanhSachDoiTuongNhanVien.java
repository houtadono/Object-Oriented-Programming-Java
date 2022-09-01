package MangDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class DanhSachDoiTuongNhanVien {
    static int stt = 1;
    private static class NhanVien{
        private String id,name,sex,birthday,address,taxCode,signDay;

        public NhanVien(String name, String sex, String birthday, String address, String taxCode, String signDay) {
            this.id = getId(stt++);
            this.name = name;
            this.sex = sex;
            this.birthday = standardDay(birthday);
            this.address = address;
            this.taxCode = taxCode;
            this.signDay = standardDay(signDay);
        }
        
        static String getId(int n){
            String s = String.valueOf(n);
            while(s.length()<5) s = '0'+s;
            return s;
        }
       public static String standardDay(String s){
            String []data = s.split("/");
            if(data[0].length()==1) data[0] = '0' + data[0];
            if(data[1].length()==1) data[1] = '0' + data[1];
            return data[0]+'/'+data[1]+'/'+data[2];
        }

        @Override
        public String toString(){
            return this.id+' '+this.name+' '+this.sex+' '+this.birthday+' '+this.address+' '+this.taxCode+' '+this.signDay;
        }
    }
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        NhanVien [] ds = new NhanVien[n];
        for(int i=0;i<n;i++){
            sc.nextLine();
            String name = sc.nextLine();
            String sex = sc.next();
            String bd = sc.next();
            sc.nextLine();
            String address = sc.nextLine();
            String tax = sc.next();
            String signD = sc.next();
            ds[i] = new NhanVien(name,sex,bd,address,tax,signD);
        }
        for(NhanVien i : ds) System.out.println(i);
    }
}
