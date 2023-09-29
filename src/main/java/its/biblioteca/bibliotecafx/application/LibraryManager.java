package its.biblioteca.bibliotecafx.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.net.URL;
import java.util.Objects;

public class LibraryManager extends Application {

    @Override
    public void start(Stage stage) {
        try {
            OverviewController overView = new OverviewController();
            Screen screen = Screen.getPrimary();
            Rectangle2D rectangleScreen = screen.getBounds();
            double scaleX = rectangleScreen.getWidth() / 1600;
            double scaleY = rectangleScreen.getHeight() / 900;
            URL resourceURL = getClass().getResource("Overview.fxml");
            FXMLLoader fxmlLoader = new FXMLLoader(resourceURL);
            Parent root = fxmlLoader.load();
            overView.getAnchorPane().setPrefWidth(scaleX);
            overView.getAnchorPane().setPrefHeight(scaleY);
            Scene scene = new Scene(root);
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/css/Overview.css")).toExternalForm());
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
