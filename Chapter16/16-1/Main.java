import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane bp = new BorderPane();
        HBox radiobuttons = new HBox();

        RadioButton red = new RadioButton("Red");
        red.setSelected(true);

        RadioButton yellow = new RadioButton("Yellow");
        RadioButton black = new RadioButton("Black");
        RadioButton orange = new RadioButton("Orange");
        RadioButton green = new RadioButton("Green");


        radiobuttons.getChildren().addAll(red,yellow,black,orange,green);
        radiobuttons.setAlignment(Pos.CENTER);
        radiobuttons.setSpacing(7);
        bp.setTop(radiobuttons);


        Pane textpane = new Pane();
        Label label = new Label("Programming is fun");
        label.setLayoutY(40);
        Font font = new Font(32);
        label.setFont(font);
        label.setTextFill(Color.RED);
        textpane.getChildren().add(label);
        bp.setCenter(textpane);


        HBox buttons = new HBox();

        Button leftbutton = new Button("<-");
        Button rightbutton = new Button("->");

        buttons.getChildren().addAll(leftbutton,rightbutton);

        bp.setBottom(buttons);


        red.setOnAction(e -> {
            yellow.setSelected(false);
            black.setSelected(false);
            orange.setSelected(false);
            green.setSelected(false);

            label.setTextFill(Color.RED);
        });

        yellow.setOnAction(e -> {
            red.setSelected(false);
            black.setSelected(false);
            orange.setSelected(false);
            green.setSelected(false);

            label.setTextFill(Color.YELLOW);
        });

        black.setOnAction(e -> {
            yellow.setSelected(false);
            red.setSelected(false);
            orange.setSelected(false);
            green.setSelected(false);

            label.setTextFill(Color.BLACK);
        });

        orange.setOnAction(e -> {
            yellow.setSelected(false);
            black.setSelected(false);
            red.setSelected(false);
            green.setSelected(false);

            label.setTextFill(Color.ORANGE);
        });

        green.setOnAction(e -> {
            yellow.setSelected(false);
            black.setSelected(false);
            orange.setSelected(false);
            red.setSelected(false);

            label.setTextFill(Color.GREEN);
        });

        leftbutton.setOnAction(e -> {
            label.setLayoutX(label.getLayoutX() - 30);
            if (label.getLayoutX() < 0) {
                label.setLayoutX(0);
            }
        });

        rightbutton.setOnAction(e -> {
            label.setLayoutX(label.getLayoutX() + 30);
            if (label.getLayoutX() > 500 - label.getWidth()) {
                label.setLayoutX(500 - label.getWidth());
            }
        });

        Scene scene = new Scene(bp, 500, 150);
        primaryStage.setTitle("16-1");
        primaryStage.setScene(scene);
        primaryStage.show();




    }

    public static void main(String[] args) {

        launch(args);
    }
}
