package May2026.LLD.Day2.LibraryManagement;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private String author;
    private List<BookCopy> copies = new ArrayList<>();

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    //add copies
    public void addCopies(BookCopy copy){
        this.copies.add(copy);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<BookCopy> getCopies() {
        return copies;
    }
}
