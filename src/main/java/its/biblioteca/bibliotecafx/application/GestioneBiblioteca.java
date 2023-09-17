package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Archivio;
import javafx.application.Application;
import javafx.stage.Stage;

public class GestioneBiblioteca extends Application {
    public static void main(String[] args) {
    Archivio archivio = new Archivio();
    archivio.genFileJSON(archivio.getLibriJson());
    archivio.genFileJSON(archivio.getUtentiJson());
    archivio.genFileJSON(archivio.getPrestitiJson());
    }

    @Override
    public void start(Stage stage) throws Exception {

    }
}
