package case_study_FuramaResort.manager;

import case_study_FuramaResort.commons.ReadAndWriteFile;
import case_study_FuramaResort.models.*;
import case_study_FuramaResort.controllers.MainController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class ServiceManager {
    public static void addNewServices() {
        while (true) {
            try {
                System.out.println("Menu of new service: \n" +
                        "1.\tAdd New Villa\n" +
                        "2.\tAdd New House\n" +
                        "3.\tAdd New Room\n" +
                        "4.\tBack to menu\n" +
                        "5.\tExit\n");

                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        addNewVilla();
                        break;
                    case 2:
                        addNewHouse();
                        break;
                    case 3:
                        addNewRoom();
                        break;
                    case 4:
                        MainController.displayMainMenu();
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Not in the menu. Please choose again !");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Enter the wrong number format. Please re-enter !");
            }
        }
    }

    public static void showServices() {
        while (true) {
            try {
                System.out.println("Menu of show service:\n" +
                        "1.\tShow all Villa\n" +
                        "2.\tShow all House\n" +
                        "3.\tShow all Room\n" +
                        "4.\tShow All Name Villa Not Duplicate\n" +
                        "5.\tShow All Name House Not Duplicate\n" +
                        "6.\tShow All Name Name Not Duplicate\n" +
                        "7.\tBack to menu\n" +
                        "8.\tExit\n");
                Scanner input = new Scanner(System.in);
                int choice = Integer.parseInt(input.nextLine());
                switch (choice) {
                    case 1:
                        showAllVilla();
                        break;
                    case 2:
                        showAllHouse();
                        break;
                    case 3:
                        showAllRoom();
                        break;
                    case 4:
                        showAllVillaNotDuplicate();
                        break;
                    case 5:
                        showAllHouseNotDuplicate();
                        break;
                    case 6:
                        showAllRoomNotDuplicate();
                        break;
                    case 7:
                        MainController.displayMainMenu();
                        break;
                    case 8:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Not in the menu. Please choose again !");
                }
            } catch (NumberFormatException ex) {
                System.err.println("Enter the wrong number format. Please re-enter !");
            }
        }
    }

    private static void addNewVilla() {
        List<Object> listVillas = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter codeService: ");
                String codeService = input.nextLine();
                System.out.println("Enter serviceName: ");
                String serviceName = input.nextLine();
                System.out.println("Enter usableArea: ");
                double usableArea = Double.parseDouble(input.nextLine());
                System.out.println("Enter rentalCosts: ");
                double rentalCosts = Double.parseDouble(input.nextLine());
                System.out.println("Enter maxNumberPeople: ");
                int maxNumberPeople = Integer.parseInt(input.nextLine());
                System.out.println("Enter rentalType: ");
                String rentalType = input.nextLine();
                System.out.println("Enter roomStandard: ");
                String roomStandard = input.nextLine();
                System.out.println("Enter poolArea: ");
                double poolArea = Double.parseDouble(input.nextLine());
                System.out.println("Enter numFloors: ");
                int numFloors = Integer.parseInt(input.nextLine());

                Villa villa = new Villa(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType, roomStandard, poolArea, numFloors);
                listVillas.clear();
                listVillas.addAll(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\villa.csv"));
                listVillas.add(villa);
                ReadAndWriteFile.writeToFile(listVillas, "src\\case_study_FuramaResort\\data\\villa.csv");

                System.out.println("You don't want to continue. Press q to quit:\n");
                String choiceAdd = input.nextLine();
                if (choiceAdd.equals("q")) {
                    check = false;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void showAllVilla() {
        List<Object> listAllVillas = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\villa.csv");
        System.out.println("List all villas");
        for (int index = 0; index < listAllVillas.size(); index++) {
            System.out.println(index + 1 + ". " + listAllVillas.get(index));
        }
    }

    private static void showAllVillaNotDuplicate() {
        List<Object> listAllVillas = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\villa.csv");
        TreeSet<String> listVillaNames = new TreeSet<>();
        for (Object villa : listAllVillas) {
            Villa villaCast = (Villa) villa;
            listVillaNames.add(villaCast.getServiceName());
        }
        System.out.println("List all Villa not dupplicate: " + listVillaNames + "\n");
    }

    private static void addNewHouse() {
        List<Object> listHouse = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter codeService: ");
                String codeService = input.nextLine();
                System.out.println("Enter serviceName: ");
                String serviceName = input.nextLine();
                System.out.println("Enter usableArea: ");
                double usableArea = Double.parseDouble(input.nextLine());
                System.out.println("Enter rentalCosts: ");
                double rentalCosts = Double.parseDouble(input.nextLine());
                System.out.println("Enter maxNumberPeople: ");
                int maxNumberPeople = Integer.parseInt(input.nextLine());
                System.out.println("Enter rentalType: ");
                String rentalType = input.nextLine();
                System.out.println("Enter roomStandard: ");
                String roomStandard = input.nextLine();
                System.out.println("Enter numFloors: ");
                int numFloors = Integer.parseInt(input.nextLine());

                House house = new House(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType, roomStandard, numFloors);
                listHouse.clear();
                listHouse.addAll(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\house.csv"));
                listHouse.add(house);
                ReadAndWriteFile.writeToFile(listHouse, "src\\case_study_FuramaResort\\data\\house.csv");

                System.out.println("You don't want to continue. Press q to quit:\n");
                String choiceAdd = input.nextLine();
                if (choiceAdd.equals("q")) {
                    check = false;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void showAllHouse() {
        List<Object> listAllHouses = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\house.csv");
        System.out.println("List all houses");
        for (int index = 0; index < listAllHouses.size(); index++) {
            System.out.println(index + 1 + ". " + listAllHouses.get(index));
        }
    }

    private static void showAllHouseNotDuplicate() {
        List<Object> listAllHouses = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\house.csv");
        TreeSet<String> listHouseNames = new TreeSet<>();
        for (Object house : listAllHouses) {
            House houseCast = (House) house;
            listHouseNames.add(houseCast.getServiceName());
        }
        System.out.println("List all Houses not dupplicate: " + listHouseNames + "\n");
    }

    private static void addNewRoom() {
        List<Object> listRoom = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter codeService: ");
                String codeService = input.nextLine();
                System.out.println("Enter serviceName: ");
                String serviceName = input.nextLine();
                System.out.println("Enter usableArea: ");
                double usableArea = Double.parseDouble(input.nextLine());
                System.out.println("Enter rentalCosts: ");
                double rentalCosts = Double.parseDouble(input.nextLine());
                System.out.println("Enter maxNumberPeople: ");
                int maxNumberPeople = Integer.parseInt(input.nextLine());
                System.out.println("Enter rentalType: ");
                String rentalType = input.nextLine();
                System.out.println("Enter freeServices: ");
                String freeServices = input.nextLine();

                Room room = new Room(codeService, serviceName, usableArea, rentalCosts, maxNumberPeople, rentalType, freeServices);
                listRoom.clear();
                listRoom.addAll(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\room.csv"));
                listRoom.add(room);
                ReadAndWriteFile.writeToFile(listRoom, "src\\case_study_FuramaResort\\data\\room.csv");

                System.out.println("You don't want to continue. Press q to quit:\n");
                String choiceAdd = input.nextLine();
                if (choiceAdd.equals("q")) {
                    check = false;
                }
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void showAllRoom() {
        List<Object> listAllRooms = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\room.csv");
        System.out.println("List all rooms");
        for (int index = 0; index < listAllRooms.size(); index++) {
            System.out.println(index + 1 + ". " + listAllRooms.get(index));
        }
    }

    private static void showAllRoomNotDuplicate() {
        List<Object> listAllRooms = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\room.csv");
        TreeSet<String> listRoomNames = new TreeSet<>();
        for (Object room : listAllRooms) {
            Room roomCast = (Room) room;
            listRoomNames.add(roomCast.getServiceName());
        }
        System.out.println("List all Rooms not dupplicate: " + listRoomNames + "\n");
    }
}
