package model;

public class Text {
    public static void textMenu() {
        printOut("==================== Functions: =====================");//Vui lòng chọn chức năng
        printOut("= 1.Add company information                           =");//Nhập thông tin công ty
        printOut("= 2.Add,Repair,Delete personal information...         =");//Thêm sửa xóa
        printOut("= 0.Exit                                              =");
        stringLine();
        textChoice();
    }

    public static void printOut(String str) {
        System.out.println(str);
    }

    public static void stringLine() {
        System.out.println("=====================================================");
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

    public static void textInputError(){
        System.out.println("========> Invalid input <=========");
    }
}
