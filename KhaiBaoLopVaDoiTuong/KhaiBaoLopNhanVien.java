package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class NhanVien{
    private String id,name,sex,birthday,address,taxCode,signDay;

    public NhanVien(String name, String sex, String birthday, String address, String taxCode, String signDay) {
        this.id = "00001";
        this.name = name;
        this.sex = sex;
        this.birthday = standardizationOfDate(birthday);
        this.address = address;
        this.taxCode = taxCode;
        this.signDay = standardizationOfDate(signDay);
    }
    
    static String standardizationOfDate(String day){
        String []s = day.split("/");
        day = "";
        if(s[0].length()==1) s[0] = '0' + s[0];
        if(s[1].length()==1) s[1] = '0' + s[1];
        if(s[2].length()==2) s[2] = "20" + s[2];
        for(String i:s) day+= i+"/";
        return day;
    }
    
    @Override
    public String toString(){
        return this.id+' '+this.name+' '+this.sex+' '+this.birthday+' '+this.address+' '+this.taxCode+' '+this.signDay;
    }
}
public class KhaiBaoLopNhanVien {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        String sex = sc.next();
        String bd = sc.next();
        sc.nextLine();
        String address = sc.nextLine();
        String tax = sc.next();
        String signD = sc.next();
        System.out.println(new NhanVien(name,sex,bd,address,tax,signD));
    }
}
