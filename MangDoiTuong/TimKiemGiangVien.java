package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TimKiemGiangVien {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        ArrayList<GiangVien> ds = new ArrayList<>();
        int t = sc.nextInt(); sc.nextLine();
        while(t-->0){        
            ds.add(new GiangVien(sc.nextLine(),sc.nextLine()));
        }
        t = sc.nextInt(); 
        while(t-->0){
            String key = sc.next();
            System.out.printf("DANH SACH GIANG VIEN THEO TU KHOA %s:\n",key);
            for(GiangVien tmp : ds) 
                if(tmp.getName().toLowerCase().contains(key.toLowerCase()))
                    System.out.println(tmp);
        }
    }
}

class GiangVien{
    private final String id,name,subject;
    static int stt = 1;
    
    public GiangVien(String name, String subject) {
        this.id = String.format("GV%02d", stt++);
        this.name = name;
        this.subject = getSubject(subject);
    }
    
    private static String getSubject(String s){
        String res = "";
        String []data = s.split(" ");
        for(String i : data) res += Character.toUpperCase(i.charAt(0)) ;
        return res;
    }
    
    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.id+' '+this.name+' '+this.subject;
    }
}