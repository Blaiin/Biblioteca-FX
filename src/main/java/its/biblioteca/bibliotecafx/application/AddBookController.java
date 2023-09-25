package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Book;
import its.biblioteca.bibliotecafx.codebase.User;
import its.biblioteca.bibliotecafx.utils.FileManager;
import its.biblioteca.bibliotecafx.utils.UtilityMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddBookController implements Initializable{
    private static final Image icon = new Image(String.valueOf(AddBookController.class.getResource("/images/BookIcon.png")));
    private final Stage dialogStage;
    private List<Book> booksToAdd = new ArrayList<>();
    @FXML
    Button backButton;
    @FXML
    Button saveButton;
    @FXML
    AnchorPane bookAnchorPane;
    @FXML
    TextField titleField;
    @FXML
    TextField authorField;
    @FXML
    TextField editorField;
    @FXML
    DatePicker publishDatePicker;
    @FXML
    Label errorLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.errorLabel.setVisible(false);
    }
    public AddBookController() {
        this.dialogStage = new Stage();
    }
    @FXML
    public void handleSaveAction() {
        if (saveBook()) {
            booksToAdd.forEach(FileManager::saveToJson);
            dialogStage.close();
        }
    }
    private boolean saveBook() {
        try {
            String title = titleField.getText();
            if (title.isEmpty()) throw new NullPointerException("Title field empty.");
            String author = authorField.getText();
            if (author.isEmpty()) throw new NullPointerException("Author field empty.");
            String editor = editorField.getText();
            if (editor.isEmpty()) throw new NullPointerException("Editor field empty.");
            LocalDate publishDate = publishDatePicker.getValue();
            if (publishDate == null) throw new NullPointerException("Publish date field empty.");

            return booksToAdd.add(new Book(title, author, editor, publishDate));

        }catch (NullPointerException exception) {
            //exception.printStackTrace();
            String errorMessage = exception.getMessage();
            this.errorLabel.setText(errorMessage);
            this.errorLabel.setVisible(true);
            System.err.println(errorMessage);
            return false;
        }
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
