package com.example.databasefxx.CRUD.Update;

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
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UpdateAdd {

    @FXML
    private TextField addCreCounty;

    @FXML
    private TextField addCrePostalCode;

    @FXML
    private TextField addCreStreetName;

    @FXML
    private TextField addCreStreetNumber;

    private Address olda;

    @FXML
    private ComboBox<Customer> addResident;

//    @FXML void initialize() throws IOException, ClassNotFoundException {
//        CustomerDAO customerDAO = new CustomerDAO();
//        List<Customer> customers = customerDAO.readAll();
//        ObservableList<Customer> obscustomers = FXCollections.observableArrayList(customers);
//        addResident.setItems(obscustomers);
//    }

    public void setValues(Address address){
        olda = address;
        addCreCounty.setText(address.getCounty());
        addCrePostalCode.setText(address.getPostalCode());
        addCreStreetName.setText(address.getStreetName());
        addCreStreetNumber.setText(address.getStreetNumber());
//        addResident.setValue((Customer) olda.getCustomers());
    }

    @FXML
    void addCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        Address address = (Address) addressDAO.read(olda.getAddressId()).get();

        address.setStreetName(addCreStreetName.getText());
        address.setStreetNumber(addCreStreetNumber.getText());
        address.setPostalCode(addCrePostalCode.getText());
        address.setCounty(addCreCounty.getText());
//        Collection<Customer> addCus = address.getCustomers();
//        addCus.add(addResident.getValue());
//        address.setCustomers(addCus);
//        address.setCustomers((Collection<Customer>) addResident.getValue());
        addressDAO.update(address, olda);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

}