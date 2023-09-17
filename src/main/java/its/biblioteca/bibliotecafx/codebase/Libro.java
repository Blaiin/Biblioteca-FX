package its.biblioteca.bibliotecafx.codebase;

public class Libro {
    private static int contoInstanze = 0;
    private int id;
    private String autore;
    private String titolo;

    public Libro() {
    }
    public Libro(String autore, String titolo) {
        contoInstanze++;
        this.id = contoInstanze;
        this.autore = autore;
        this.titolo = titolo;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getAutore() {
        return autore;
    }
    public void setAutore(String autore) {
        this.autore = autore;
    }
    public String getTitolo() {
        return titolo;
    }
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public static int getContoInstanze() {
        return contoInstanze;
    }

    public static void setContoInstanze(int contoInstanze) {
        Libro.contoInstanze = contoInstanze;
    }

    @Override
    public String toString() {
        return "codebase.Libro [id=" + id + ", autore=" + autore + ", titolo=" + titolo + "]";
    }

    public String toCSV() {
        return this.id+","+this.autore+","+this.titolo;
    }
}
