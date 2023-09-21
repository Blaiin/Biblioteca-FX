package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Archive;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {
    private static final char SEP = File.separator.charAt(0);
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String dynamicOutputPath = currentDirectory + SEP + "Archive" + SEP;
    private final Image icon = new Image(String.valueOf(getClass().getResource("Library1.png")));
    @FXML
    AnchorPane anchorPane;
    @FXML
    Button addUserButton;
    @FXML
    Button addBookButton;
    @FXML
    Button addRentButton;
    @FXML
    Button showHistoryButton;
    private final Image booksStack = new Image(String.valueOf(getClass().getResource("BooksStack.png")));
    @FXML
    ImageView overviewImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        overviewImage.setImage(booksStack);
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
