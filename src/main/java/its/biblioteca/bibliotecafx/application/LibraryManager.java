package its.biblioteca.bibliotecafx.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;

public class LibraryManager extends Application {

    @Override
    public void start(Stage stage) {
        try {
            OverviewController overView = new OverviewController();
            URL resourceURL = getClass().getResource("Overview.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(resourceURL);
            Scene scene = new Scene(fxmlLoader.load());
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("Overview.css")).toExternalForm());
            stage.getIcons().add(overView.getIcon());
            stage.setTitle("Library Overview");
            stage.setScene(scene);
            stage.show();
        } catch(Exception e) {
            System.out.println("Error: ");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
