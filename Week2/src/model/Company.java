package model;

import java.util.ArrayList;

public class Company {
    private String name;
    private String taxCode;
    private double monthRevenue;//Doanh thu tháng
    private ArrayList<Staff> staffs = new ArrayList<>();
    private ArrayList<Manager> managers = new ArrayList<>();
    private ArrayList<SuperManager> superManagers = new ArrayList<>();


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
