package model;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private String name;
    private String taxCode;
    private double monthRevenue;//Doanh thu tháng
    private List<Employee> employeeList = new ArrayList<>();

    public Company() {
    }

    public Company(String name, String taxCode, double monthRevenue) {
        this.name = name;
        this.taxCode = taxCode;
        this.monthRevenue = monthRevenue;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTaxCode(String taxCode) {
        this.taxCode = taxCode;
    }

    public String getTaxCode() {
        return this.taxCode;
    }

    public void setMonthRevenue(double monthRevenue) {
        this.monthRevenue = monthRevenue;
    }

    public double getMonthRevenue() {
        return this.monthRevenue;
    }

    public void setEmployeeList(List<Employee> employees) {
        this.employeeList.addAll(employees);
    }

    public List<Employee> getEmployeeList() {
        return this.employeeList;
    }

    public void showStaffInCompany() {
        if (!this.employeeList.isEmpty()) {
            System.out.println("Nhân viên:");
            for (var read :
                    this.employeeList) {
                if (read.getDuty().equals("Staff")) {
                    System.out.println(read.toString());
                }
            }
            System.out.println();
        }
    }

    public void showManagerInCompany() {
        if (!this.employeeList.isEmpty()) {
            System.out.println("Trưởng phòng:");
            for (var read :
                    this.employeeList) {
                if (read.getDuty().equals("Manager")) {
                    System.out.println(read.toString());
                }
            }
            System.out.println();
        }
    }

    public void showDirectorInCompany() {
        if (!this.employeeList.isEmpty()) {
            System.out.println("Giám đốc:");
            for (var read :
                    this.employeeList) {
                if (read.getDuty().equals("Director")) {
                    System.out.println(read.toString());
                }
            }
        }
    }

    public boolean deletePersonnel(String id) {
        Employee emp = isExit1(id);
        if (emp != null) {
            update(emp);
            this.employeeList.remove(emp);
            return true;
        }
        return false;
    }

    public void update(Employee employee) {
        if (!this.employeeList.isEmpty()) {
            for (var read :
                    employeeList) {
                read.delete(employee);
            }
        }
    }

    public boolean addStaff(Staff staff) {
        if (staff != null) {
            if (!isExit(staff.getIdString())) {
                this.employeeList.add(staff);
                return true;
            }
        }
        return false;
    }

    public boolean addManager(Manager manager) {
        if (manager != null) {
            if (!isExit(manager.getIdString())) {
                this.employeeList.add(manager);
                return true;
            }

        }
        return false;
    }

    public boolean addDirector(Director director) {
        if (director != null) {
            if (!isExit(director.getIdString())) {
                this.employeeList.add(director);
                return true;
            }
        }
        return false;
    }

    public Employee isExit1(String id) {
        for (var read :
                this.employeeList) {
            if (read.getIdString().equals(id)) {
                return read;
            }
        }
        return null;
    }

    public Employee isExit() {
        for (var read :
                this.employeeList) {
            if (read.getDuty().equals("Staff")) {
                return read;
            }
        }
        return null;
    }

    public boolean isExit(String id) {
        for (var read :
                this.employeeList) {
            if (read.getIdString().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void findSalary() {
        
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Company) {
            Company c = (Company) obj;
            if (this.name.equals(c.name) && this.taxCode.equals(c.taxCode)
                    && this.monthRevenue == ((Company) obj).monthRevenue) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", taxCode='" + taxCode + '\'' +
                ", monthRevenue=" + monthRevenue +
                '}';
    }

}
