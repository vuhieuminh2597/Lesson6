package model.database;

import model.Staff;
import java.util.ArrayList;

public class DataBase {
    public ArrayList<Staff> dataEmployees(){
        ArrayList<Staff> employeeList = new ArrayList<>();
        employeeList.add(new Staff("1","Vũ Minh Hiếu","0123456789",27));
        employeeList.add(new Staff("2","Phạm Văn Tuyến","0125465328",22));
        employeeList.add(new Staff("3","Nguyễn Xuân Hoàng","01235648976",24));
        employeeList.add(new Staff("4","Nguyễn Bá Nam","0123756739",26));
        employeeList.add(new Staff("5","Đinh Văn Công","01233333333",21));
        employeeList.add(new Staff("6","Huỳnh Văn Hiếu","01234444444",28));
        employeeList.add(new Staff("7","Nguyễn Anh Phi","01345555555",20));
        employeeList.add(new Staff("8","Hồ Ngọc Phương","012345454",23));
        employeeList.add(new Staff("9","Lê Doãn Hiếu","01112456789",23));
        employeeList.add(new Staff("10","Nguyễn Bá Phượng","01234554545",22));
        return employeeList;
    }
}