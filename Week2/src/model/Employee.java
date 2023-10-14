package model;

public abstract class Employee {
    private String idString;
    private String name;
    private String phoneNumber;
    private int dayWork;

    public Employee(String idString, String name, String phoneNumber, int dayWork) {
        this.idString = idString;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.dayWork = dayWork;
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

    public abstract String getduty();

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
                "idString='" + idString + '\'' +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", dayWork=" + dayWork +
                '}';
    }
}
