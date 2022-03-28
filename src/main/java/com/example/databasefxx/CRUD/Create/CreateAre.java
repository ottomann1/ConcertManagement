package com.example.databasefxx.CRUD.Create;

import Business.Address;
import Business.Arena;
import DAO.AddressDAO;
import DAO.ArenaDAO;
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
import java.util.List;

public class CreateAre {

    @FXML
    private ComboBox<?> areCreAddress;

    @FXML
    private TextField areCreArenaName;

    @FXML
    private ComboBox<?> areCreInside;

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        List address = addressDAO.readAll();
        ObservableList list = FXCollections.observableArrayList(address);
        areCreAddress.setItems(list);
        List inside = new ArrayList<Boolean>();
        inside.add(true);
        inside.add(false);
        ObservableList insideList = FXCollections.observableArrayList(inside);
        areCreInside.setItems(insideList);
    }

    @FXML
    void areCreClick(ActionEvent event) throws IOException, ClassNotFoundException {
        Arena arena = new Arena();
        arena.setArenaName(areCreArenaName.getText());
        arena.setAddress((Address) areCreAddress.getValue());
        arena.setInside((boolean) areCreInside.getValue());
        ArenaDAO arenaDAO = new ArenaDAO();
        arenaDAO.create(arena);
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/com/example/databasefxx/sample.fxml"));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

}
