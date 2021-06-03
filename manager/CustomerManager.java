package case_study_FuramaResort.manager;

import case_study_FuramaResort.commons.InputAndValidateCustomer;
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
            String name = InputAndValidateCustomer.inputName();
            String birthday = InputAndValidateCustomer.inputBirthday();
            String genderTemp = InputAndValidateCustomer.inputGender();
            String gender = InputAndValidateCustomer.standardizeString(genderTemp);
            String idCard = InputAndValidateCustomer.inputIdCard();
            String phoneNumber = InputAndValidateCustomer.inputPhoneNumber();
            String email = InputAndValidateCustomer.inputEmail();
            String guestType = InputAndValidateCustomer.inputGuestType();
            String address = InputAndValidateCustomer.inputAddress();
            Customer customer = new Customer(name, birthday, gender, idCard, phoneNumber, email, guestType, address);
            listCustomers.clear();
            listCustomers.addAll(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\customer.csv"));
            listCustomers.add(customer);
            ReadAndWriteFile.writeToFile(listCustomers, "src\\case_study_FuramaResort\\data\\customer.csv");

            System.out.println("You don't want to continue. Press q to quit:\n");
            String choiceAdd = input.nextLine();
            if (choiceAdd.equals("q")) {
                check = false;
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
        listCustomers.clear();
        listCustomers.addAll(listCustomerCast);
        ReadAndWriteFile.writeToFile(listCustomers, "src\\case_study_FuramaResort\\data\\customer.csv");
    }

    public static void addNewBooking() {
        showInformationCustomers();
        List<Object> listCustomers = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\customer.csv");
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter a customer: ");
                int choiceCustomer = Integer.parseInt(input.nextLine());
                boolean checkChoiceCustomer = choiceCustomer > 0 && choiceCustomer < listCustomers.size() + 1;
                if (!checkChoiceCustomer) {
                    throw new IndexOutOfBoundsException();
                }
                System.out.println("Choice a service: \n" +
                        "1.\tBooking Villa\n" +
                        "2.\tBooking House\n" +
                        "3.\tBooking Room\n");
                int choiceService = Integer.parseInt(input.nextLine());
                switch (choiceService) {
                    case 1:
                        ServiceManager.showAllVilla();
                        System.out.println("Choice a villa: ");
                        int choiceVilla = Integer.parseInt(input.nextLine());
                        bookingService(listCustomers, choiceCustomer, choiceVilla, "src\\case_study_FuramaResort\\data\\villa.csv");
                        check = false;
                        break;
                    case 2:
                        ServiceManager.showAllHouse();
                        System.out.println("Choice a house: ");
                        int choiceHouse = Integer.parseInt(input.nextLine());
                        bookingService(listCustomers, choiceCustomer, choiceHouse, "src\\case_study_FuramaResort\\data\\house.csv");
                        check = false;
                        break;
                    case 3:
                        ServiceManager.showAllRoom();
                        System.out.println("Choice a room: ");
                        int choiceRoom = Integer.parseInt(input.nextLine());
                        bookingService(listCustomers, choiceCustomer, choiceRoom, "src\\case_study_FuramaResort\\data\\room.csv");
                        check = false;
                        break;
                    default:
                        System.err.println("Not in the Menu. Please choose again !");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Enter the wrong number format. Please re-enter !");
            } catch (Exception e) {
                System.err.println("Not in the Menu. Please choose again !");
            }
        }
    }

    private static void bookingService(List<Object> listCustomers, int choiceCustomer, int choiceService, String path) {
        List<Object> listAllServices = ReadAndWriteFile.readFromFile(path);

        Customer customer = (Customer) listCustomers.get(choiceCustomer - 1);
        Services service = (Services) listAllServices.get(choiceService - 1);
        customer.setServiceUsage(service);
        listCustomers.remove(choiceCustomer - 1);
        listCustomers.add(choiceCustomer - 1, customer);
        ReadAndWriteFile.writeToFile(listCustomers, "src\\case_study_FuramaResort\\data\\customer.csv");

        List<Object> listBookingCustomers = new ArrayList<>(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\booking.csv"));
        listBookingCustomers.add(customer);
        ReadAndWriteFile.writeToFile(listBookingCustomers, "src\\case_study_FuramaResort\\data\\booking.csv");
    }
}
