package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class NhanVien{
    private final String id,name;
    private final long basicSalary,dayWork,salary,bonus,allowance,income;
    private final String cv;

    NhanVien(String name, long basicSalary, long dayWork, String cv) {
        this.id = "NV01";
        this.name = name;
        this.basicSalary = basicSalary;
        this.dayWork = dayWork;
        this.salary = dayWork*basicSalary;
        if(dayWork>=25) this.bonus = this.salary/5;
        else if(dayWork>=22) this.bonus = this.salary/10;
        else this.bonus = 0;
        this.cv = cv;
        if(cv.contentEquals("GD")) this.allowance = 250000;
        else if(cv.contentEquals("PGD")) this.allowance = 200000;
        else if(cv.contentEquals("TP")) this.allowance = 180000;
        else this.allowance = 150000;
        this.income = this.salary + this.bonus + this.allowance;
    }
    
    void inThongTin(){
        System.out.println(this.id+' '+this.name+' '+this.salary+' '
            +this.bonus+' '+this.allowance+' '+this.income);
    }
}
public class BaiToanTinhCong {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        NhanVien p = new NhanVien(sc.nextLine(),sc.nextLong(),sc.nextLong(),sc.next());
        p.inThongTin();
    }
}
