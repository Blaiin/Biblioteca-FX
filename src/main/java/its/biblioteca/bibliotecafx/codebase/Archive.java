package its.biblioteca.bibliotecafx.codebase;

import its.biblioteca.bibliotecafx.utils.FileManager;
import its.biblioteca.bibliotecafx.utils.Months;
import its.biblioteca.bibliotecafx.utils.UtilityMethods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Archive {
    public FileManager fileManager = new FileManager();
    public UtilityMethods utils = new UtilityMethods();
    private List<Book> totalBooks = new ArrayList<>();
    private List<Book> availableBooks = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    private List<Rent> currentlyRentedBooks = new ArrayList<>();
    private List<Rent> rentHistory = new ArrayList<>();

    public Archive() {

    }

    //Utility methods

    public Rent createRent(User user, Book book, Months numMonthsSelected) {
        if (user.getRentedBooks().size() < User.MAX_RENT &&
                availableBooks.contains(book)) {
            LocalDate today = LocalDate.now();
            LocalDate finalDay = utils.toReturnDate(today, numMonthsSelected);
            Rent bookToRent = new Rent(today, finalDay, book, user);
            currentlyRentedBooks.add(bookToRent);
            return bookToRent;
        }
        else{
            System.err.println("Max rented books limit reached or book not available.");
        }
        return null;
    }
    public void addBook(Book book) {
        totalBooks.add(book);
    }
    public void addBook(String author, String title, String editor, LocalDate publishDate) {
        Book bookToAdd = new Book(author, title, editor, publishDate);
        totalBooks.add(bookToAdd);
    }
    public void addUser(User utente) {
        users.add(utente);
    }
    public void addUser(String name, String surname, String email, String phone, LocalDate dob, String residence) {
        User userToAdd = new User(name, surname, email, phone, dob, residence);
        users.add(userToAdd);
    }

}