package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee {
    private String idString;
    private String name;
    private String phoneNumber;
    private int dayWork;

    private List<Manager> superior = new ArrayList<>();//Cấp trên quản lý

    public Employee(String idString, String name, String phoneNumber, int dayWork) {
        this.idString = idString;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dayWork = dayWork;
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

    public void setIdString(String idString) {
        this.idString = idString;
    }

    public String getIdString() {
        return this.idString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setDayWork(int dayWork) {
        this.dayWork = dayWork;
    }

    public int getDayWork() {
        return this.dayWork;
    }

    public abstract String getDuty();

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employee) {
            Employee emp = (Employee) obj;
            if (this.idString.equals(emp.idString) && this.name.equals(emp.name)
                    && this.phoneNumber.equals(emp.phoneNumber)
                    && this.dayWork == emp.dayWork) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + idString + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dayWork=" + dayWork +
                '}';
    }
}
