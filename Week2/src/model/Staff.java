package model;

public class Staff extends Employee implements Calculable {
    private static final double SALARY_PER_WORKING_DAY = 100.0;
    private double totalSalary;

    public Staff(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    public Staff(String idString, String name, String phoneNumber, int dayWork, double totalSalary) {
        super(idString, name, phoneNumber, dayWork);
        this.totalSalary = totalSalary;
    }

    public void setTotalSalary(double salary) {
        this.totalSalary = salary;
    }

    public double getTotalSalary() {
        return this.totalSalary;
    }

    @Override
    public void calculateSalary() {
        if (this.getDayWork() > 0) {
            this.totalSalary = this.getDayWork() * SALARY_PER_WORKING_DAY;
        }
    }
}
