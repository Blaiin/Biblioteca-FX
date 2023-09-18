package its.biblioteca.bibliotecafx.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    private static final String directoryArchivePath = System.getProperty("user.dir") +
            File.separator + "Archivio Books" + File.separator;
    private static final String USERS_JSON = "Users.json";
    private static final String BOOKS_JSON = "Books.json";
    private static final String RENTS_JSON = "Rents.json";

    //Carica le liste dai JSON corrispondenti e ritorna una lista generics
    public List<?> loadListJSON(String name, List<?> lista) {
        try (Reader reader = new FileReader(directoryArchivePath + name)) {
            Gson gson = new GsonBuilder().create();
            Object[] objectsArray = gson.fromJson(reader, Object[].class);

            if (objectsArray != null) {
                lista = Arrays.asList(objectsArray);
            }
        } catch (IOException | NullPointerException ioExc) {
            System.err.println("Errore con i file JSON.");
            ioExc.printStackTrace();
        }

        return lista;
    }

    //Generazione file JSON e controllo errori
    public void manageFileJSON(String name) {
        File file = new File(directoryArchivePath + name);
        try {
            if (file.createNewFile()) {
                switch (name) {
                    case USERS_JSON ->
                            System.out.println("File salvataggio utenti creato con successo.");
                    case BOOKS_JSON ->
                            System.out.println("File salvataggio libri creato con successo.");
                    case RENTS_JSON ->
                            System.out.println("File salvataggio prestiti creato con successo.");
                    default -> System.out.println("File " + name + "creato con successo");
                }
            } else {
                System.out.println(name + " già esistente.");
            }
        } catch (IOException ioExc) {
            switch (name) {
                case USERS_JSON -> {
                    System.err.println("Errore file salvataggio utenti.");
                    ioExc.printStackTrace();
                }
                case BOOKS_JSON -> {
                    System.err.println("Errore file salvataggio libri.");
                    ioExc.printStackTrace();
                }
                case RENTS_JSON -> {
                    System.err.println("Errore file salvataggio prestiti.");
                    ioExc.printStackTrace();
                }
                default -> System.out.println("Errore file: " + name);
            }
        } catch (Exception genericExc) {
            System.out.println("Errore non dettagliato.");
            genericExc.printStackTrace();
        }
    }

    public String getUsersJson() {
        return USERS_JSON;
    }
    public String getBooksJson() {
        return BOOKS_JSON;
    }
    public String getRentsJson() {
        return RENTS_JSON;
    }
}
