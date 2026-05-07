package May2026.LLD.Day2.LibraryManagement;

public class Main {
    public static void main(String[] args) {
        LibraryService service=new LibraryService();
        // Create book
        Book book = new Book(1, "Java Basics", "James Gosling");
        book.addCopies(new BookCopy(101));
        book.addCopies(new BookCopy(102));

        service.getBooks().add(book);

        // Create member
        Member user = new Member(1, "Pranaw");

        // Issue book
        Transaction tx = service.issueBook(user, book);
        System.out.println("Book issued on: " + tx.getIssuedDate());

        // Return book
        service.returnBook(tx);
        System.out.println("Fine: " + tx.fine);



    }
}
