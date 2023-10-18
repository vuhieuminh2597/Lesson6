package model;

public class Director extends Manager {
    private double ownerShipPercentage;
    private static final double SALARY_PER_WORKING_DAY = 300.0;

    public Director(String idString, String name, String phoneNumber, int dayWork, double ownerShipPercentage) {
        super(idString, name, phoneNumber, dayWork);
        this.ownerShipPercentage = ownerShipPercentage;
    }

    @Override
    public String getDuty() {
        return "Director";
    }

    @Override
    public void calculateSalary() {
        if (super.getDayWork() > 0) {
            super.setTotalSalary(SALARY_PER_WORKING_DAY * super.getDayWork());
        }
    }

    @Override
    public double getTotalSalary() {
        return super.getTotalSalary();
    }

    @Override
    public String showPercen() {
        return "Id:" + super.getIdString() + "   Name:" + super.getName() + "  Percentage:" + ownerShipPercentage
                 + "%";
    }

    @Override
    public String showString(){
        return "Id:" + super.getIdString() + "   Name:" + super.getName() + " Salary:" + super.getTotalSalary();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Director) {
            Director dir = (Director) obj;
            if (this.getIdString().equals(dir.getIdString())
                    && this.getName().equals(dir.getName())
                    && this.getPhoneNumber().equals(dir.getPhoneNumber())
                    && this.getDayWork() == dir.getDayWork()) {
                return true;
            }
        }
        return false;
    }

    @Override
    public double getPercentage() {
        return ownerShipPercentage;
    }

    @Override
    public String showSalaryStaffs() {
        return super.showSalaryStaffs();
    }

    @Override
    public String toString() {
        return "Director{" +
                "id='" + super.getIdString() + '\'' +
                ", name='" + super.getName() + '\'' +
                ", phoneNumber='" + super.getPhoneNumber() + '\'' +
                ", dayWork='" + super.getDayWork() +
                ", duty='" + this.getDuty() + '\'' +
                ", percentage='" + this.ownerShipPercentage + "%" + '\'' +
                ", salary='" + getTotalSalary() + '\'' +
                '}';
    }
}
