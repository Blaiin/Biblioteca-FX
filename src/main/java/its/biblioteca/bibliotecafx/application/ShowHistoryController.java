package its.biblioteca.bibliotecafx.application;

import its.biblioteca.bibliotecafx.codebase.Rent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ShowHistoryController implements Initializable {
    private final Stage dialogStage;
    private static final Image icon = new Image(String.valueOf(ShowHistoryController.class.getResource("/images/History.png")));
    @FXML
    AnchorPane rentHistoryAnchorPane;
    @FXML
    Button backButton;
    @FXML
    ListView<Rent> rentHistoryList;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public ShowHistoryController() {
        this.dialogStage = new Stage();
    }
    public void back(ActionEvent actionEvent) {
        this.dialogStage.close();
    }

    public Stage getDialogStage() {
        return this.dialogStage;
    }

    public Image getIcon() {
        return icon;
    }
}
