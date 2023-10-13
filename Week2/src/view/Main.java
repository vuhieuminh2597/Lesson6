package view;

import model.Company;
import model.SuperManager;

public class Main {
    public static void main(String[] args) {
        SuperManager manager = new SuperManager();
        Company company = new Company();
        System.out.println(manager.toString());
        System.out.println(manager.toString());
    }
}
