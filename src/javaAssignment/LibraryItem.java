package javaAssignment;
public abstract class LibraryItem {
    private String id;
    private String title;
    private boolean borrowed;
    private static int totalItemsCreated = 0;
    private static int nextNumber = 1;
    public LibraryItem(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.id = "ITEM-" + nextNumber++;
        this.title = title;
        this.borrowed = false;
        totalItemsCreated++;
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        this.title = title;
    }
    public boolean isBorrowed() {
        return borrowed;
    }
    public void markBorrowed() {
        borrowed = true;
    }
    public void markReturned() {
        borrowed = false;
    }
    public void displayInfo() {
        System.out.println(
                id + " | " +
                        title + " | " +
                        getType() + " | loan: " +
                        getLoanPeriodDays() + " days | " +
                        (borrowed ? "OUT" : "available")
        );
    }
    public abstract int getLoanPeriodDays();

    public abstract String getType();

    public static int getTotalItemsCreated() {
        return totalItemsCreated;
    }
}