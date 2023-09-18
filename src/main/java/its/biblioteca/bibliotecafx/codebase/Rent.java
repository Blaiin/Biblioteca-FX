package its.biblioteca.bibliotecafx.codebase;

import java.time.LocalDate;

public class Rent {
    private static int instanceCount = 0;

    private int id;
    private LocalDate start;
    private LocalDate end;
    private Book book;
    private User user;

    public Rent() {
    }

    public Rent(LocalDate start, LocalDate end, Book book, User user) {
        instanceCount++;
        this.id = instanceCount;
        this.start = start;
        this.end = end;
        this.book = book;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getStartDate() {
        return start;
    }

    public void setStartDate(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEndDate() {
        return end;
    }

    public void setEndDate(LocalDate end) {
        this.end = end;
    }

    public static int setInstanceCount() {
        return instanceCount;
    }

    public static void setInstanceCount(int contoInstanze) {
        Rent.instanceCount = contoInstanze;
    }

    @Override
    public String toString() {
        return "Rent -> [id=" + id + ", start=" + start + ", end=" + end + ", book=" + book
                + ", utente=" + user + "]";
    }
}
