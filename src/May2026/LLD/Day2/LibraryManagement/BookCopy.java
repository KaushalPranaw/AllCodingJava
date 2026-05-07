package May2026.LLD.Day2.LibraryManagement;

public class BookCopy {
    private int id;
    private BookStatus status;

    public BookCopy(int id) {
        this.id = id;
        this.status=BookStatus.AVAILABLE;
    }

    public int getId() {
        return id;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
