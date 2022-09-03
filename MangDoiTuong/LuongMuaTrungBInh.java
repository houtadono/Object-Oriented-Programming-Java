package MangDoiTuong;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Houta
 */
public class LuongMuaTrungBInh {
    static int stt = 1;
    private static class TramDo{
        private String id,name,timeStart,timeEnd;
        private int rainFall;
        private double time;

        public TramDo(String name, String timeStart, String timeEnd, int rainFall) {
            this.name = name;
            this.timeStart = timeStart;
            this.timeEnd = timeEnd;
            this.time = getTime(this.timeStart,this.timeEnd);
            this.rainFall = rainFall;
        }
        static String getId(int n){
            String s = String.valueOf(n);
            if(s.length()==1) s = '0'+s;
            return "T"+s;
        }
        static double getTime(String timeStart, String timeEnd){
            double h = Integer.parseInt(timeEnd.substring(0,2)) - Integer.parseInt(timeStart.substring(0,2)) ;
            double m = (double) (Integer.parseInt(timeEnd.substring(3)) - Integer.parseInt(timeStart.substring(3)))/60 ;
            return h+m;
        }
        
        void update(TramDo p){
            this.time += p.time;
            this.rainFall += p.rainFall;
        }
        double getResult(){
            return this.rainFall/this.time;
        }
    }
    
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        ArrayList<TramDo> ds = new ArrayList<>();
        while(t-->0){
            sc.nextLine();
            TramDo tmp = new TramDo(sc.nextLine(),sc.next(),sc.next(),sc.nextInt());
            int check = 0;
            for(int i = 0;i<ds.size();i++){
                if(ds.get(i).name.equals(tmp.name)){
                    check = 1;
                    ds.get(i).update(tmp);
                    break;
                }
            }
            if(check == 0){
                tmp.id = TramDo.getId(stt++);
                ds.add(tmp);
            }
        }
        for(TramDo tmp : ds){
            System.out.printf("%s %s %.2f\n",tmp.id,tmp.name,tmp.getResult());
        }
    }
}
