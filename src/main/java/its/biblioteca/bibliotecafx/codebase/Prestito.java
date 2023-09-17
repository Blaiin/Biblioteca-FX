package its.biblioteca.bibliotecafx.codebase;

import java.util.Date;

public class Prestito {
    private static int contoInstanze = 0;

    private int id;
    private Date dataInizio;
    private Date dataFine;
    private Libro libro;
    private Utente utente;

    public Prestito() {
    }

    public Prestito(Date dataInizio, Date dataFine, Libro libro, Utente utente) {
        super();
        contoInstanze++;
        this.id = contoInstanze;
        this.dataInizio = dataInizio;
        this.dataFine = dataFine;
        this.libro = libro;
        this.utente = utente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Utente getUtente() {
        return utente;
    }

    public void setUtente(Utente utente) {
        this.utente = utente;
    }

    public Date getDataInizio() {
        return dataInizio;
    }

    public void setDataInizio(Date dataInizio) {
        this.dataInizio = dataInizio;
    }

    public Date getDataFine() {
        return dataFine;
    }

    public void setDataFine(Date dataFine) {
        this.dataFine = dataFine;
    }

    public static int getContoInstanze() {
        return contoInstanze;
    }

    public static void setContoInstanze(int contoInstanze) {
        Prestito.contoInstanze = contoInstanze;
    }

    @Override
    public String toString() {
        return "codebase.Prestito [id=" + id + ", dataInizio=" + dataInizio + ", dataFine=" + dataFine + ", libro=" + libro
                + ", utente=" + utente + "]";
    }
}
