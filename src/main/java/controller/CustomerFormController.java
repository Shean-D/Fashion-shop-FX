package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import model.dto.CustomerDTO;
import service.ServiceFactory;
import service.custom.CustomerService;
import util.DateTime;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerFormController implements Initializable {


    @FXML
    private TableColumn colAddress;

    @FXML
    private TableColumn colContactNumber;

    @FXML
    private TableColumn colEmail;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colName;

    @FXML
    private TableView tblCustomers;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContactNumber;

    @FXML
    private Label txtDate;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSearchById;

    @FXML
    private Label txtUsername;

    @FXML
    void btnAddOnAction(ActionEvent event) {

        Boolean added = customerService.addCustomer(new CustomerDTO(
                0,
                txtName.getText(),
                txtAddress.getText(),
                txtContactNumber.getText(),
                txtEmail.getText()
        ));
        if (added) {
            new Alert(Alert.AlertType.INFORMATION,"Customer Added Successfully").show();
            clearFields();
        }else {
            new Alert(Alert.AlertType.ERROR,"Operation failed").show();
        }

    }

    @FXML
    void btnCancelOnAction(ActionEvent event) {
        clearFields();
    }

    Parent root = null;

    CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    private void clearFields(){
        txtId.clear();
        txtName.clear();
        txtAddress.clear();
        txtEmail.clear();
        txtContactNumber.clear();
        txtSearchById.clear();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTime.loadDateAndTime(txtDate);
    }

    public void setValuesToCustomerFields(){
        try {
            CustomerDTO customer = customerService.findCustomerById(Integer.parseInt(txtSearchById.getText()));
            txtId.setText(String.valueOf(customer.getCustomerID()));
            txtName.setText(customer.getName());
            txtAddress.setText(customer.getAddress());
            txtEmail.setText(customer.getEmail());
            txtContactNumber.setText(customer.getContact());

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnCustomersOnAction(ActionEvent event)  {


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
    void btnNewProductsOnAction(ActionEvent event){

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
    void btnOrdersOnAction(ActionEvent event){

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
    void btnProductsOnAction(ActionEvent event){

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
    void btnSearchOnAction(ActionEvent event) {
        setValuesToCustomerFields();
        txtSearchById.clear();
    }

    @FXML
    void btnSuppliersOnAction(ActionEvent event){

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
