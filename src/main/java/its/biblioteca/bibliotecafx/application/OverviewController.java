package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Archive;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.io.File;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {
    private static char sep = File.separator.charAt(0);
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String dynamicOutputPath = currentDirectory + sep + "Archive" + sep;
    private final Image icon = new Image(String.valueOf(getClass().getResource("Library1.png")));
    @FXML
    Button addUserButton;
    @FXML
    Button addBookButton;
    @FXML
    Button addRentButton;
    @FXML
    Button showHistoryButton;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Archive archive = new Archive();
        archive.fileManager.manageFileJSON(archive.fileManager.getUsersJson());
        archive.fileManager.manageFileJSON(archive.fileManager.getBooksJson());
        archive.fileManager.manageFileJSON(archive.fileManager.getRentsJson());
    }
    public void showHistoryTab() {

    }
    public Image getIcon(){
        return this.icon;
    }
}
