package controller;

import model.*;
import model.database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Company companyModel;
    private List<Employee> employees = new ArrayList<>();

    public Controller() {
        companyModel = null;
        List<Staff> staffList = new ArrayList<>(DataBase.dataEmployees());
        List<Manager> managerList = new ArrayList<>(DataBase.dataManager());
        List<Director> directorList = new ArrayList<>(DataBase.dataDirector());
        addAllEmployee(staffList, managerList, directorList, employees);
    }

    public void choiceFunction() {
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            Text.textMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    Text.printOut("GoodBye!......See you again!");
                    break;
                case 1:
                    var rsCompany = setInforCompany(input);
                    if (rsCompany != null) {
                        companyModel = rsCompany;
                        if (!employees.isEmpty()) {
                            companyModel.setEmployeeList(employees);
                        }
                        Text.printOut(companyModel.toString());
                        Text.textSuccess();
                    } else {
                        Text.textFail();
                    }
                    break;
                case 2:
                    if (companyModel != null) {
                        var staff = setStaff(input);
                        if (staff != null) {
                            if (companyModel.addStaff(staff)) {
                                Text.textSuccess();
                            } else {
                                Text.printOut("Đối tượng đã tồn tại không thể tạo mới!");
                            }
                        } else {
                            Text.textFail();
                        }
                    } else {
                        Text.printOut("Hãy nhập thông tin công ty trước.");
                    }
                    break;
                case 3:
                    if (companyModel != null) {
                        var manager = setManager(input);
                        if (manager != null) {
                            if (companyModel.addManager(manager)) {
                                Text.textSuccess();
                            } else {
                                Text.printOut("Đối tượng đã tồn tại không thể tạo mới!");
                            }
                        } else {
                            Text.textFail();
                        }
                    } else {
                        Text.printOut("Hãy nhập thông tin công ty trước.");
                    }

                    break;
                case 4:
                    if (companyModel != null) {
                        var director = setDirector(input);
                        if (director != null) {
                            if (companyModel.addDirector(director)) {
                                Text.textSuccess();
                            } else {
                                Text.printOut("Đối tượng đã tồn tại không thể tạo mới!");
                            }
                        } else {
                            Text.textFail();
                        }
                    } else {
                        Text.printOut("Hãy nhập thông tin công ty trước.");
                    }

                    break;
                case 5:
                    if (companyModel != null) {
                        Text.printOut("Nhập ID nhân viên để thêm:");
                        var idStaff = input.nextLine();
                        var resultStaff = checkIdStaff(companyModel.getEmployeeList(), idStaff);
                        if (resultStaff != null) {
                            Text.printOut("Nhập ID trưởng phòng:");
                            var idManager = input.nextLine();
                            var resultManager = checkIdManager(companyModel.getEmployeeList(), idManager);
                            if (resultManager != null) {
                                if (addStaffFromManager(companyModel.getEmployeeList(), resultStaff, resultManager)) {
                                    resultStaff.setSuperior(resultManager);
                                    Text.textSuccess();
                                } else {
                                    Text.textFail();
                                }
                            } else {
                                Text.printOut("ID trưởng phòng không đúng hoặc không tồn tại!");
                            }
                        } else {
                            Text.printOut("ID nhân viên không đúng hoặc không tồn tại!");
                        }
                    } else {
                        Text.printOut("Hãy nhập thông tin công ty trước.");
                    }
                    break;
                case 6:
                    if (companyModel != null) {
                        Text.printOut("Vui Lòng nhập số id nhân sự để xóa:");
                        var inputId = input.nextLine();
                        if (companyModel.deletePersonnel(inputId)) {
                            Text.textSuccess();
                        } else {
                            Text.printOut("ID không đúng hoặc không tồn tại!");
                        }
                        companyModel.deletePersonnel(inputId);
                    } else {
                        Text.printOut("Công ty không tồn tại.");
                    }
                    break;
                case 7:
                    if (companyModel != null) {
                        showAllEmp();
                    } else {
                        Text.printOut("Công ty không tồn tại.");
                    }
                    break;
                default:
                    Text.textInputError();
                    break;
            }
        } while (choice != 0);
    }

    public Company setInforCompany(Scanner input) {
        Text.textGetInfor();
        Text.printOut("Add name company:");
        String name = input.nextLine();
        Text.printOut("Add tax code:");
        String taxCode = input.nextLine();
        Text.printOut("Add month revenue:");
        double monthRevenue = checkInputDouble(input);
        if (monthRevenue < 0) {
            monthRevenue = 0;
        }
        return new Company(name, taxCode, monthRevenue);
    }

    public Staff setStaff(Scanner input) {
        Text.textGetInfor();
        Text.printOut("Add id:");
        String id = input.nextLine();
        Text.printOut("Add name:");
        String name = input.nextLine();
        Text.printOut("Add phone number:");
        String phoneNumber = input.nextLine();
        Text.printOut("Add day work in a month:");
        int dayWork = checkInputInteger(input);
        if (dayWork < 0) {
            dayWork = 0;
        }
        return new Staff(id, name, phoneNumber, dayWork);
    }

    public Manager setManager(Scanner input) {
        Employee emp = setStaff(input);
        return new Manager(emp.getIdString(), emp.getName(), emp.getPhoneNumber(), emp.getDayWork());
    }

    public Director setDirector(Scanner input) {
        Employee emp = setStaff(input);
        Text.printOut("Add owner ship percentage :");
        var percen = input.nextDouble();
        return new Director(emp.getIdString(), emp.getName(), emp.getPhoneNumber(), emp.getDayWork(), percen);
    }

    public int checkInputInteger(Scanner input) {
        int number = 0;
        while (!input.hasNextInt()) {
            System.out.println("That's not a integer number,retry!");
            input.next();
        }
        return number = input.nextInt();
    }

    public double checkInputDouble(Scanner input) {
        double number = 0.0;
        while (!input.hasNextDouble()) {
            Text.printOut("That's not a double number,retry!");
            input.next();
        }
        return number = input.nextDouble();
    }

    public Staff checkIdStaff(List<Employee> emp, String id) {
        if (!emp.isEmpty()) {
            for (var read :
                    emp) {
                if (read.getIdString().equals(id) &&
                        read.getDuty().equals("Staff")) {
                    return (Staff) read;
                }
            }
        }
        return null;
    }

    public Manager checkIdManager(List<Employee> emp, String id) {
        if (!emp.isEmpty()) {
            for (var read :
                    emp) {
                if (read.getIdString().equals(id)
                        && read.getDuty().equals("Manager")) {
                    return (Manager) read;
                }
            }
        }
        return null;
    }

    public boolean addStaffFromManager(List<Employee> managers, Staff staff, Manager manager) {
        if (!managers.isEmpty()) {
            for (var read :
                    managers) {
                if (read.equals(manager) && read.getDuty().equals("Manager")) {
                    Manager man = (Manager) read;
                    man.setStaff(staff);
                    return true;
                }
            }
        }
        return false;
    }

    public void addAllEmployee(List<Staff> staffs, List<Manager> managers, List<Director> directors,
                               List<Employee> employees) {
        if (!staffs.isEmpty()) {
            employees.addAll(staffs);
        }
        if (!managers.isEmpty()) {
            employees.addAll(managers);
        }
        if (!directors.isEmpty()) {
            employees.addAll(directors);
        }
    }
    public void showAllEmp() {
        companyModel.showStaffInCompany();
        companyModel.showManagerInCompany();
        companyModel.showDirectorInCompany();
    }
}
