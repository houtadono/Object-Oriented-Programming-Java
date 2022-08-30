package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class GiaoVien{
    private String id,name;
    private  long basicSalary,allowance,income;
    private int salaryScale;

    GiaoVien(String id, String name, long basicSalary) {
        this.id = id;
        this.name = name;
        this.basicSalary = basicSalary;
        if(id.charAt(0) == 'H'){
            if(id.charAt(1) == 'T') this.allowance = 2000000;
            else this.allowance = 900000;
        }else this.allowance = 500000;
        this.salaryScale = Integer.parseInt(id.substring(2));
        this.income = this.basicSalary*this.salaryScale + this.allowance;
    }
    
    void inThongTin(){
        System.out.println(this.id+' '+this.name+' '+this.salaryScale+' '
                +this.allowance+' '+this.income);
    }
}

public class TinhThuNhapGiaoVien {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        GiaoVien p = new GiaoVien(sc.nextLine(),sc.nextLine(),sc.nextLong());
        p.inThongTin();
    }
}
