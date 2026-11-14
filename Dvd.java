/** A DVD. Concrete subclass of LibraryItem. */
public class Dvd extends LibraryItem {
    private int durationMinutes;

    public Dvd(String itemId, String title, int durationMinutes) {
        super(itemId, title);
        this.durationMinutes = durationMinutes;
    }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    @Override
    public String getItemType() { return "DVD"; }

    @Override
    public int getLoanPeriodDays() { return 3; }

    @Override
    public double getFinePerDay() { return 1.00; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println(" | Duration: " + durationMinutes + " min");
    }
}