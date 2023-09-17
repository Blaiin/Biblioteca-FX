package its.biblioteca.bibliotecafx.codebase;

public class Utente {
    private static int contoInstanze = 0;
    private int id;
    private String nome;
    private String cognome;

    public Utente() {
    }

    public Utente(String nome, String cognome) {
        contoInstanze++;
        this.id = contoInstanze;
        this.nome = nome;
        this.cognome = cognome;
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

    public static int getContoInstanze() {
        return contoInstanze;
    }

    public static void setContoInstanze(int contoInstanze) {
        Utente.contoInstanze = contoInstanze;
    }
}
