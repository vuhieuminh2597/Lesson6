package model;

public class Staff extends Employee implements Calculable {
    private static final double SALARY_PER_WORKING_DAY = 100.0;
    private double totalSalary;

    public Staff(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    public void setTotalSalary(double salary) {
        this.totalSalary = salary;
    }

    public double getTotalSalary() {
        return this.totalSalary;
    }

    @Override
    public String getDuty() {
        return "Staff";
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
                ", dayWork=" + super.getDayWork() +
                ", duty=" + this.getDuty() +
                '}';
    }
}
