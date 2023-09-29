package its.biblioteca.bibliotecafx.application;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public interface FXMLController {
    Image icon = null;

    Image getIcon();

    Stage getDialogStage();
}
