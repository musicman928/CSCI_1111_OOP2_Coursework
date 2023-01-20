import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.Transition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.sql.Time;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField textbox = new TextField();

        BorderPane pane = new BorderPane();
        pane.setCenter(textbox);

        Scene scene = new Scene(pane,200,200);
        primaryStage.setScene(scene);
        primaryStage.show();
        textbox.setOnAction(e -> {
            BorderPane timerpane = new BorderPane();
            Scene timerscene = new Scene(timerpane,200,200);
            Label timerlabel = new Label();

            timerpane.setCenter(timerlabel);

            final int seconds = Integer.parseInt(textbox.getText());

            timerlabel.setText(String.valueOf(seconds));

            primaryStage.setScene(timerscene);

            Timeline timer = new Timeline();
            timer.getKeyFrames().add(new KeyFrame(Duration.seconds(1)));



            timer.setOnFinished(f -> {
                timerlabel.setText(String.valueOf(Integer.parseInt(timerlabel.getText()) - 1));
                timer.playFromStart();
                if (Integer.parseInt(timerlabel.getText()) == 0) {
                    timer.stop();
                    MediaPlayer ring = new MediaPlayer(new Media("https://memes.co.in/sound-buttons/wp-content/uploads/2023/01/fart-with-reverb-2.mp3"));

                    ring.setCycleCount(Transition.INDEFINITE);
                    ring.play();
                }

            });
            timer.playFromStart();


        });

    }
}
