package org.example.fifthlab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TextFlag extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // Создаем группы RadioButton для каждой полосы флага
        ToggleGroup topGroup = new ToggleGroup();
        ToggleGroup middleGroup = new ToggleGroup();
        ToggleGroup bottomGroup = new ToggleGroup();

        // Радиокнопки для верхней полосы
        RadioButton redTop = new RadioButton("Красный");
        RadioButton blueTop = new RadioButton("Синий");
        RadioButton whiteTop = new RadioButton("Белый");
        redTop.setToggleGroup(topGroup);
        blueTop.setToggleGroup(topGroup);
        whiteTop.setToggleGroup(topGroup);

        // Радиокнопки для средней полосы
        RadioButton greenMiddle = new RadioButton("Зелёный");
        RadioButton yellowMiddle = new RadioButton("Жёлтый");
        RadioButton blackMiddle = new RadioButton("Чёрный");
        greenMiddle.setToggleGroup(middleGroup);
        yellowMiddle.setToggleGroup(middleGroup);
        blackMiddle.setToggleGroup(middleGroup);

        // Радиокнопки для нижней полосы
        RadioButton pinkBottom = new RadioButton("Розовый");
        RadioButton purpleBottom = new RadioButton("Фиолетовый");
        RadioButton orangeBottom = new RadioButton("Оранжевый");
        pinkBottom.setToggleGroup(bottomGroup);
        purpleBottom.setToggleGroup(bottomGroup);
        orangeBottom.setToggleGroup(bottomGroup);

        // Кнопка для рисования флага
        Button drawButton = new Button("Нарисовать");

        drawButton.setOnAction(e -> {
            // Получаем выбранные цвета для каждой полосы
            String topColor = ((RadioButton) topGroup.getSelectedToggle()).getText();
            String middleColor = ((RadioButton) middleGroup.getSelectedToggle()).getText();
            String bottomColor = ((RadioButton) bottomGroup.getSelectedToggle()).getText();

            // Формируем сообщение
            String message = "Вы выбрали флаг: " + topColor + ", " + middleColor + ", " + bottomColor;

            // Отображаем сообщение в модальном окне
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message, ButtonType.OK);
            alert.setTitle("Цвет флага");
            alert.showAndWait();
        });

        // Размещаем элементы в сетке
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setHgap(10);
        grid.setVgap(10);

        // Добавляем радиокнопки на форму
        grid.add(new Label("Верхняя полоса:"), 0, 0);
        grid.add(redTop, 1, 0);
        grid.add(blueTop, 2, 0);
        grid.add(whiteTop, 3, 0);

        grid.add(new Label("Средняя полоса:"), 0, 1);
        grid.add(greenMiddle, 1, 1);
        grid.add(yellowMiddle, 2, 1);
        grid.add(blackMiddle, 3, 1);

        grid.add(new Label("Нижняя полоса:"), 0, 2);
        grid.add(pinkBottom, 1, 2);
        grid.add(purpleBottom, 2, 2);
        grid.add(orangeBottom, 3, 2);

        // Добавляем кнопку на форму
        grid.add(drawButton, 1, 3, 3, 1);

        // Устанавливаем сцену и отображаем окно
        stage.setScene(new Scene(grid));
        stage.setTitle("Текстовый флаг");
        stage.setResizable(false); // Запрещаем изменение размера окна
        stage.show();
    }
}
