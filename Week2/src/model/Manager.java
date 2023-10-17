package model;

import java.util.ArrayList;

public class Manager extends Staff {
    private static final double SALARY_PER_WORKING_DAY = 200.0;
    private ArrayList<Employee> underControl = new ArrayList<>();//Nhân viên dưới quyền

    public Manager(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    public ArrayList<Employee> getStaff() {
        return underControl;
    }

    public void setStaff(Employee staff) {
        this.underControl.add(staff);
    }

    public void clear() {
        this.underControl.clear();
    }

    @Override
    public String getDuty() {
        return "Manager";
    }

    @Override
    public void delete(Employee employee) {
        Employee employee1 = isExit(employee);
        if (employee1 != null) {
            this.underControl.remove(employee);
        }
    }

    public Employee isExit(Employee employee) {
        if (!this.underControl.isEmpty()) {
            for (var read :
                    underControl) {
                if (read.equals(employee)) {
                    return read;
                }
            }
        }
        return null;
    }

    @Override
    public void calculateSalary() {
        if (super.getDayWork() > 0) {
            double bonus = 100 * underControl.size();
            super.setTotalSalary(SALARY_PER_WORKING_DAY * super.getDayWork() + bonus);
        }
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Manager) {
            Manager manager = (Manager) obj;
            if (this.getIdString().equals((manager.getIdString())) && this.getName().equals(manager.getName())
                    && this.getDayWork() == manager.getDayWork()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String showSalaryStaffs() {
        return super.showSalaryStaffs();
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + super.getIdString() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", dayWork='" + super.getDayWork() + '\'' +
                ", duty='" + this.getDuty() + '\'' +
                ", underControll='" + this.underControl.size() + '\'' +
                ", salary='" + getTotalSalary() + '\'' +
                '}';
    }
}
