package model;

public class Text {
    public static void textMenu() {
        printOut("========================= Functions: ===========================");
        printOut("= 1.Nhập thông tin công ty                                     =");
        printOut("= 2.Thêm mới nhân viên.                                        =");
        printOut("= 3.Thêm mới trưởng phòng.                                     =");
        printOut("= 4.Thêm mới giám đốc.                                         =");
        printOut("= 5.Phân bổ nhân viên vào trưởng phòng.                        =");
        printOut("= 6.Xóa nhân sự.                                               =");
        printOut("= 7.Xuất thông tin toàn bộ nhân viên trong cty                 =");
        printOut("= 8.Tính và xuất tổng lương cho toàn công ty.                  =");
        printOut("= 9.Tìm Nhân viên thường có lương cao nhất.                    =");
        printOut("= 10.Sắp xếp nhân viên toàn công ty theo thứ tự lương giảm dần.=");
        printOut("= 11.Trưởng Phòng có số lượng nhân viên dưới quyền nhiều nhất. =");
        printOut("= 12.Giám Đốc có số lượng cổ phần nhiều nhất.                  =");
        printOut("= 13.Tính và xuất thu nhập của từng giám đôc.                  =");
        stringLine();
        textChoice();
    }

    public static void printOut(String str) {
        System.out.println(str);
    }

    public static void stringLine() {
        System.out.println("================================================================");
    }

    public static void textGetInfor() {
        System.out.println("Please add information:");
    }

    public static void textChoice() {
        System.out.println("Please choice functions:");
    }

    public static void textSuccess() {
        System.out.println("==========> Success <===========");
    }

    public static void textFail() {
        System.out.println("==========> Fail <===========");
    }

    public static void textInputError() {
        System.out.println("========> Invalid input <=========");
    }
}
