package org.example.fifthlab;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calculator extends Application {

    private TextField display = new TextField();
    private double num1 = 0;
    private String operator = "";

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        display.setEditable(false);

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(5);
        grid.setVgap(5);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" // Добавили кнопку "C" для очистки
        };

        for (int i = 0; i < buttons.length; i++) {
            Button button = new Button(buttons[i]);
            button.setPrefWidth(50); // Установка ширины кнопок
            button.setOnAction(e -> onButtonClick(button.getText()));
            grid.add(button, i % 4, i / 4 + 1);
        }

        grid.add(display, 0, 0, 4, 1);

        stage.setScene(new Scene(grid));
        stage.setTitle("Калькулятор");
        stage.show();
    }

    private void onButtonClick(String text) {
        switch (text) {
            case "=":
                double num2 = Double.parseDouble(display.getText());
                double result = switch (operator) {
                    case "+" -> num1 + num2;
                    case "-" -> num1 - num2;
                    case "*" -> num1 * num2;
                    case "/" -> (num2 == 0) ? Double.NaN : num1 / num2;
                    default -> 0;
                };
                display.setText(Double.isNaN(result) ? "Ошибка" : String.valueOf(result));
                operator = "";
                break;

            case "+", "-", "*", "/":
                num1 = Double.parseDouble(display.getText());
                operator = text;
                display.clear();
                break;

            case "C": // Обработчик для кнопки очистки
                display.clear();
                num1 = 0;
                operator = "";
                break;

            default:
                display.appendText(text);
        }
    }
}
