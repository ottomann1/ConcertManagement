package com.example.databasefxx.CRUD.Read;

import Business.Arena;
import Business.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.IOException;

public class ReadAre {

    @FXML
    private TextArea cusRead;

    public void setValues(Arena arena){
        cusRead.setText(arena.toStringAdv());
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
