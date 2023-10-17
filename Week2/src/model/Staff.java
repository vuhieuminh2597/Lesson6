package model;

import java.util.ArrayList;
import java.util.List;

public class Staff extends Employee implements Calculable {
    private static final double SALARY_PER_WORKING_DAY = 100.0;
    private double totalSalary;

    private List<Manager> superior = new ArrayList<>();//Cấp trên quản lý

    public Staff(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    public void setTotalSalary(double salary) {
        this.totalSalary = salary;
    }

    public double getTotalSalary() {
        return this.totalSalary;
    }

    public void setSuperior(Manager manager) {
        this.superior.add(manager);
    }

    public List<Manager> getSuperior() {
        return this.superior;
    }

    public boolean deleteSuperior(Manager manager) {
        if (manager != null) {
            for (var read :
                    superior) {
                if (read.equals(manager)) {
                    superior.remove(manager);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String getDuty() {
        return "Staff";
    }

    @Override
    public void delete(Employee employee) {
        Employee employee1 = isExit(employee);
        if (employee1 != null) {
            this.superior.remove(employee1);
        }
    }

    public Employee isExit(Employee employee) {
        if (!this.superior.isEmpty()) {
            for (var read :
                    superior) {
                if (read.equals(employee)) {
                    return read;
                }
            }
        }
        return null;
    }

    @Override
    public void calculateSalary() {
        if (this.getDayWork() > 0) {
            this.totalSalary = this.getDayWork() * SALARY_PER_WORKING_DAY;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Staff) {
            Staff staff = (Staff) obj;
            if (this.getIdString().equals((staff.getIdString())) && this.getName().equals(staff.getName())
                    && this.getDayWork() == staff.getDayWork()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id='" + super.getIdString() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", dayWork='" + super.getDayWork() + '\'' +
                ", duty='" + this.getDuty() + '\'' +
                ", superior='" + this.superior.size() + '\'' +
                ", salary='" + this.getTotalSalary() + '\'' +
                '}';
    }
}
