package case_study_FuramaResort.extends_task11;

import java.util.Scanner;
import java.util.Stack;

public class FilingCabinets {
    public static void main(String[] args) {
        Stack<String> listProfiles = addProfile();
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter employee name: ");
        String name = input.nextLine();
        int result = searchProfile(listProfiles, name);
        if (result != -1) {
            System.out.println("\nPosition of employee profile \"" + name + "\" is " + (result + 1) + " in list profiles");
        } else {
            System.out.println("\nNot found this profile");
        }
    }

    private static Stack<String> addProfile () {
        Stack<String> listProfiles = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of profiles: ");
        int numProfiles = Integer.parseInt(input.nextLine());
        int check = listProfiles.size();
        while (check < numProfiles) {
            System.out.println("Enter a profile: ");
            String employeeProfiles = input.nextLine();
            listProfiles.push(employeeProfiles);
            check = listProfiles.size();
        }
        return listProfiles;
    }

    private static int searchProfile (Stack<String> listProfiles, String name) {
        for(int index = 0; index < listProfiles.size(); index++) {
            if (listProfiles.get(index).equals(name)) {
                return index;
            }
        }
        return -1;
    }
}
