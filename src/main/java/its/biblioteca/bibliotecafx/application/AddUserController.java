package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.User;
import its.biblioteca.bibliotecafx.utils.UtilityMethods;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class AddUserController implements Initializable {
    private static final Image icon = new Image(String.valueOf(AddUserController.class.getResource("/images/UserIcon.png")));
    private final Stage dialogStage;
    @FXML
    AnchorPane userAnchorPane;
    @FXML
    TextField nameField;
    @FXML
    TextField surnameField;
    @FXML
    TextField emailField;
    @FXML
    TextField phoneNumberField;
    @FXML
    TextField addressField;
    @FXML
    DatePicker dateOfBirthPicker;
    @FXML
    Button saveButton;
    @FXML
    Button backButton;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public AddUserController() {
        this.dialogStage = new Stage();
    }

    @FXML
    private void handleSaveAction() {
        saveUser();
        dialogStage.close();
    }
    private void saveUser() {
        String email = emailField.getText();
        String phoneNumber = phoneNumberField.getText();
        if (UtilityMethods.isValidEmail(email) && UtilityMethods.isPhoneNumber(phoneNumber)) {
            User user = new User(nameField.getText(),
                                 surnameField.getText(),
                                 email, phoneNumber,
                                 dateOfBirthPicker.getValue(),
                                 addressField.getText());
        }
    }
public Stage getDialogStage() {
        return this.dialogStage;
}
    public static Image getIcon() {
        return icon;
    }

    public void back(ActionEvent actionEvent) {
        this.dialogStage.close();
    }
}
