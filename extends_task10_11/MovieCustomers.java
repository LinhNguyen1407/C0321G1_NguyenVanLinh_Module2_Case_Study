package case_study_FuramaResort.extends_task10_11;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MovieCustomers {
    public static void main(String[] args) {
        addAndShowMovieCustomer();
    }

    private static void addAndShowMovieCustomer() {
        Queue<String> listMovieCustomers = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of customers buying tickets: ");
        int numCustomer = Integer.parseInt(input.nextLine());
        int check = listMovieCustomers.size();
        while (check < numCustomer) {
            System.out.println("Enter customer name: ");
            String movieCustomer = input.nextLine();
            listMovieCustomers.add(movieCustomer);
            check = listMovieCustomers.size();
        }
        System.out.println("List movie customers: \n" + listMovieCustomers);
    }
}

