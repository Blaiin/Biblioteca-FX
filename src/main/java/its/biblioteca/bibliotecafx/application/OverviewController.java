package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Archive;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
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
    @FXML
    Button returnBookButton;
    @FXML
    Button showUsersButton;
    @FXML
    Button showBooksButton;
    @FXML
    Button showRentsButton;
    @FXML
    Label versionLabel;
    private final Image booksStack = new Image(String.valueOf(getClass().getResource("BooksStack.png")));
    @FXML
    ImageView overviewImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        overviewImage.setImage(booksStack);
        versionLabel.setText(FileManager.getProjectVersion());
        Archive archive = new Archive();
        archive.fileManager.manageFileJSON(archive.fileManager.getUsersJson());
        archive.fileManager.manageFileJSON(archive.fileManager.getBooksJson());
        archive.fileManager.manageFileJSON(archive.fileManager.getRentsJson());
    }
    public void openAddUserTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddUser.fxml"));
        Parent dialogRoot = loader.load();
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Add a user..");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        dialogStage.setScene(new Scene(dialogRoot));
        dialogStage.showAndWait();
    }
    public void openAddBookTab() {

    }
    public void openNewRentTab() {

    }
    public void openShowHistoryTab() {

    }
    //Getters and Setters
    public Image getIcon(){
        return this.icon;
    }
}
