package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Login page");
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/Customer_form.fxml"))));
        stage.show();
    }
}
