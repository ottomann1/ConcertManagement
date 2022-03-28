package com.example.databasefxx.CRUD.Create;

import Business.Address;
import Business.Customer;
import DAO.AddressDAO;
import DAO.CustomerDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

public class CreateCus {

    @FXML
    private ComboBox<?> cusCreAddress;

    @FXML
    private TextField cusCreDob;

    @FXML
    private TextField cusCreFirstName;

    @FXML
    private TextField cusCreLastName;

    @FXML
    private TextField cusCrePhone;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        List addresses = addressDAO.readAll();
        ObservableList list = FXCollections.observableArrayList(addresses);
        cusCreAddress.setItems(list);
    }
    @FXML
    void cusCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Customer customer = new Customer();
        customer.setFirstName(cusCreFirstName.getText());
        customer.setLastName(cusCreLastName.getText());
        customer.setDob(Date.valueOf(cusCreDob.getText()));
        customer.setPhone(cusCrePhone.getText());
        customer.setAddress((Address) cusCreAddress.getValue());
        CustomerDAO customerDAO = new CustomerDAO();
        customerDAO.create(customer);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

}
