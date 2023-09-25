package its.biblioteca.bibliotecafx.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;

public class FileManager {
    private static final String directoryArchivePath = System.getProperty("user.dir") +
            File.separator + "Archive" + File.separator;
    private static final String USERS_JSON = "Users.json";
    private static final String BOOKS_JSON = "Books.json";
    private static final String RENTS_JSON = "Rents.json";

    //Get project version element
    public static String getProjectVersion() {
        try {
            File xmlFile = new File("pom.xml"); // Replace with your XML file path
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();

            // Assuming the version is stored in an element named "version"
            Node versionNode = doc.getElementsByTagName("version").item(0);
            if (versionNode.getNodeType() == Node.ELEMENT_NODE) {
                Element versionElement = (Element) versionNode;
                String version = versionElement.getTextContent();
                return "Version: " + version;
            }
        } catch (Exception e) {
            System.err.println("Error: Unable to retrieve version information");
            e.printStackTrace();
        }
        return "Version: " + null;
    }

    //Carica le liste dai JSON corrispondenti e ritorna una lista generics
    public static List<?> loadListJSON(String name) {
        List<?> listFromJson;
        try (Reader reader = new FileReader(directoryArchivePath + name)) {
            Gson gson = new GsonBuilder().create();
            Object[] objectsArray = gson.fromJson(reader, Object[].class);

            if (objectsArray != null) {
                return listFromJson = Arrays.asList(objectsArray);
            }
        } catch (IOException | NullPointerException ioExc) {
            System.err.println("JSON files error.");
            ioExc.printStackTrace();
        }

        return listFromJson = null;
    }

    //Generazione file JSON e controllo errori
    public void manageFileJSON(String name) {
        File file = new File(directoryArchivePath + name);
        try {
            if (file.createNewFile()) {
                switch (name) {
                    case USERS_JSON ->
                            System.out.println("Users file succesfully created.");
                    case BOOKS_JSON ->
                            System.out.println("Books file succesfully created.");
                    case RENTS_JSON ->
                            System.out.println("Rents file succesfully created.");
                    default -> System.out.println(name + "file succesfully created");
                }
            } else {
                System.out.println(name + " already exists.");
            }
        } catch (IOException ioExc) {
            switch (name) {
                case USERS_JSON -> {
                    System.err.println("Users file error.");
                    ioExc.printStackTrace();
                }
                case BOOKS_JSON -> {
                    System.err.println("Books file error.");
                    ioExc.printStackTrace();
                }
                case RENTS_JSON -> {
                    System.err.println("Rents file error.");
                    ioExc.printStackTrace();
                }
                default -> System.out.println("File error: " + name);
            }
        } catch (Exception genericExc) {
            System.out.println("Generic error.");
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
