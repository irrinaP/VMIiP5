package org.example.fifthlab;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RestaurantOrder extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        CheckBox pizzaCheck = new CheckBox("Пицца (500 руб)");
        CheckBox sushiCheck = new CheckBox("Суши (300 руб)");
        Spinner<Integer> pizzaQty = new Spinner<>(1, 10, 1);
        Spinner<Integer> sushiQty = new Spinner<>(1, 10, 1);

        Button orderButton = new Button("Оформить заказ");
        orderButton.setOnAction(e -> {
            StringBuilder receipt = new StringBuilder("Ваш заказ:\n");
            double total = 0;

            if (pizzaCheck.isSelected()) {
                int qty = pizzaQty.getValue();
                receipt.append("Пицца: ").append(qty).append(" x 500 = ").append(qty * 500).append(" руб\n");
                total += qty * 500;
            }
            if (sushiCheck.isSelected()) {
                int qty = sushiQty.getValue();
                receipt.append("Суши: ").append(qty).append(" x 300 = ").append(qty * 300).append(" руб\n");
                total += qty * 300;
            }
            receipt.append("Итог: ").append(total).append(" руб");

            Alert alert = new Alert(Alert.AlertType.INFORMATION, receipt.toString(), ButtonType.OK);
            alert.setTitle("Чек");
            alert.showAndWait();
        });

        VBox layout = new VBox(10, pizzaCheck, pizzaQty, sushiCheck, sushiQty, orderButton);
        layout.setPadding(new Insets(10));

        stage.setScene(new Scene(layout));
        stage.setTitle("Заказ в ресторане");
        stage.show();
    }
}
