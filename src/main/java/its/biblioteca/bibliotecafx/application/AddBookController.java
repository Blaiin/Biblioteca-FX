package its.biblioteca.bibliotecafx.application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class AddBookController implements Initializable{
    private final Stage dialogStage;
    private static final Image icon = new Image(String.valueOf(AddBookController.class.getResource("/images/BookIcon.png")));
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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public AddBookController() {
        this.dialogStage = new Stage();
    }
    @FXML
    public void handleSaveAction() {
        saveBook();
        dialogStage.close();
    }

    private void saveBook() {
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
