package javaAssignment;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class Library {
    private Map<String, LibraryItem> catalog;
    private Map<String, Member> members;
    private Set<String> borrowedIds;
    public Library() {
        catalog = new HashMap<>();
        members = new HashMap<>();
        borrowedIds = new HashSet<>();
    }
    public void addItem(LibraryItem item) {
        catalog.put(item.getId(), item);
    }
    public void addMember(Member member) {
        members.put(member.getMemberId(), member);
    }
    public void borrowItem(String memberId, String itemId) throws LibraryException {
        Member member = members.get(memberId);
        if (member == null) {
            throw new LibraryException("Member not found");
        }
        LibraryItem item = catalog.get(itemId);
        if (item == null) {
            throw new LibraryException("Item not found");
        }
        if (item.isBorrowed()) {
            throw new LibraryException("Item is already borrowed");
        }
        if (!member.canBorrowMore()) {
            throw new LibraryException("Member has reached the borrowing limit");
        }
        item.markBorrowed();
        member.addBorrowedItem(item);
        borrowedIds.add(itemId);
    }
    public void returnItem(String memberId, String itemId) throws LibraryException {
        Member member = members.get(memberId);
        if (member == null) {
            throw new LibraryException("Member not found");
        }
        LibraryItem item = catalog.get(itemId);
        if (item == null) {
            throw new LibraryException("Item not found");
        }
        if (!member.getBorrowedItems().contains(item)) {
            throw new LibraryException("Member does not have this item");
        }
        item.markReturned();
        member.removeBorrowedItem(item);
        borrowedIds.remove(itemId);
    }
    public void listCatalog() {
        for (LibraryItem item : catalog.values()) {
            item.displayInfo();
        }
    }
    public void printReport() {
        System.out.println("Total items: " + catalog.size());
        System.out.println("Currently borrowed: " + borrowedIds.size());
        System.out.println("Borrowed IDs:");
        for (String id : borrowedIds) {
            System.out.println(id);
        }
        int bookCount = 0;
        int magazineCount = 0;
        int dvdCount = 0;
        for (LibraryItem item : catalog.values()) {
            if (item.getType().equals("Book")) {
                bookCount++;
            } else if (item.getType().equals("Magazine")) {
                magazineCount++;
            } else if (item.getType().equals("DVD")) {
                dvdCount++;
            }
        }
        System.out.println("Books: " + bookCount);
        System.out.println("Magazines: " + magazineCount);
        System.out.println("DVDs: " + dvdCount);
        System.out.println("Total items ever created: "
                + LibraryItem.getTotalItemsCreated());
    }
}