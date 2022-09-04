package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TinhCuocDienThoaiCoDinh_1 {
    private static class ThanhPho{
        private String zipcode,name;
        private int giaCuoc;

        public ThanhPho(String zipcode, String name, int giaCuoc) {
            this.zipcode = zipcode;
            this.name = name;
            this.giaCuoc = giaCuoc;
        }
    }
    private static class CuocGoi{
        private String thueBao,timeStart,timeEnd,thanhPho;
        private int soPhut,pay;

        public CuocGoi(String thueBao, String timeStart, String timeEnd, ArrayList<ThanhPho> dsTP) {
            this.thueBao = thueBao;
            this.timeStart = timeStart;
            this.timeEnd = timeEnd;
            this.soPhut = getSoPhut(this.timeStart,this.timeEnd);
            if(this.thueBao.charAt(0)!='0'){
                this.thanhPho = "Noi mang";
                this.soPhut = (int) Math.ceil(this.soPhut/3.0);
                this.pay = 800*this.soPhut;
                return;
            }
            for(ThanhPho tmp : dsTP)
                if(this.thueBao.substring(1,3).contentEquals(tmp.zipcode)){
                    this.thanhPho = tmp.name;
                    this.pay = this.soPhut * tmp.giaCuoc;
                    break;
                }
        }
        static int getSoPhut(String start,String end){
            String [] data1 = start.split(":");
            String [] data2 = end.split(":");
            return (Integer.parseInt(data2[0]) -  Integer.parseInt(data1[0]))*60
                +Integer.parseInt(data2[1]) -  Integer.parseInt(data1[1]);
        }
        
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<ThanhPho> dsTP = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            dsTP.add(new ThanhPho(sc.nextLine(),sc.nextLine(),sc.nextInt()));
        }
        t = sc.nextInt(); 
        ArrayList<CuocGoi> dsCG = new ArrayList<>();
        while(t-->0) dsCG.add(new CuocGoi(sc.next(),sc.next(),sc.next(),dsTP));
        
        for(CuocGoi tmp : dsCG)
            System.out.printf("%s %s %d %d\n",tmp.thueBao,tmp.thanhPho,tmp.soPhut,tmp.pay);   
    }
}
