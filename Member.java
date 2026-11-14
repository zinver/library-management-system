import java.util.ArrayList;

/**
 * Library member. Inherits from Person (INHERITANCE) and overrides
 * getRole() and displayInfo() (METHOD OVERRIDING).
 */
public class Member extends Person {
    private static final int MAX_ITEMS = 3;

    private String memberId;
    private ArrayList<LibraryItem> borrowedItems;
    private double totalFines;

    public Member(String memberId, String name, String email) {
        super(name, email);                 // call superclass constructor
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
        this.totalFines = 0.0;
    }

    public String getMemberId() { return memberId; }
    public void setMemberId(String memberId) { this.memberId = memberId; }

    public ArrayList<LibraryItem> getBorrowedItems() { return borrowedItems; }

    public double getTotalFines() { return totalFines; }

    public boolean canBorrow() {
        return borrowedItems.size() < MAX_ITEMS;
    }

    public void borrowItem(LibraryItem item) {
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item) {
        borrowedItems.remove(item);
    }

    public void addFine(double amount) {
        if (amount > 0) {
            totalFines += amount;
        }
    }

    @Override
    public String getRole() {
        return "Library Member";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.printf("ID    : %s%nBorrowed: %d/%d item(s)%nFines : RM %.2f%n",
                memberId, borrowedItems.size(), MAX_ITEMS, totalFines);
        for (LibraryItem item : borrowedItems) {
            System.out.println("   - " + item.getTitle() + " [" + item.getItemType() + "]");
        }
    }
}