package controller;

import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.dto.CustomerDTO;
import model.dto.ProductDTO;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.ProductService;
import util.DateTime;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public class OrderFormController implements Initializable {

    public TextField txtTotalPrice;
    @FXML
    private ComboBox cmbCustomerID;

    @FXML
    private ComboBox cmbItemCode;

    @FXML
    private TableColumn colDescription;

    @FXML
    private TableColumn colId;

    @FXML
    private TableColumn colQTY;

    @FXML
    private TableColumn colTotal;

    @FXML
    private TableColumn colUnitPrice;

    @FXML
    private TableView tblOrder;

    @FXML
    private TextField txtCustomerName;

    @FXML
    private Label txtDate;

    @FXML
    private TextField txtItemName;

    @FXML
    private Label txtOrderId;

    @FXML
    private TextField txtQTY;

    @FXML
    private TextField txtQTYOnHand;

    @FXML
    private TextField txtUnitPrice;

    @FXML
    private Label txtUsername;

    Parent root = null;

    private CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    private ProductService productService = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTime.loadDateAndTime(txtDate);

        loadCustomerIDs();
        loadProductIDs();

        cmbCustomerID.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVal, newVal) -> {
            setValuesToCustomerFields((String) newVal);
        });

        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVal, newVal) -> {
            setValuesToProductFields((String) newVal);
        });

    }

    private void loadCustomerIDs(){
        try {
            List<String> customerID = customerService.getAllCustomerIDs();
            cmbCustomerID.setItems(FXCollections.observableArrayList(customerID));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setValuesToCustomerFields(String custID){

        try {
            CustomerDTO customer = customerService.findCustomerById(Integer.parseInt(custID));
            txtCustomerName.setText(customer.getName());

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    private void loadProductIDs(){
        try {
            List<String> productIDs = productService.getAllProductIDs();
            cmbItemCode.setItems(FXCollections.observableArrayList(productIDs));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void setValuesToProductFields(String id){

        try {
            ProductDTO product = productService.getProductById(Integer.parseInt(id));
            txtQTYOnHand.setText(String.valueOf(product.getQtyOnHand()));
            txtItemName.setText(product.getProductName());
            txtUnitPrice.setText(String.valueOf(product.getPrice()));

        } catch (SQLException e) {

            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {

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
    void btnDashboardOnAction(ActionEvent event){

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
    void btnLogoutOnAction(ActionEvent event){

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

    }

    @FXML
    void btnPlaceOrderOnAction(ActionEvent event) {

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
    void btnRemoveOnAction(ActionEvent event) {

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
