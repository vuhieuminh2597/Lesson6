package model;

import java.util.ArrayList;

public class Manager extends Staff {
    private ArrayList<Staff> staff = new ArrayList<>();

    public Manager(String idString, String name, String phoneNumber, int dayWork) {
        super(idString, name, phoneNumber, dayWork);
    }

    public Manager(String idString, String name, String phoneNumber, int dayWork, double totalSalary) {
        super(idString, name, phoneNumber, dayWork, totalSalary);

    }

    @Override
    public void calculateSalary() {
    }

}
