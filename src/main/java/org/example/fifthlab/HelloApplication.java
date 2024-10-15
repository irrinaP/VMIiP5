package org.example.fifthlab;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static Stage mainStage;
    public static String check = "";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 400);
        mainStage = stage;
        mainStage.setResizable(false);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void setWordThrower() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("wordThrower-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 400);
        mainStage.setScene(scene);
    }

    public static void setWidgets() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("widgets-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 250);
        mainStage.setScene(scene);
    }

    public static void setRestaurant() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("restaurant-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 600);
        mainStage.setScene(scene);
    }

    public static void setCalculator() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calculator-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 280, 400);
        mainStage.setScene(scene);
    }

    public static void setFlag() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("flag-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 400, 300);
        mainStage.setScene(scene);
    }


    public static void main(String[] args) {
        launch();
    }
}