package controller;

import model.*;
import model.database.DataBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public Controller() {
    }

    public void choiceFunction() {
        Company companyModel = null;
        List<Staff> staffList = new ArrayList<>(DataBase.dataEmployees());
        List<Manager> managerList = new ArrayList<>(DataBase.dataManager());
        List<Director> directorList = new ArrayList<>(DataBase.dataDirector());
        List<Employee> employees = new ArrayList<>();
        addAllEmployee(staffList, managerList, directorList, employees);
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
                        if (!employees.isEmpty()){
                            companyModel.setEmployeeList(employees);
                        }
                        Text.printOut(companyModel.toString());
                        Text.textSuccess();
                    } else {
                        Text.textFail();
                    }
                    break;
                case 2:
                    var staff = setStaff(input);
                    if (staff != null) {
                        staffList.add(staff);
                        Text.printOut(staff.toString());
                        Text.textSuccess();
                    } else {
                        Text.textFail();
                    }
                    break;
                case 3:
                    var manager = setManager(input);
                    if (manager != null) {
                        managerList.add(manager);
                        Text.printOut(manager.toString());
                        Text.textSuccess();
                    } else {
                        Text.textFail();
                    }
                    break;
                case 4:
                    var director = setDirector(input);
                    if (director != null) {
                        directorList.add(director);
                        Text.printOut(director.toString());
                        Text.textSuccess();
                    } else {
                        Text.textFail();
                    }
                    break;
                case 5:
                    showListStaff(staffList);
                    showListManager(managerList);
                    Text.printOut("Nhập ID nhân viên để thêm:");
                    var idStaff = input.nextLine();
                    var resultStaff = checkIdStaff(staffList, idStaff);
                    if (resultStaff != null) {
                        Text.printOut("Nhập ID trưởng phòng:");
                        var idManager = input.nextLine();
                        var resultManager = checkIdManager(managerList, idManager);
                        if (resultManager != null) {
                            if (addStaffFromManager(managerList, resultStaff, resultManager)) {
                                resultStaff.setSuperior(resultManager);
//                                Text.printOut(resultManager.getStaff().toString());
//                                Text.printOut(resultStaff.getSuperior().toString());
                                Text.textSuccess();
                            } else {
                                Text.textFail();
                            }
                        } else {
                            Text.printOut("ID trưởng phòng không đúng hoặc không tồn tại!");
                        }
                    } else {
                        Text.printOut("ID viên không đúng hoặc không tồn tại!");
                    }
                    break;
                case 6:
                    ///Xoá nhân sự.
                    break;
                case 7:
                    if(companyModel != null){
                        companyModel.getEmployeesList();
                    }else {
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
        return new Director(emp.getIdString(), emp.getName(), emp.getPhoneNumber(), emp.getDayWork());
    }

    public double checkInputDouble(Scanner input) {
        double number = 0;
        while (!input.hasNextInt()) {
            System.out.println("That's not a integer number,retry!");
            input.next();
        }
        return number = input.nextDouble();
    }

    public int checkInputInteger(Scanner input) {
        int number = 0;
        while (!input.hasNextInt()) {
            System.out.println("That's not a integer number,retry!");
            input.next();
        }
        return number = input.nextInt();
    }

    public void showListStaff(List<Staff> employees) {
        System.out.println("Danh sách nhân viên:");
        for (var emp :
                employees) {
            System.out.println(emp.toString());
        }
        System.out.println();
    }

    public void showListManager(List<Manager> managers) {
        System.out.println("Danh sách trưởng phòng:");
        for (var man :
                managers) {
            System.out.println(man.toString());
        }
        System.out.println();
    }

    public Staff checkIdStaff(List<Staff> emp, String id) {
        if (!emp.isEmpty()) {
            for (var read :
                    emp) {
                if (read.getIdString().equals(id)) {
                    return read;
                }
            }
        }
        return null;
    }

    public Manager checkIdManager(List<Manager> managers, String id) {
        if (!managers.isEmpty()) {
            for (var read :
                    managers) {
                if (read.getIdString().equals(id)) {
                    return read;
                }
            }
        }
        return null;
    }

    public boolean addStaffFromManager(List<Manager> managers, Staff staff, Manager manager) {
        if (!managers.isEmpty()) {
            for (var read :
                    managers) {
                if (read.equals(manager)) {
                    read.setStaff(staff);
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
}
