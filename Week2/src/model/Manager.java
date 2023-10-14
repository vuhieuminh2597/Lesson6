package model;

import java.util.ArrayList;

public class Manager extends Staff {
    private ArrayList<Staff> staff = new ArrayList<>();
    public Manager(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    @Override
    public String getduty() {
        return "Manager";
    }

    @Override
    public void calculateSalary() {
    }

}
