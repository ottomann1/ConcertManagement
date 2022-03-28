package com.example.databasefxx.CRUD.Update;

import Business.Concert;
import Business.Customer;
import Business.Ticket;
import DAO.ConcertDAO;
import DAO.CustomerDAO;
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
import java.sql.Timestamp;
import java.util.List;

public class UpdateTic {
    private Ticket oldt;

    @FXML
    private ComboBox<Concert> ticCreConcert;

    @FXML
    private ComboBox<Customer> ticCreCustomer;

    @FXML
    private TextField ticCrePurchaseDate;

    public void setValues(Ticket ticket){
        oldt=ticket;
        ticCreConcert.setValue(ticket.getConcert());
        ticCreCustomer.setValue(ticket.getCustomer());
        ticCrePurchaseDate.setText(ticket.getPurchaseDate().toString());
    }

    @FXML
    void ticCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        TicketDAO ticketDAO = new TicketDAO();
        Ticket ticket = (Ticket) ticketDAO.read(oldt.getTicketId()).get();
        ticket.setCustomer(ticCreCustomer.getValue());
        ticket.setConcert(ticCreConcert.getValue());
        ticket.setPurchaseDate(Timestamp.valueOf(ticCrePurchaseDate.getText()));
        ticketDAO.update(ticket, oldt);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }
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
}
