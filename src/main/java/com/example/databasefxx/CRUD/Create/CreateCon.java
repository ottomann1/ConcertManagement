package com.example.databasefxx.CRUD.Create;

import Business.Arena;
import Business.Concert;
import DAO.AddressDAO;
import DAO.ArenaDAO;
import DAO.ConcertDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class CreateCon {

    @FXML
    private ComboBox<?> conCreArena;

    @FXML
    private TextField conCreArtistName;

    @FXML
    private TextField conCreDate;

    @FXML
    private TextField conCreTicketPrice;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        ArenaDAO arenaDAO = new ArenaDAO();
        List arenas = arenaDAO.readAll();
        ObservableList list = FXCollections.observableArrayList(arenas);
        conCreArena.setItems(list);
    }

    @FXML
    void conCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Concert concert = new Concert();
        concert.setArtistName(conCreArtistName.getText());
        concert.setConcertDate(Timestamp.valueOf(conCreDate.getText()));
        concert.setTicketPrice(Integer.parseInt(conCreTicketPrice.getText()));
        concert.setArena((Arena) conCreArena.getValue());
        ConcertDAO concertDAO = new ConcertDAO();
        concertDAO.create(concert);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

}

