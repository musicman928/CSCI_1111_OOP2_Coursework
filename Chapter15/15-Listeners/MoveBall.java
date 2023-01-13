import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;

public class MoveBall extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        HBox hbox = new HBox();
        Circle circle = new Circle(40,50,20);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        Button leftButton = new Button("Left");
        Button rightButton = new Button("Right");
        Button downButton = new Button("Down");
        Button upButton = new Button("Up");

        hbox.getChildren().add(leftButton);
        hbox.getChildren().add(rightButton);
        hbox.getChildren().add(downButton);
        hbox.getChildren().add(upButton);

        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setBottom(hbox);
        BorderPane.setAlignment(hbox, Pos.CENTER);

        Scene scene = new Scene(borderPane, 200, 150);
        primaryStage.setTitle("MOVINGCIRCLEWOW");
        primaryStage.setScene(scene);
        primaryStage.show();

        leftButton.setOnAction(e -> {

            circle.setCenterX(circle.getCenterX() - 10);

            if (circle.getCenterX() < 0 + circle.getRadius()) {
                circle.setCenterX(0 + circle.getRadius());
            }
        });

        rightButton.setOnAction(e -> {
            circle.setCenterX(circle.getCenterX() + 10);

            if (circle.getCenterX() > scene.getWidth() - circle.getRadius()) {
                circle.setCenterX(scene.getWidth() - circle.getRadius());
            }

        });

        upButton.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() - 10);

            if (circle.getCenterY() < 0 + circle.getRadius()) {
                circle.setCenterY(0 + circle.getRadius());
            }
        });

        downButton.setOnAction(e -> {
            circle.setCenterY(circle.getCenterY() + 10);

            if (circle.getCenterY() > scene.getHeight() - circle.getRadius() * 2) {
                circle.setCenterY(scene.getHeight() - circle.getRadius() * 2);
            }
        });
    }

    public static void main(String[] args) {
        launch();
    }

}