package KhaiBaoLopVaDoiTuong;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
class ThiSinh{
    private String name,birthday;
    private float scores1,scores2,scores3;
    private float totalScores;

    ThiSinh(String name, String birthday, float scores1, float scores2, float scores3) {
        this.name = name;
        this.birthday = standardizationOfBirthDate(birthday);
        this.scores1 = scores1;
        this.scores2 = scores2;
        this.scores3 = scores3;
        this.totalScores = scores1 + scores2 + scores3;
    }
    
    static String standardizationOfBirthDate(String birthday){
        String []s = birthday.split("/");
        birthday = "";
        if(s[0].length()==1) s[0] = '0' + s[0];
        if(s[1].length()==1) s[1] = '0' + s[1];
        if(s[2].length()==2) s[2] = "20" + s[2];
        for(String i:s) birthday+= i+"/";
        return birthday;
    }
    
    @Override
    public String toString(){
        return this.name + ' ' + this.birthday +' ' + Float.toString(this.totalScores);
    }
}
public class KhaiBaoLopThiSinh {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        System.out.println(new ThiSinh(sc.nextLine(),sc.next(),sc.nextFloat(),
                    sc.nextFloat(),sc.nextFloat()
            ).toString()
        );
    }
}
