package com.example.databasefxx.CRUD.Read;

import Business.Customer;
import Business.Ticket;
import DAO.TicketDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class ReadTicTwo {

    @FXML
    private TextArea cusRead;

    public void setValues(Ticket ticket) throws IOException, ClassNotFoundException {
        TicketDAO ticketDAO = new TicketDAO();
        Collection<Ticket> tickets = new ArrayList<Ticket>();
        Ticket originalT = (Ticket) ticketDAO.read(ticket.getTicketId()).get();
        for(Object t:ticketDAO.readAll()){
            Ticket x = (Ticket) t;
            if(x.getConcert().getConcertId()==originalT.getConcert().getConcertId())
                tickets.add(x);
        }
        String output="Customers going to "+ticket.getConcert()+":\n";
        for(Ticket x:tickets){
            output+=x.getCustomer()+"\n";
        }
        cusRead.setText(output);
    }

    @FXML
    void backButton(ActionEvent event) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }
}