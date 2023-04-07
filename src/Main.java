import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Initialize scanner and array
        ArrayList<String> myArrList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        boolean exit = false;
        //Program run loop. Exit = false means program runs
        while (!exit) {
            displayMenu(myArrList);
            String choice = SafeInput.getRegExString(scanner, "Enter your choice", "[AaDdPpQq]");
            //Use switch for menu choices
            switch (choice.toUpperCase()) {
                case "A":
                    addItem(scanner, myArrList);
                    break;
                case "D":
                    deleteItem(scanner, myArrList);
                    break;
                case "P":
                    printList(myArrList);
                    break;
                case "Q":
                    exit = SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?");
                    break;
            }
        }
        //exit scanner
        scanner.close();
    }

    //Text for menu options
    private static void displayMenu(ArrayList<String> list) {
        System.out.println("\nMenu:");
        System.out.println("A - Add an item to the list");
        System.out.println("D - Delete an item from the list");
        System.out.println("P - Print (i.e. display) the list");
        System.out.println("Q - Quit the program");

        System.out.println("\nCurrent list:");
    }

    //Add an item to array using list.add
    private static void addItem(Scanner scanner, ArrayList<String> list) {
        System.out.print("Enter the item to add: ");
        String item = scanner.next();
        list.add(item);
        System.out.println("Item '" + item + "' added.");
    }
    //Delete item function
    private static void deleteItem(Scanner scanner, ArrayList<String> list) {
        //Check if there is an item to delete
        if (list.isEmpty()) {
            System.out.println("The list is empty. There are no items to delete.");
            return;
        }
        //Used getRangedInt to get index, use list.size for high end
        int indexToDelete = SafeInput.getRangedInt(scanner, "Enter the index of the item to delete", 0, list.size() - 1);
        String toBeDeleted = list.get(indexToDelete);
        //Remove at chosen index
        list.remove(indexToDelete);
        System.out.println("Item '" + toBeDeleted + "' deleted.");
    }

    private static void printList(ArrayList<String> list) {
        //Check for empty list
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
            return;
        }
        //Print list, use list.size and list.get
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ". " + list.get(i));
        }
    }
}