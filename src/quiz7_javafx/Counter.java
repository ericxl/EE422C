/*
 * EE 422C Fall 2016, Quiz 7
 * Name: Xiaoyong Liang
 * UT EID: XL5432
 * Unique: 16480
 */
package quiz7_javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Counter extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Counter");

        TextField tx = new TextField();
        tx.setText("0");
        tx.setTranslateY(60);

        Button btn = new Button();
        btn.setText("Clicker Me!");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            int current = 0;
            @Override
            public void handle(ActionEvent event) {
                current ++;
                tx.setText("" + current);
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        root.getChildren().add(tx);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}