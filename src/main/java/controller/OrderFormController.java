package controller;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.dto.*;
import service.ServiceFactory;
import service.custom.CustomerService;
import service.custom.OrderService;
import service.custom.ProductService;
import util.CurrentUser;
import util.DateTime;
import util.ServiceType;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    List<CartDTO> cart = new ArrayList<>();

    private CustomerService customerService = ServiceFactory.getInstance().getServiceType(ServiceType.CUSTOMER);

    private ProductService productService = ServiceFactory.getInstance().getServiceType(ServiceType.PRODUCT);

    private OrderService orderService = ServiceFactory.getInstance().getServiceType(ServiceType.ORDER);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DateTime.loadDateAndTime(txtDate);

        loadCustomerIDs();
        loadProductIDs();
        setOrderID();

        cmbCustomerID.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVal, newVal) -> {
            setValuesToCustomerFields((String) newVal);
        });

        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observableValue, oldVal, newVal) -> {
            setValuesToProductFields((String) newVal);
        });

        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescription.setCellValueFactory(new PropertyValueFactory<>("Description"));
        colQTY.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitprice"));
        colTotal.setCellValueFactory(new PropertyValueFactory<>("total"));

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

    private void clearCustomFields(){

        txtItemName.clear();
        txtUnitPrice.clear();
        txtQTYOnHand.clear();
        txtQTY.clear();
    }

    private void calNetTotal(){
        Double netTtotal = 0.0;

        for (CartDTO item : cart){
            netTtotal+=item.getTotal();
        }
        txtTotalPrice.setText(String.valueOf(netTtotal));
    }

    private void setOrderID(){
        try {
            int lastID = orderService.getOrderId();
            int newID = lastID + 1;
            txtOrderId.setText(String.valueOf(newID));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void btnAddOnAction(ActionEvent event) {
        String qtyText = txtQTY.getText();

        // Check for empty or invalid input
        if (qtyText == null || qtyText.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Quantity is required").show();
            return;
        }

        try {
            int qty = Integer.parseInt(qtyText);

            if (qty > 0) {
                String itemCode = (String) cmbItemCode.getValue();
                String name = txtItemName.getText();
                double unitPrice = Double.parseDouble(txtUnitPrice.getText());
                double total = qty * unitPrice;

                cart.add(new CartDTO(itemCode, name, qty, unitPrice, total));
                tblOrder.setItems(FXCollections.observableArrayList(cart));

                calNetTotal();
                clearCustomFields();


            } else {
                new Alert(Alert.AlertType.ERROR, "Quantity must be 0 or greater").show();
                txtQTY.clear();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid number for quantity").show();
        }



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
    void btnPlaceOrderOnAction(ActionEvent event){

        Long orderID = Long.valueOf(txtOrderId.getText());
        String customerID = null;
        try {
            customerID = cmbCustomerID.getValue().toString();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"Please select Customer ID").show();
        }
        String employeeID = String.valueOf(CurrentUser.getCurrentUser().getId());
        String employeeName = CurrentUser.getCurrentUserName();
        String date = txtDate.getText();
        Double total = Double.valueOf(txtTotalPrice.getText());

        List<OrderItemDTO> orderDetails = new ArrayList<>();

        cart.forEach(cartItem -> {
            orderDetails.add(new OrderItemDTO(
                    orderID,
                    Integer.parseInt(cartItem.getId()),
                    cartItem.getDescription(),
                    cartItem.getQty(),
                    cartItem.getUnitprice(),
                    cartItem.getTotal()));
        });

       OrderDTO order = new OrderDTO(orderID,customerID,employeeID,employeeName,total,date,orderDetails);
        try {
            orderService.addOrder(order);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        setOrderID();
       clearCustomFields();
       txtCustomerName.clear();
       cart.clear();
       tblOrder.setItems(FXCollections.observableArrayList(cart));


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
