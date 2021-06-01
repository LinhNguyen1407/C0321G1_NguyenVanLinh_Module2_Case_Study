package case_study_FuramaResort.manager;

import case_study_FuramaResort.commons.ReadAndWriteFile;
import case_study_FuramaResort.models.Employee;

import java.util.*;

public class EmployeeManager {
    public static void addNewEmployee() {
        List<Object> listEmployees = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {
            try {
                System.out.println("Enter name:");
                String name = input.nextLine();
                System.out.println("Enter age:");
                String age = input.nextLine();
                System.out.println("Enter address:");
                String address = input.nextLine();

                Employee employee = new Employee(name, age, address);
                listEmployees.clear();
                listEmployees.addAll(ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\employee.csv"));
                listEmployees.add(employee);
                ReadAndWriteFile.writeToFile(listEmployees, "src\\case_study_FuramaResort\\data\\employee.csv");

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

    public static void showInformationEmployee() {
        List<Object> listAllEmployees = ReadAndWriteFile.readFromFile("src\\case_study_FuramaResort\\data\\employee.csv");
        int employeeCode = 1;
        Map<Integer, Object> employeeMap = new HashMap<>();
        for (Object employee : listAllEmployees) {
            employeeMap.put(employeeCode, employee);
            employeeCode++;
        }
        for (Map.Entry<Integer, Object> employee : employeeMap.entrySet()) {
            System.out.println(employee.toString());
        }
        System.out.println();
    }
}
