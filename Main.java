import java.util.Scanner;

/** Console menu for the Library Management System. */
public class Main {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library("City University Library");
        loadSampleData(library);

        int choice;
        do {
            printMenu(library.getName());
            choice = readInt("Enter choice: ");
            switch (choice) {
                case 1: addItem(library); break;
                case 2: registerMember(library); break;
                case 3: library.displayAllItems(); break;
                case 4: library.displayAllMembers(); break;
                case 5:
                    System.out.println(library.borrowItem(
                            readLine("Member ID: "), readLine("Item ID: ")));
                    break;
                case 6:
                    System.out.println(library.returnItem(
                            readLine("Member ID: "), readLine("Item ID: "),
                            readInt("Days kept: ")));
                    break;
                case 7: showLoanRules(library); break;
                case 0: System.out.println("Thank you. Goodbye!"); break;
                default: System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);
    }

    private static void printMenu(String name) {
        System.out.println("\n===== " + name.toUpperCase() + " =====");
        System.out.println("1. Add item");
        System.out.println("2. Register member");
        System.out.println("3. Display all items");
        System.out.println("4. Display all members");
        System.out.println("5. Borrow item");
        System.out.println("6. Return item");
        System.out.println("7. Show loan rules (polymorphism demo)");
        System.out.println("0. Exit");
    }

    private static void addItem(Library library) {
        System.out.println("Item type: 1) Book  2) Magazine  3) DVD");
        int type = readInt("Type: ");
        String id = readLine("Item ID: ");
        String title = readLine("Title: ");
        LibraryItem item;                      // superclass reference
        switch (type) {
            case 1:
                item = new Book(id, title, readLine("Author: "), readInt("Pages: "));
                break;
            case 2:
                item = new Magazine(id, title, readInt("Issue number: "));
                break;
            case 3:
                item = new Dvd(id, title, readInt("Duration (min): "));
                break;
            default:
                System.out.println("Invalid type.");
                return;
        }
        library.addItem(item);
        System.out.println("Item added.");
    }

    private static void registerMember(Library library) {
        library.addMember(new Member(readLine("Member ID: "),
                readLine("Name: "), readLine("Email: ")));
        System.out.println("Member registered.");
    }

    /** Shows the same method call behaving differently for each object type. */
    private static void showLoanRules(Library library) {
        LibraryItem[] samples = {
            new Book("X", "Sample", "-", 0),
            new Magazine("Y", "Sample", 0),
            new Dvd("Z", "Sample", 0)
        };
        for (LibraryItem item : samples) {
            System.out.printf("%-9s loan: %2d days, fine: RM %.2f/day, 10 days kept -> RM %.2f%n",
                    item.getItemType(), item.getLoanPeriodDays(),
                    item.getFinePerDay(), item.calculateFine(10));
        }
    }

    private static void loadSampleData(Library library) {
        library.addItem(new Book("B001", "Java: The Complete Reference", "Herbert Schildt", 1280));
        library.addItem(new Book("B002", "Clean Code", "Robert C. Martin", 464));
        library.addItem(new Magazine("M001", "Computer World", 52));
        library.addItem(new Dvd("D001", "Intro to OOP Lecture", 90));
        library.addMember(new Member("S1001", "Aisha Rahman", "aisha@student.edu.my"));
    }

    // ---- safe input helpers ----
    private static String readLine(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int readInt(String prompt) {
        while (true) {
            try {
                return Integer.parseInt(readLine(prompt));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}