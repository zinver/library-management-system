import java.util.ArrayList;

/**
 * Manages the collection of items and members.
 * Uses a LibraryItem list so Book, Magazine and Dvd objects can be stored
 * together via superclass references (RUNTIME POLYMORPHISM).
 */
public class Library {
    private String name;
    private ArrayList<LibraryItem> items = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    public Library(String name) { this.name = name; }

    public String getName() { return name; }

    public void addItem(LibraryItem item) { items.add(item); }
    public void addMember(Member member) { members.add(member); }

    public LibraryItem findItem(String id) {
        for (LibraryItem item : items) {
            if (item.getItemId().equalsIgnoreCase(id)) return item;
        }
        return null;
    }

    public Member findMember(String id) {
        for (Member m : members) {
            if (m.getMemberId().equalsIgnoreCase(id)) return m;
        }
        return null;
    }

    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("No items in the library.");
            return;
        }
        System.out.println("ID     | Type       | Title                        | Status");
        System.out.println("-----------------------------------------------------------------");
        for (LibraryItem item : items) {
            item.displayInfo();      // runtime polymorphism: each subclass version runs
        }
    }

    public void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members registered.");
            return;
        }
        for (Member m : members) {
            m.displayInfo();
            System.out.println("-----------------------------");
        }
    }

    /** Returns a message describing the result of the borrow attempt. */
    public String borrowItem(String memberId, String itemId) {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        if (member == null) return "Member not found.";
        if (item == null) return "Item not found.";
        if (!item.isAvailable()) return "Sorry, that item is already on loan.";
        if (!member.canBorrow()) return "Borrow limit reached. Please return an item first.";

        item.setAvailable(false);
        member.borrowItem(item);
        return member.getName() + " borrowed \"" + item.getTitle() + "\". Loan period: "
                + item.getLoanPeriodDays() + " days.";
    }

    public String returnItem(String memberId, String itemId, int daysKept) {
        Member member = findMember(memberId);
        LibraryItem item = findItem(itemId);
        if (member == null) return "Member not found.";
        if (item == null) return "Item not found.";
        if (!member.getBorrowedItems().contains(item)) return "This member did not borrow that item.";

        double fine = item.calculateFine(daysKept);   // polymorphic call
        member.addFine(fine);
        member.returnItem(item);
        item.setAvailable(true);
        return String.format("\"%s\" returned after %d day(s). Fine: RM %.2f",
                item.getTitle(), daysKept, fine);
    }
}