package its.biblioteca.bibliotecafx.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class LibraryManager extends Application {

    @Override
    public void start(Stage stage) {
        try {
            OverviewController overView = new OverviewController();
            URL resourceURL = getClass().getResource("Overview.fxml");
                FXMLLoader fxmlLoader = new FXMLLoader(resourceURL);
                Scene scene = new Scene(fxmlLoader.load());
                stage.getIcons().add(overView.getIcon());
                stage.setTitle("Library Overview");
                stage.setScene(scene);
                stage.show();
            //System.out.println(resourceURL);
            /* else {
                System.err.println("Resource not found: " + resourceURL);
                throw new NullPointerException();
                // Handle the case where the resource is not found.
            }*/
            //scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/resources/application.css")).toExternalForm());

        } catch(Exception e) {
            System.out.println("Errore: ");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}
