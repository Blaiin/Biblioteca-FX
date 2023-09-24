package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class UsersListController implements Initializable {
    @FXML
    ListView<User> usersListView;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
