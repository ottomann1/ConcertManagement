package com.example.databasefxx.CRUD.Create;

import Business.Concert;
import Business.Customer;
import Business.Ticket;
import DAO.CustomerDAO;
import DAO.ConcertDAO;
import DAO.TicketDAO;
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
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

public class CreateTic {

    @FXML
    private ComboBox<?> ticCreConcert;

    @FXML
    private ComboBox<?> ticCreCustomer;

    @FXML
    private TextField ticCrePurchaseDate;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        ConcertDAO concertDAO = new ConcertDAO();
        List concerts = concertDAO.readAll();
        ObservableList list = FXCollections.observableArrayList(concerts);
        ticCreConcert.setItems(list);
        CustomerDAO customerDAO = new CustomerDAO();
        List customers = customerDAO.readAll();
        ObservableList list2 = FXCollections.observableArrayList(customers);
        ticCreCustomer.setItems(list2);
    }

    @FXML
    void ticCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Ticket ticket = new Ticket();
        ticket.setConcert((Concert) ticCreConcert.getValue());
        ticket.setCustomer((Customer) ticCreCustomer.getValue());
        System.out.println("x"+ticCrePurchaseDate.getText()+"x");
        if (!(ticCrePurchaseDate.getText().equals("")))
            ticket.setPurchaseDate(Timestamp.valueOf(ticCrePurchaseDate.getText()));
        else{
            Timestamp timestamp = new Timestamp(Calendar.getInstance().getTime().getTime());
            ticket.setPurchaseDate(timestamp);
        }
        TicketDAO ticketDAO = new TicketDAO();
        ticketDAO.create(ticket);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

}

