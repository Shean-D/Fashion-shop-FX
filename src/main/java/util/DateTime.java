package util;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

    public static void loadDateAndTime(Label txtDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
            String currentTime = LocalDateTime.now().format(formatter);
            txtDate.setText(currentTime);
        }));

        clock.setCycleCount(Timeline.INDEFINITE);
        clock.play();
    }

}
