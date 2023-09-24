package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.User;
import its.biblioteca.bibliotecafx.utils.UtilityMethods;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddUserController {
    private Stage dialogStage;
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
}
