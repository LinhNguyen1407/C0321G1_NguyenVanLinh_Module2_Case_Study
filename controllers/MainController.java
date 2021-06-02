package case_study_FuramaResort.controllers;

import case_study_FuramaResort.manager.*;
import java.util.Scanner;

public class MainController {
    public static void displayMainMenu () {
        while (true) {
            try {
                System.out.println("Menu: \n" +
                        "1.\tAdd New Services\n" +
                        "2.\tShow Services\n" +
                        "3.\tAdd New Customer\n" +
                        "4.\tShow Information of Customer\n" +
                        "5.\tAdd New Booking\n" +
                        "6.\tAdd New Employee\n" +
                        "7.\tShow Information of Employee\n" +
                        "8.\tSell Movie Ticket and Show Information of All Tickets\n" +
                        "9.\tExit\n");

                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        ServiceManager.addNewServices();
                        break;
                    case 2:
                        ServiceManager.showServices();
                        break;
                    case 3:
                        CustomerManager.addNewCustomer();
                        break;
                    case 4:
                        CustomerManager.showInformationCustomers();
                        break;
                    case 5:
                        CustomerManager.addNewBooking();
                        break;
                    case 6:
                        EmployeeManager.addNewEmployee();
                        break;
                    case 7:
                        EmployeeManager.showInformationEmployee();
                        break;
                    case 8:
                        CinameManager.sellTicket();
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Not in the Menu. Please choose again");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Enter the wrong number format. Please re-enter !");
            }
        }
    }
}
