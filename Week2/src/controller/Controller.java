package controller;

import model.Company;
import model.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public Controller() {
    }

    public void choiceFunction() {
        List<Company> companyList = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int choice = 0;
        do {
            Text.textMenu();
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 1:
                   var company = setInforCompany(input);
                   if (company != null){
                       companyList.add(company);
                       Text.textSuccess();
                   }else {
                       Text.textFail();
                   }
                   break;
            }
        } while (choice != 0);
    }

    public Company setInforCompany(Scanner input) {
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
