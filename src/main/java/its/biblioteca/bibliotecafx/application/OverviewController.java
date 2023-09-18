package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Archive;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.io.File;

import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String dynamicOutputPath = currentDirectory + File.separator + "Archive" + File.separator;
    private static final String fxmlLocation = currentDirectory + File.separator + "src" + File.separator +
            "main" + File.separator + "resources" + File.separator;
    private static final String dynamicImagesPath = currentDirectory + File.separator + "src" + File.separator +
            "main" + File.separator + "resources" + File.separator + "images" + File.separator;
    public Button showHistoryButton;
    private Image icon = new Image(dynamicImagesPath + "Library1.png");

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
    public String getFxmlLocation() {
        return fxmlLocation;
    }
}
