package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Archive;
import its.biblioteca.bibliotecafx.utils.FileManager;
import javafx.animation.ScaleTransition;
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
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class OverviewController implements Initializable {
    private static final char SEP = File.separator.charAt(0);
    private static final String currentDirectory = System.getProperty("user.dir");
    private static final String dynamicOutputPath = currentDirectory + SEP + "Archive" + SEP;
    private final Image icon = new Image(String.valueOf(getClass().getResource("/images/Library1.png")));
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
    private final Image booksStack = new Image(String.valueOf(getClass().getResource("/images/BooksStack.png")));
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
        addHoverTransition(this.addUserButton);
        addHoverTransition(this.addRentButton);
        addHoverTransition(this.addBookButton);
        addHoverTransition(this.showHistoryButton);
        addHoverTransition(this.returnBookButton);
    }
    public void openAddUserTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddUser.fxml"));
        Parent dialogRoot = loader.load();
        AddUserController addUserController = loader.getController();
        Stage dialogStage = addUserController.getDialogStage();
        dialogStage.setTitle("Add a user..");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(dialogRoot);
        String cssFile = Objects.requireNonNull(getClass().getResource("/css/AddUser.css")).toExternalForm();
        scene.getStylesheets().add(cssFile);
        dialogStage.getIcons().add(AddUserController.getIcon());
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }

    public void openAddBookTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AddBook.fxml"));
        Parent dialogRoot = loader.load();
        AddBookController addBookController = loader.getController();
        Stage dialogStage = addBookController.getDialogStage();
        dialogStage.setTitle("Add a book..");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(dialogRoot);
        String cssFile = Objects.requireNonNull(getClass().getResource("/css/AddBook.css")).toExternalForm();
        scene.getStylesheets().add(cssFile);
        dialogStage.getIcons().add(AddBookController.getIcon());
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
    public void openNewRentTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("NewRent.fxml"));
        Parent dialogRoot = loader.load();
        NewRentController newRentController = loader.getController();
        Stage dialogStage = newRentController.getDialogStage();
        dialogStage.setTitle("Create a rent..");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(dialogRoot);
        String cssFile = Objects.requireNonNull(getClass().getResource("/css/NewRent.css")).toExternalForm();
        scene.getStylesheets().add(cssFile);
        dialogStage.getIcons().add(NewRentController.getIcon());
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
    public void openShowHistoryTab() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowHistory.fxml"));
        Parent dialogRoot = loader.load();
        ShowHistoryController showHistoryController = loader.getController();
        Stage dialogStage = showHistoryController.getDialogStage();
        dialogStage.setTitle("Rent history");
        dialogStage.initModality(Modality.APPLICATION_MODAL);
        Scene scene = new Scene(dialogRoot);
        String cssFile = Objects.requireNonNull(getClass().getResource("/css/ShowHistory.css")).toExternalForm();
        scene.getStylesheets().add(cssFile);
        dialogStage.getIcons().add(showHistoryController.getIcon());
        dialogStage.setScene(scene);
        dialogStage.showAndWait();
    }
    private void addHoverTransition(Button button) {
        ScaleTransition scaleTransition = new ScaleTransition(Duration.millis(250), button);
        scaleTransition.setFromX(1.0);
        scaleTransition.setFromY(1.0);
        scaleTransition.setToX(1.5); // Scale factor for width
        scaleTransition.setToY(1.5); // Scale factor for height
        ScaleTransition reverseTransition = new ScaleTransition(Duration.millis(250), button);
        reverseTransition.setToX(1.0);
        reverseTransition.setToY(1.0);

        button.setOnMouseEntered(event -> scaleTransition.play());
        button.setOnMouseExited(event -> reverseTransition.play());
    }
    //Getters and Setters
    public Image getIcon(){
        return this.icon;
    }
}
