/** A book. Concrete subclass of LibraryItem. */
public class Book extends LibraryItem {
    private String author;
    private int pages;

    public Book(String itemId, String title, String author, int pages) {
        super(itemId, title);
        this.author = author;
        this.pages = pages;
    }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getPages() { return pages; }
    public void setPages(int pages) { this.pages = pages; }

    @Override
    public String getItemType() { return "Book"; }

    @Override
    public int getLoanPeriodDays() { return 14; }

    @Override
    public double getFinePerDay() { return 0.50; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | Author: " + author + ", " + pages + " pages");
    }
}