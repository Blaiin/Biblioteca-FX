package its.biblioteca.bibliotecafx.codebase;

import its.biblioteca.bibliotecafx.utils.FileManager;

import java.util.ArrayList;
import java.util.List;

public class Archivio extends FileManager {
    private List<Libro> listaLibri = new ArrayList<>();
    private List<Utente> listaUtenti = new ArrayList<>();
    private List<Prestito> listaPrestiti = new ArrayList<>();

    public Archivio() {

    }
    public void aggiungiLibro(Libro libro) {
        listaLibri.add(libro);
    }
    public void aggiungiUtente(Utente utente) {
        listaUtenti.add(utente);
    }

}