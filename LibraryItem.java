/**
 * Abstract superclass for everything the library can lend.
 * Demonstrates ABSTRACTION: subclasses MUST implement the abstract methods.
 */
public abstract class LibraryItem {
    private String itemId;
    private String title;
    private boolean available;

    public LibraryItem(String itemId, String title) {
        this.itemId = itemId;
        this.title = title;
        this.available = true;
    }

    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }

    // ---- abstract methods: each subclass provides its own rule ----
    public abstract String getItemType();
    public abstract int getLoanPeriodDays();
    public abstract double getFinePerDay();

    /** Concrete method shared by all items; uses the abstract methods. */
    public double calculateFine(int daysKept) {
        int lateDays = daysKept - getLoanPeriodDays();
        return lateDays > 0 ? lateDays * getFinePerDay() : 0.0;
    }

    /** Overridden by subclasses to add their own details. */
    public void displayInfo() {
        System.out.printf("%-6s | %-10s | %-28s | %-9s",
                itemId, getItemType(), title, available ? "Available" : "On loan");
    }
}