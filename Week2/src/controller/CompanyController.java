package controller;

import model.Company;
import model.Text;

import java.util.Scanner;

public class CompanyController {
    public static Company setInforCompany(Scanner input) {
        Text.textGetInfor();
        Text.printOut("Add name company:");
        String name = input.nextLine();
        Text.printOut("Add tax code:");
        String taxCode = input.nextLine();
        Text.printOut("Add month revenue:");
        double monthRevenue = input.nextDouble();
        return new Company(name, taxCode, monthRevenue);
    }
}
