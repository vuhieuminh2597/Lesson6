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
