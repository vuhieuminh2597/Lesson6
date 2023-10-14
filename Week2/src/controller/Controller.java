package controller;

import model.Company;
import model.Manager;
import model.Staff;
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
                    if (company != null) {
                        companyList.add(company);
                        Text.printOut(company.toString());
                        Text.textSuccess();
                    } else {
                        Text.textFail();
                    }
                    break;
                case 2:
                    break;
                default:
                    Text.textInputError();
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
        double monthRevenue = checkInputDouble(input);
        if (monthRevenue < 0) {
            monthRevenue = 0;
        }
        return new Company(name, taxCode, monthRevenue);
    }

    public Staff setStaff(Scanner input) {
        Text.textGetInfor();
        Text.printOut("Add id:");
        String id = input.nextLine();
        Text.printOut("Add name:");
        String name = input.nextLine();
        Text.printOut("Add phone number:");
        String phoneNumber = input.nextLine();
        Text.printOut("Add day work in a month:");
        int dayWork = checkInputInteger(input);
        if (dayWork < 0) {
            dayWork = 0;
        }
        return new Staff(id, name, phoneNumber, dayWork);
    }

    public Manager setManager(Scanner input){
        Text.textGetInfor();

        return null;
    }

    public double checkInputDouble(Scanner input) {
        double number = 0;
        while (!input.hasNextInt()) {
            System.out.println("That's not a integer number,retry!");
            input.next();
        }
        return number = input.nextDouble();
    }

    public int checkInputInteger(Scanner input) {
        int number = 0;
        while (!input.hasNextInt()) {
            System.out.println("That's not a integer number,retry!");
            input.next();
        }
        return number = input.nextInt();
    }
}
