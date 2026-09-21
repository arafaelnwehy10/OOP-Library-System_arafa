package javaAssignment;
import java.util.ArrayList;
import java.util.List;
public class Member {
    private String memberId;
    private String name;
    private int maxAllowed;
    private List<LibraryItem> borrowedItems;
    public Member(String memberId, String name, int maxAllowed) {
        this.memberId = memberId;
        setName(name);
        setMaxAllowed(maxAllowed);
        borrowedItems = new ArrayList<>();
    }
    public String getMemberId() {
        return memberId;
    }
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }
    public int getMaxAllowed() {
        return maxAllowed;
    }
    public void setMaxAllowed(int maxAllowed) {
        if (maxAllowed <= 0) {
            throw new IllegalArgumentException("Max allowed must be positive");
        }
        this.maxAllowed = maxAllowed;
    }
    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }
    public int getBorrowedCount() {
        return borrowedItems.size();
    }
    public boolean canBorrowMore() {
        return borrowedItems.size() < maxAllowed;
    }
    public void addBorrowedItem(LibraryItem item) {
        borrowedItems.add(item);
    }
    public void removeBorrowedItem(LibraryItem item) {
        borrowedItems.remove(item);
    }
}