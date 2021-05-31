package case_study_FuramaResort.manager;

import case_study_FuramaResort.commons.ReadAndWriteFile;
import case_study_FuramaResort.models.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CustomerManager {
    public static void addNewCustomer() {
        List<Object> listCustomers = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter name: ");
                String name = input.nextLine();
                System.out.println("Enter birthday: ");
                String birthday = input.nextLine();
                System.out.println("Enter gender: ");
                String gender = input.nextLine();
                System.out.println("Enter idCard: ");
                String idCard = input.nextLine();
                System.out.println("Enter phoneNumber: ");
                String phoneNumber = input.nextLine();
                System.out.println("Enter email: ");
                String email = input.nextLine();
                System.out.println("Enter guestType: ");
                String guestType = input.nextLine();
                System.out.println("Enter address: ");
                String address = input.nextLine();

                Customer customer = new Customer(name, birthday, gender, idCard, phoneNumber, email, guestType, address);
                listCustomers.clear();
                listCustomers.addAll(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\customer.csv"));
                listCustomers.add(customer);
                ReadAndWriteFile.writeToFile(listCustomers, "src\\case_study_FuramaResort\\data\\customer.csv");
                System.out.println("Do you like to continue adding Customers: \n" +
                        "1.Yes\n" +
                        "0.No");
                int choiceAdd = Integer.parseInt(input.nextLine());
                if (choiceAdd == 0) {
                    check = false;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void showInformationCustomers() {
        List<Object> listCustomers = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\customer.csv");
        List<Customer> listCustomerCast = new ArrayList<>();
        for (Object customer : listCustomers) {
            Customer customerCast = (Customer) customer;
            listCustomerCast.add(customerCast);
        }
        Collections.sort(listCustomerCast);
        System.out.println("List all customer");
        for (int index = 0; index < listCustomerCast.size(); index++) {
            System.out.println(index + 1 + ". " + listCustomerCast.get(index));
        }
    }

    public static void addNewBooking() {
        showInformationCustomers();
        List<Object> listCustomers = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\customer.csv");
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a customer: ");
        int choiceCustomer = Integer.parseInt(input.nextLine());
        System.out.println("Choice a service: \n" +
                "1.\tBooking Villa\n" +
                "2.\tBooking House\n" +
                "3.\tBooking Room\n");
        int choiceService = Integer.parseInt(input.nextLine());
        switch (choiceService) {
            case 1:
                bookingVilla(listCustomers, choiceCustomer);
                break;
            case 2:
                ServiceManager.showAllHouse();
                break;
            case 3:
                ServiceManager.showAllRoom();
                break;
            default:
                System.err.println("Not in the Menu. Please choose again !");
        }
    }

    private static void bookingVilla(List<Object> listCustomers, int choiceCustomer) {
        List<Object> listBookingCustomers = new ArrayList<>();
        ServiceManager.showAllVilla();

        Scanner input = new Scanner(System.in);
        System.out.println("Choice a villa: ");
        int choiceVilla = Integer.parseInt(input.nextLine());

        List<Object> listAllVillas = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\villa.csv");
        Customer customer = (Customer) listCustomers.get(choiceCustomer-1);
        Villa villa = (Villa) listAllVillas.get(choiceVilla-1);
        customer.setServiceUsage(villa);
        listCustomers.remove(choiceCustomer-1);
        listCustomers.add(choiceCustomer-1, customer);
        listBookingCustomers.add(customer);
        ReadAndWriteFile.writeToFile(listCustomers, "src\\case_study_FuramaResort\\data\\customer.csv");
        ReadAndWriteFile.writeToFile(listBookingCustomers, "src\\case_study_FuramaResort\\data\\booking.csv");
    }
}
