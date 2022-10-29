package KhongCoChuDeCon;


//package danhsachsinhvien1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Houta
 */
public class DanhSachSinhVienTrongFileNhiPhan {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileOutputStream f = new FileOutputStream("SV.in");
        ObjectOutputStream os = new ObjectOutputStream(f);
        ArrayList<SinhVien> a = new ArrayList<>();
        a.add(new SinhVien("Nguyen Van An","D20CQCN01-B","2/12/2002", (float) 3.19));
        a.add(new SinhVien("Nguyen Van Binh","D21CQCN01-B","2/2/2003", (float) 2.18));
        os.writeObject(a);
        os.close();
        FileInputStream FileIS = new FileInputStream("SV.in");
        ObjectInputStream is = new ObjectInputStream(FileIS);
        ArrayList<SinhVien> b = (ArrayList<SinhVien>) is.readObject();
        for(SinhVien tmp:b)
            System.out.println(tmp);
    }
}
class SinhVien{
    String maSV,tenSV,lopSV;
    Date ngaySinh;
    float gpa;
    static int stt=1;
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
    public SinhVien(String tenSV, String lopSV, String ngaySinh, float gpa) {
        this.maSV = "B20DCCN" + String.format("%03d", stt++);
        this.tenSV = tenSV;
        this.lopSV = lopSV;
        try {
            this.ngaySinh = sdf.parse(ngaySinh);
        } catch (ParseException ex) {
            Logger.getLogger(SinhVien.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.gpa = gpa;
    }
    
    @Override
    public String toString(){
        return this.maSV+ ' '+ this.tenSV+ ' '+ this.lopSV+ ' '+ sdf.format(this.ngaySinh)+ String.format("%2f", this.gpa);
    }
}
