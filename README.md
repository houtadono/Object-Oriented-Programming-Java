# java_oop_code-ptit
<h4>Code WA : Unedited </h4>
<ul> 
<li> .....</li>
</ul> 

<h4>How to read commit: (day 1: 22/08/2022) (last commit: day 25: 15/09/2022)</h4>
<ul> 
<li>-day x: the date the code was committed and code is definitely correct for the test suite, maybe not AC</li>
<li>-update code AC day x: old code is wrong and fixed some parts, sure AC</li>
<li>-Optimize code day x: old code may be correct but not optimized and fixed in a more optimal way, sure AC</li>
</ul>

<h4>Lưu ý:(Cách đọc git):></h4>
<ul> 
<li> Mỗi folder bên trên (tên Chủ đề con Code.ptit) là một package đều thuộc 1 Source Package trong cùng 1 Project Java</li>
<li> Mỗi bài là 1 file .java </li>
<li> Những commit ngày đầu trông đần hơn=))</li>
</ul>

<h4>Lưu ý:(Khi code😢)</h4>
<ul> 
<li> Tên file phải chuẩn theo yêu cầu đề bài (ex: "Data.in" != "DATA.in" ) dù IDE vẫn tìm thấy file nhưng code.ptit thì không :v</li>
<li> Khởi tạo 1 đối tượng nên nhập từ Scanner (ex: public SinhVien(Scanner sc){ } )</li>
<li> Khi tạo String mã đối tượng(ex: mã SV: B20DCAT010), nên dùng String.format (ex: "B20DCAT"+String.format("%03d",stt) )</li>
<li> Khi tạo ngày, nên sài Date(ex: Trong class SinhVien, dùng Date birthday) 
      <br>nếu cần chuẩn hóa: new SimpleDateFormat("dd/MM/yyyy").parse(yourString)
      <br>và cần in ra thì: new SimpleDateFormat("dd/MM/yyyy").format(this.birthday)</li>
<li> Khi in 1 đối tượng, nên tạo phương thức toString và return String.format("%s %s %d %.1f ....",this.,..)</li>
<li> Trong thực tế, nên làm 1 bài trong 1 package, và trong đó gồm nhiều file java class khác nhau,
    <br>làm kiểu này sẽ thực tế hơn với hướng đối tượng, nhưng khi nộp thì cần nén package thành file zip và nộp lên, nên khá mất thời gian.
    <br>Ở đây mình ghi hết các class vào 1 file có main:> cho dễ nộp bài</li>
<li> More</li>
</ul>