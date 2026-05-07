package May2026.LLD.Day2.LibraryManagement;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LibraryService {
    private List<Book> books=new ArrayList<>();
    private List<Transaction> transactions=new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    //search
    public List<Book> search(String title){
        List<Book> list=new ArrayList<>();
        for(Book book: books){
            if(book.getTitle().toLowerCase().equals(title.toLowerCase())){
                list.add(book);
            }
        }
        return list;
    }

    //issue book
    public Transaction issueBook(Member member, Book book){
        for(BookCopy copy: book.getCopies()){
            if(copy.getStatus()==BookStatus.AVAILABLE){
                copy.setStatus(BookStatus.ISSUED);
                Transaction transaction=new Transaction(member, copy);
                transactions.add(transaction);
                return transaction;
            }
        }
        System.out.println("no copies available");
        return null;
    }
    //return book
    public void returnBook(Transaction transaction){
        transaction.setReturnDate(LocalDate.now());
        transaction.bookCopy.setStatus(BookStatus.AVAILABLE);

        if(transaction.returnDate.isAfter(transaction.dueDate)){
            long daysLate=transaction.dueDate.until(transaction.returnDate).getDays();
            transaction.fine=daysLate*10;
        }
    }
}
