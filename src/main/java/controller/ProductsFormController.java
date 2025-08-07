package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import util.DateTime;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ProductsFormController implements Initializable {

    @FXML
    private ComboBox cmbProductCategory;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableColumn colQTYOnHand;

    @FXML
    private TableColumn colSupplier;

    @FXML
    private TableColumn colUnitPrice;

    @FXML
    private TableView tblProducts;

    @FXML
    private Label txtDate;

    @FXML
    private Label txtUsername;

    Parent root = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTime.loadDateAndTime(txtDate);
    }

    @FXML
    void btnCustomersOnAction(ActionEvent event){

        try {
            root = FXMLLoader.load(getClass().getResource("/view/Customer_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/view/dashboard_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnNewProductsOnAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/view/New_product_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnOrdersOnAction(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("/view/Order_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnProductsOnAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/view/Products_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event) {

        try {
            root = FXMLLoader.load(getClass().getResource("/view/Supplier_form.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
