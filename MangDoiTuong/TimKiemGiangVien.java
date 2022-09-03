package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class TimKiemGiangVien {
    static int stt = 1;
    private static class GiangVien{
        private String id,name,subject,mainName;

        public GiangVien(String name, String subject) {
            this.id = getId(stt++);
            this.name = name;
            this.mainName = getMainName(name);
            this.subject = getSubject(subject);
        }
        public static String getId(int n){
            String s = String.valueOf(n);
            while(s.length()==1) s = '0'+s;
            return "GV" + s;
        }
        public static String getMainName(String s){
            String [] data = s.split(" ");
            return data[data.length-1];
        }
        public static String getSubject(String s){
            String res = "";
            String []data = s.split(" ");
            for(String i : data) res += Character.toUpperCase(i.charAt(0)) ;
            return res;
        }
        
        @Override
        public String toString(){
            return this.id+' '+this.name+' '+this.subject;
        }
    }
    
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
                if(tmp.name.toLowerCase().contains(key.toLowerCase()))
                    System.out.println(tmp);
        }
    }
}
