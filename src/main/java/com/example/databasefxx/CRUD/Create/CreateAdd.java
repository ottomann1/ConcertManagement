package com.example.databasefxx.CRUD.Create;

import Business.Address;
import DAO.AddressDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateAdd {

    @FXML
    private TextField addCreCounty;

    @FXML
    private TextField addCrePostalCode;

    @FXML
    private TextField addCreStreetName;

    @FXML
    private TextField addCreStreetNumber;

    @FXML
    void addCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Address address = new Address();
        address.setStreetName(addCreStreetName.getText());
        address.setStreetNumber(addCreStreetNumber.getText());
        address.setPostalCode(addCrePostalCode.getText());
        address.setCounty(addCreCounty.getText());
        AddressDAO addressDAO = new AddressDAO();
        addressDAO.create(address);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

}