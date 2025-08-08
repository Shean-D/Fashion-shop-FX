package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import util.CurrentUser;

import java.io.IOException;
import java.sql.SQLException;

public class LoginFormController {
    public JFXTextField txtUserName;
    public JFXPasswordField txtPassword;
    Parent root = null;

    public void btnLoginOnAction(ActionEvent actionEvent){


        try {
            Boolean loginCheck = CurrentUser.checkLogin(txtUserName.getText(), txtPassword.getText());
            if(loginCheck){

                root = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
                Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
                stage.show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Username or Password invalid").show();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void lblRegisterOnMouseClicked(MouseEvent mouseEvent) {
        new Alert(Alert.AlertType.ERROR,"Please contact Administrator").show();
    }
}
