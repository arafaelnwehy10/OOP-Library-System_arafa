package javaAssignment;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();
        int choice;
        do {
            System.out.println("\n===== Library Lending System =====");
            System.out.println("1. Add Item");
            System.out.println("2. Add Member");
            System.out.println("3. Borrow Item");
            System.out.println("4. Return Item");
            System.out.println("5. List Catalog");
            System.out.println("6. Report");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("\n1. Book");
                        System.out.println("2. Magazine");
                        System.out.println("3. DVD");
                        System.out.print("Choose item type: ");
                        int type = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        if (type == 1) {
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine();
                            System.out.print("Enter pages: ");
                            int pages = Integer.parseInt(scanner.nextLine());
                            Book book = new Book(title, author, pages);
                            library.addItem(book);
                        } else if (type == 2) {
                            System.out.print("Enter issue number: ");
                            int issueNumber = Integer.parseInt(scanner.nextLine());
                            Magazine magazine = new Magazine(title, issueNumber);
                            library.addItem(magazine);
                        } else if (type == 3) {
                            System.out.print("Enter runtime in minutes: ");
                            int runtimeMinutes = Integer.parseInt(scanner.nextLine());
                            DVD dvd = new DVD(title, runtimeMinutes);
                            library.addItem(dvd);
                        } else {
                            System.out.println("Invalid item type.");
                        }
                        break;
                    case 2:
                        System.out.print("Enter member ID: ");
                        String memberId = scanner.nextLine();
                        System.out.print("Enter member name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter maximum allowed items: ");
                        int maxAllowed = Integer.parseInt(scanner.nextLine());
                        Member member = new Member(memberId, name, maxAllowed);
                        library.addMember(member);
                        break;
                    case 3:
                        System.out.print("Enter member ID: ");
                        String borrowMemberId = scanner.nextLine();
                        System.out.print("Enter item ID: ");
                        String borrowItemId = scanner.nextLine();
                        try {
                            library.borrowItem(borrowMemberId, borrowItemId);
                            System.out.println("Item borrowed successfully.");
                        } catch (LibraryException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        System.out.print("Enter member ID: ");
                        String returnMemberId = scanner.nextLine();
                        System.out.print("Enter item ID: ");
                        String returnItemId = scanner.nextLine();
                        try {
                            library.returnItem(returnMemberId, returnItemId);
                            System.out.println("Item returned successfully.");
                        } catch (LibraryException e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        library.listCatalog();
                        break;
                    case 6:
                        library.printReport();
                        break;
                    case 7:
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                choice = 0;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                choice = 0;
            }
        } while (choice != 7);
        scanner.close();
    }
}