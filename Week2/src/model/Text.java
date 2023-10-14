package model;

public class Text {
    public static void textMenu() {
        printOut("==============> Please choice functions:<==============");//Vui lòng chọn chức năng
        printOut("= 1.Add company information                           =");//Nhập thông tin công ty
        printOut("= 2.Staff allocation                                  =");//Phân bổ nhân viên lên trưởng phòng
        printOut("= 3.Manager allocation                                =");//Phân bổ trưởng phòng lên giám đốc
        printOut("= 4.Add,Repair,Delete                                 =");//Thêm sửa xóa
        printOut("= 5.Show employees in company                         =");//Hiển thị nhân viên toàn công ty
        printOut("= 6.Calculate and show all salary                     =");//Tính và hiển thị toàn bộ lương
        printOut("= 7.Staffs hightest salary                            =");//Tìm nhân viên có lương cao nhất
        printOut("= 8.Manager have many subordinates                    =");//Tìm quản lý có nhiều cấp dưới
        printOut("= 9.Sort employees by decrease salary                 =");//Sắp xếp theo lương giảm
        printOut("= 10.SuperManager has most shares                     =");//Giám đốc có cổ phần nhiều nhất
        printOut("= 11.Calculate and show total salary of SuperManagers =");//Tính và hiển thị lương giám đốc
        stringLine();
    }

    public static void printOut(String str) {
        System.out.println(str);
    }

    public static void stringLine() {
        System.out.println("=====================================================");
    }
    public static void textGetInfor(){
        System.out.println("Vui lòng nhập các thông tin sau:");
    }
}
