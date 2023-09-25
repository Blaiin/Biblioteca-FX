package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Book;
import its.biblioteca.bibliotecafx.codebase.User;
import its.biblioteca.bibliotecafx.utils.FileManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class NewRentController implements Initializable {
    private final Stage dialogStage;
    private static final Image icon = new Image(String.valueOf(NewRentController.class.getResource("/images/UserIcon.png")));
    @FXML
    AnchorPane newRentAnchorPane;
    @FXML
    Button chooseUserButton;
    @FXML
    Button chooseBookButton;
    @FXML
    ListView<User> userListView;
    @FXML
    ListView<Book> bookListView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Optional<List<User>> usersFromJSON = Optional.ofNullable((List<User>) FileManager.loadListJSON("Users.json"));
        usersFromJSON.ifPresent(user -> userListView.getItems().add((User) user));
        Optional<List<Book>> booksFromJSON = Optional.ofNullable((List<Book>) FileManager.loadListJSON("Books.json"));
        booksFromJSON.ifPresent(book -> bookListView.getItems().add((Book) book));
    }
    public NewRentController() {
        this.dialogStage = new Stage();
    }

    public static Image getIcon() {
        return icon;
    }

    public Stage getDialogStage() {
        return this.dialogStage;
    }

    public void back(ActionEvent actionEvent) {
        this.dialogStage.close();
    }
}
