package challenge;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Comparator;

public class PlacesList {
    public static void main(String[] args) {
        // Creating the Linked List
        LinkedList<Town> itinerary = new LinkedList<>();

        Town town1 = new Town("Sydney");
        Town town2 = new Town("Adelaide", 1374, town1);
        Town town3 = new Town("Alice Springs", 2771, town1);
        Town town4 = new Town("Brisbane", 917, town1);
        Town town5 = new Town("Darwin", 3972, town1);
        Town town6 = new Town("Melbourne", 877, town1);
        Town town7 = new Town("Perth", 3923, town1);

        // Inserting the items while ordering the Linked list
        itinerary.add(town1);
        itinerary.add(town2);
        itinerary.add(town3);
        itinerary.add(town4);
        itinerary.add(town5);
        itinerary.add(town6);
        itinerary.add(town7);

        // Sorting linked list by distance
        itinerary.sort(Comparator.comparingInt(Town::getDistanceFromStartingPoint));

        // Setting up scanner
        Scanner scan = new Scanner(System.in);

        String choice;
        print_menu();

        // Declaring the List Iterator
        ListIterator<Town> iter = itinerary.listIterator();
        boolean forward = true;      // true for forward and false for backward

        do {
            System.out.print("Enter the choice: ");
            choice = ("" + scan.nextLine().trim().charAt(0)).toUpperCase();

            dispatch(itinerary, iter, choice, forward);
        } while (!choice.equals("Q"));
    }

    // Method to run the command
    public static void dispatch(LinkedList<Town> itinerary, ListIterator<Town> iter, String choice, boolean forward) {
        if (choice.equals("F")) {
            if (!forward) {
                if (iter.hasNext()) {
                    iter.next();
                }
                forward = true;
            }
            if (iter.hasNext())
                System.out.println("Current " + iter.next());
            else
                System.out.println("Already at the last town");
        } else if (choice.equals("B")) {
            if (forward) {
                if (iter.hasPrevious())
                    iter.previous();
                forward = false;
            }
            if (iter.hasPrevious())
                System.out.println("Current " + iter.previous());
            else
                System.out.println("Already at the first town");
        } else if (choice.equals("L")) {
            print_itinerary(itinerary);
        } else if (choice.equals("M")) {
            print_menu();
        } else if (choice.equals("Q")) {
            System.out.println("Exiting...");
        } else {
            System.out.println("Unsupported choice. Enter M for help");
        }
    }

    // method to print the list of places
    public static void print_itinerary(LinkedList<Town> itinerary) {
        System.out.println("Itinerary:");
        for (Town town : itinerary)
            System.out.println("\t" + town);
    }

    // method to print the menu of choices
    private static void print_menu() {
        System.out.println("""
            ============================
            Available actions:
            (F) Forward
            (B) Backward
            (L) List towns
            (M) Show menu
            (Q) Quit
            ============================
            """);
    }
}
