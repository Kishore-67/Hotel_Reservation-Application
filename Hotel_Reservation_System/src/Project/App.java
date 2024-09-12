package Project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("SimpleMySqlTableExample.fxml"));
            primaryStage.setTitle("Hello World!");
            primaryStage.setWidth(700);
            primaryStage.setHeight(600);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception in a way that makes sense for your application
        }
    }

}