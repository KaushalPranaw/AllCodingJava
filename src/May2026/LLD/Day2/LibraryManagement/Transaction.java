package May2026.LLD.Day2.LibraryManagement;

import java.time.LocalDate;

public class Transaction {
    Member member;
    BookCopy bookCopy;
    LocalDate issuedDate;
    LocalDate dueDate;
    LocalDate returnDate;
    double fine;

    public Transaction(Member member, BookCopy bookCopy) {
        this.member = member;
        this.bookCopy = bookCopy;
        this.issuedDate=LocalDate.now();
        this.dueDate=issuedDate.plusDays(7);
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public BookCopy getBookCopy() {
        return bookCopy;
    }

    public void setBookCopy(BookCopy bookCopy) {
        this.bookCopy = bookCopy;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public double getFine() {
        return fine;
    }

    public void setFine(double fine) {
        this.fine = fine;
    }
}
