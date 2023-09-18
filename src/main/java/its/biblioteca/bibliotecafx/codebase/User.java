package its.biblioteca.bibliotecafx.codebase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class User {
    public static final int MAX_RENT = 3;
    private static int contoInstanze = 0;
    private int id;
    private String nome;
    private String cognome;
    private String email;
    private String numTelefono;
    private LocalDate dataNascita;
    private String residenza;
    private List<Book> rentedBooks = new ArrayList<>();

    public User() {
    }

    public User(String nome, String cognome, String email, String numTelefono, LocalDate dataNascita, String residenza) {
        contoInstanze++;
        this.id = contoInstanze;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.numTelefono = numTelefono;
        this.dataNascita = dataNascita;
        this.residenza = residenza;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumTelefono() {
        return numTelefono;
    }

    public void setNumTelefono(String numTelefono) {
        this.numTelefono = numTelefono;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getResidenza() {
        return residenza;
    }

    public void setResidenza(String residenza) {
        this.residenza = residenza;
    }

    public List<Book> getRentedBooks() {
        return rentedBooks;
    }

    public static int getContoInstanze() {
        return contoInstanze;
    }

    public static void setContoInstanze(int contoInstanze) {
        User.contoInstanze = contoInstanze;
    }
}
