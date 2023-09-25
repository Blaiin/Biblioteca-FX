package its.biblioteca.bibliotecafx.application;

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

public class AddUserController implements Initializable {
    private static final Image icon = new Image(String.valueOf(AddUserController.class.getResource("/images/UserIcon.png")));
    private final Stage dialogStage;
    private List<User> usersToAdd = new ArrayList<>();
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
    @FXML
    Label errorLabel;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.errorLabel.setVisible(false);
    }
    public AddUserController() {
        this.dialogStage = new Stage();
    }

    @FXML
    private void handleSaveAction() {
        if(saveUser()) {
            usersToAdd.forEach(FileManager::saveToJson);
            dialogStage.close();
        }
    }
    private boolean saveUser() {
        try {
            String name = nameField.getText();
            if (name.isEmpty()) throw new NullPointerException("Name field empty.");
            String surname = surnameField.getText();
            if (surname.isEmpty()) throw new NullPointerException("Surname field empty.");
            String email = emailField.getText();
            if (email.isEmpty()) throw new NullPointerException("Email field empty.");
            String phoneNumber = phoneNumberField.getText();
            if (phoneNumber.isEmpty()) throw new NullPointerException("Phone number field empty.");
            LocalDate dateOfBirth = dateOfBirthPicker.getValue();
            if (dateOfBirth == null) throw new NullPointerException("Date of birth field empty.");
            String address = addressField.getText();
            if (UtilityMethods.isValidEmail(email) && UtilityMethods.isPhoneNumber(phoneNumber)) {
                return usersToAdd.add(new User(name, surname, email, phoneNumber, dateOfBirth, address));
            }
            return false;
        }catch (NullPointerException exception) {
            //exception.printStackTrace();
            String errorMessage = exception.getMessage();
            this.errorLabel.setText(errorMessage);
            this.errorLabel.setVisible(true);
            System.err.println(errorMessage);
            return false;
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
