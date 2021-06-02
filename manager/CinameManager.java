package case_study_FuramaResort.manager;

import case_study_FuramaResort.models.MovieTicket;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CinameManager {
    public static void sellTicket() {
        Queue<MovieTicket> listTickets = new LinkedList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter the number of tickets sold for the day: ");
        int numTickets = Integer.parseInt(input.nextLine());
        int check = listTickets.size();
        int seat = 0;
        while (check < numTickets) {
            System.out.println("\nEnter a idTicket");
            String idTicket = input.nextLine();
            System.out.println("Enter a customerName");
            String customerName = input.nextLine();
            seat++;
            MovieTicket ticket = new MovieTicket(idTicket, customerName, seat);
            listTickets.add(ticket);
            check = listTickets.size();
        }

        System.out.println("\nList tickets: ");
        for (MovieTicket ticket: listTickets) {
            System.out.println("1. " + ticket);
        }
        System.out.println();
    }
}
