package org.example.fifthlab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WidgetToggle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label label = new Label("Я метка");
        Button button = new Button("Я кнопка");
        TextField textField = new TextField("Я текстовое поле");

        CheckBox labelCheck = new CheckBox("Показать метку");
        CheckBox buttonCheck = new CheckBox("Показать кнопку");
        CheckBox textFieldCheck = new CheckBox("Показать текстовое поле");

        labelCheck.setOnAction(e -> label.setVisible(labelCheck.isSelected()));
        buttonCheck.setOnAction(e -> button.setVisible(buttonCheck.isSelected()));
        textFieldCheck.setOnAction(e -> textField.setVisible(textFieldCheck.isSelected()));

        VBox layout = new VBox(10, labelCheck, buttonCheck, textFieldCheck, label, button, textField);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.setTitle("Виджеты с чекбоксами");
        stage.show();
    }
}
