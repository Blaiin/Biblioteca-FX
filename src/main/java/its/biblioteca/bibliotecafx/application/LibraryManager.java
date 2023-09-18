package its.biblioteca.bibliotecafx.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class LibraryManager extends Application {

    @Override
    public void start(Stage stage) {
        try {
            OverviewController overView = new OverviewController();
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(overView.getFxmlLocation() + "/main/java/its/biblioteca/bibliotecafx/testFXML/Overview.fxml")));
            Scene scene = new Scene(root);
            //scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/resources/application.css")).toExternalForm());
            stage.getIcons().add(overView.getIcon());
            stage.setTitle("Library Overview");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
