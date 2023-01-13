import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javafx.util.Duration;


public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Pane pane = new Pane();
        Circle circle = new Circle(50);

        Polygon pentagon = new Polygon();
        pentagon.getPoints().addAll(new Double[] {
                25.0,80.0,
                100.0,30.0,
                175.0,80.0,
                135.0,155.0,
                65.0,155.0
        });

        pentagon.setFill(Color.WHITE);
        pentagon.setStroke(Color.BLACK);

        circle.setFill(Color.AQUA);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(20,40);
        rectangle.setFill(Color.AQUA);
        rectangle.setStroke(Color.BLACK);

        PathTransition path = new PathTransition();
        path.setDuration(Duration.seconds(5));
        path.setNode(rectangle);
        path.setPath(pentagon);
        path.setCycleCount(Transition.INDEFINITE);
        path.playFromStart();

        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(0.3),rectangle);
        fadeTransition.setFromValue(1.0);
        fadeTransition.setToValue(0.1);
        fadeTransition.setCycleCount(Transition.INDEFINITE);
        fadeTransition.setAutoReverse(true);
        fadeTransition.play();

        RotateTransition rectRotate = new RotateTransition(Duration.seconds(24),rectangle);
        rectRotate.setFromAngle(0);
        rectRotate.setByAngle(99720);
        rectRotate.setCycleCount(Transition.INDEFINITE);
        rectRotate.playFromStart();

        pane.getChildren().add(pentagon);
        pane.getChildren().add(rectangle);
        
        Scene scene = new Scene(pane,200,200);

        scene.setOnMousePressed(e -> {
            rectRotate.pause();
            path.pause();
            fadeTransition.pause();
        });

        scene.setOnMouseReleased(e -> {
            rectRotate.play();
            path.play();
            fadeTransition.play();
        });

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }


}
