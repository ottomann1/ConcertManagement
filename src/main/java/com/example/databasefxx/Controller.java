package com.example.databasefxx;

import Business.*;
import DAO.*;
import com.example.databasefxx.CRUD.Read.*;
import com.example.databasefxx.CRUD.Update.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Controller {

    @FXML
    private AnchorPane ap;

    @FXML
    private Tab addTab;

    @FXML
    private TableView<Address> addTable;

    @FXML
    private TableColumn<Address, ?> addTableCounty;

    @FXML
    private TableColumn<Address, ?> addTableId;

    @FXML
    private TableColumn<Address, ?> addTablePostalCode;

    @FXML
    private TableColumn<Address, ?> addTableResidents;

    @FXML
    private TableColumn<Address, ?> addTableStreetName;

    @FXML
    private TableColumn<Address, ?> addTableStreetNumber;

    @FXML
    private Tab areTab;

    @FXML
    private TableView<Arena> areTable;

    @FXML
    private TableColumn<Arena, ?> areTableAddress;

    @FXML
    private TableColumn<Arena, ?> areTableArenaName;

    @FXML
    private TableColumn<Arena, ?> areTableConcert;

    @FXML
    private TableColumn<Arena, ?> areTableId;

    @FXML
    private TableColumn<Arena, ?> areTableInside;

    @FXML
    private Tab conTab;

    @FXML
    private TableView<Concert> conTable;

    @FXML
    private TableColumn<Concert, ?> conTableArena;

    @FXML
    private TableColumn<Concert, ?> conTableArtistName;

    @FXML
    private TableColumn<Concert, ?> conTableConcertDate;

    @FXML
    private TableColumn<Concert, ?> conTableId;

    @FXML
    private TableColumn<Concert, ?> conTableTicketPrice;

    @FXML
    private Tab cusTab;

    @FXML
    private TableView<Customer> cusTable;

    @FXML
    private TableColumn<Customer, ?> cusTableAddress;

    @FXML
    private TableColumn<Customer, ?> cusTableBirth;

    @FXML
    private TableColumn<Customer, ?> cusTableId;

    @FXML
    private TableColumn<Customer, ?> cusTableFirstName;

    @FXML
    private TableColumn<Customer, ?> cusTableLastName;

    @FXML
    private TableColumn<Customer, ?> cusTablePhone;

    @FXML
    private TabPane tabPanex;

    @FXML
    private Tab ticTab;

    @FXML
    private TableView<Ticket> ticTable;

    @FXML
    private TableColumn<Ticket, ?> ticTableConcert;

    @FXML
    private TableColumn<Ticket, ?> ticTableCustomer;

    @FXML
    private TableColumn<Ticket, ?> ticTablePurchaseDate;

    @FXML
    private TableColumn<Ticket, ?> ticTableTicketId;


    @FXML
    void initialize() throws IOException, ClassNotFoundException {
        customerLoad();
        addressLoad();
        concertLoad();
        arenaLoad();
        ticketLoad();
    }

    private void arenaLoad() throws IOException, ClassNotFoundException {
        ArenaDAO arenaDAO = new ArenaDAO();
        ArrayList<Arena> arenaList = (ArrayList<Arena>) arenaDAO.readAll();
        ObservableList<Arena> observableArenas = FXCollections.observableArrayList(arenaList);
        areTable.setItems(observableArenas);
        areTableId.setCellValueFactory(new PropertyValueFactory<>("arenaId"));
        areTableArenaName.setCellValueFactory(new PropertyValueFactory<>("arenaName"));
        areTableInside.setCellValueFactory(new PropertyValueFactory<>("inside"));
        areTableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        areTable.setItems(observableArenas);
        areTable.getColumns().setAll(areTableId, areTableArenaName, areTableInside, areTableAddress);
    }

    private void concertLoad() throws IOException, ClassNotFoundException {
        ConcertDAO concertDAO = new ConcertDAO();
        ArrayList<Concert> concertList = (ArrayList<Concert>) concertDAO.readAll();
        ObservableList<Concert> observableConcerts = FXCollections.observableArrayList(concertList);
        conTable.setItems(observableConcerts);
        conTableId.setCellValueFactory(new PropertyValueFactory<>("concertId"));
        conTableArtistName.setCellValueFactory(new PropertyValueFactory<>("artistName"));
        conTableConcertDate.setCellValueFactory(new PropertyValueFactory<>("concertDate"));
        conTableTicketPrice.setCellValueFactory(new PropertyValueFactory<>("ticketPrice"));
        conTableArena.setCellValueFactory(new PropertyValueFactory<>("arena"));
        conTable.setItems(observableConcerts);
        conTable.getColumns().setAll(conTableId, conTableArtistName, conTableConcertDate, conTableTicketPrice, conTableArena);
    }

    private void addressLoad() throws IOException, ClassNotFoundException {
        AddressDAO addressDAO = new AddressDAO();
        Collection<Address> addressList = new ArrayList<>();
        List<Address> addressArray = new ArrayList<Address>();
        addressArray.addAll(addressDAO.readAll());
//        for (int i = addressArray.get(0).getAddressId(); i < addressDAO.readAll().size(); i++) {
        for (Address x:addressArray){
            addressList.add((Address) addressDAO.read(x.getAddressId()).get());
        }
        ObservableList<Address> observableAddresses = FXCollections.observableArrayList(addressList);
        addTable.setItems(observableAddresses);
        addTableId.setCellValueFactory(new PropertyValueFactory<>("addressId"));
        addTableStreetName.setCellValueFactory(new PropertyValueFactory<>("streetName"));
        addTableStreetNumber.setCellValueFactory(new PropertyValueFactory<>("streetNumber"));
        addTablePostalCode.setCellValueFactory(new PropertyValueFactory<>("postalCode"));
        addTableCounty.setCellValueFactory(new PropertyValueFactory<>("county"));
        addTableResidents.setCellValueFactory(new PropertyValueFactory<>("customers"));
        addTable.setItems(observableAddresses);
        addTable.getColumns().setAll(addTableId, addTableStreetName, addTableStreetNumber, addTablePostalCode, addTableCounty, addTableResidents);
    }

    private void customerLoad() throws IOException, ClassNotFoundException {
        CustomerDAO customerDAO = new CustomerDAO();
        ArrayList<Customer> customerList = (ArrayList<Customer>) customerDAO.readAll();
        ObservableList<Customer> observableCustomers = FXCollections.observableArrayList(customerList);
        cusTable.setItems(observableCustomers);
        cusTableId.setCellValueFactory(new PropertyValueFactory<>("personId"));
        cusTableFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        cusTableLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        cusTableBirth.setCellValueFactory(new PropertyValueFactory<>("dob"));
        cusTablePhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        cusTableAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        cusTable.setItems(observableCustomers);
        cusTable.getColumns().setAll(cusTableId, cusTableFirstName, cusTableLastName, cusTableBirth, cusTablePhone, cusTableAddress);
    }

    private void ticketLoad() throws IOException, ClassNotFoundException {
        TicketDAO ticketDAO = new TicketDAO();
        ArrayList<Ticket> ticketList = (ArrayList<Ticket>) ticketDAO.readAll();
        ObservableList<Ticket> observableTickets = FXCollections.observableArrayList(ticketList);
        ticTable.setItems(observableTickets);
        ticTableTicketId.setCellValueFactory(new PropertyValueFactory<>("ticketId"));
        ticTableConcert.setCellValueFactory(new PropertyValueFactory<>("concert"));
        ticTablePurchaseDate.setCellValueFactory(new PropertyValueFactory<>("purchaseDate"));
        ticTableCustomer.setCellValueFactory(new PropertyValueFactory<>("customer"));
        ticTable.setItems(observableTickets);
        ticTable.getColumns().setAll(ticTableTicketId, ticTableConcert, ticTablePurchaseDate, ticTableCustomer);
    }

    @FXML
    void CreateButton(ActionEvent event) throws IOException {
        if (cusTab.isSelected())
            extracted(event, "create.fxml");
        if (conTab.isSelected())
            extracted(event, "createConcert.fxml");
        if (areTab.isSelected())
            extracted(event, "createArena.fxml");
        if (addTab.isSelected())
            extracted(event, "createAddress.fxml");
        if (ticTab.isSelected())
            extracted(event, "createTic.fxml");
    }

    private void extracted(ActionEvent event, String xxx) throws IOException {
        Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource(xxx));
        Scene scene = new Scene(loader.load());
        thisStage.setScene(scene);
        thisStage.show();
    }

    @FXML
    void DeleteButton(ActionEvent event) throws IOException, ClassNotFoundException {
        if(cusTab.isSelected()) {
            Customer customer = cusTable.getSelectionModel().getSelectedItem();
            CustomerDAO customerDAO = new CustomerDAO();
            customerDAO.delete(customer);
            customerLoad();
        }
        if(areTab.isSelected()) {
            Arena arena = areTable.getSelectionModel().getSelectedItem();
            ArenaDAO arenaDAO = new ArenaDAO();
            arenaDAO.delete(arena);
            arenaLoad();
        }
        if(addTab.isSelected()) {
            Address address = addTable.getSelectionModel().getSelectedItem();
            AddressDAO addressDAO = new AddressDAO();
            addressDAO.delete(address);
            addressLoad();
        }
        if(conTab.isSelected()) {
            Concert concert = conTable.getSelectionModel().getSelectedItem();
            ConcertDAO concertDAO = new ConcertDAO();
            concertDAO.delete(concert);
            concertLoad();
        }
        if(ticTab.isSelected()){
            Ticket ticket = ticTable.getSelectionModel().getSelectedItem();
            TicketDAO ticketDAO = new TicketDAO();
            ticketDAO.delete(ticket);
            ticketLoad();
        }
    }

    @FXML
    void ReadButton(ActionEvent event) throws IOException {
           if(cusTab.isSelected()) {
               Customer customer = cusTable.getSelectionModel().getSelectedItem();
               Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               FXMLLoader loader = new FXMLLoader(this.getClass().getResource("readCus.fxml"));
               Scene scene = new Scene(loader.load());
               ReadCus readCus = loader.getController();
               readCus.setValues(customer);
               thisStage.setScene(scene);
               thisStage.show();
           }
        if(conTab.isSelected()) {
            Concert concert = conTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("readCon.fxml"));
            Scene scene = new Scene(loader.load());
            ReadCon readCon = loader.getController();
            readCon.setValues(concert);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(areTab.isSelected()) {
            Arena arena = areTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("readAre.fxml"));
            Scene scene = new Scene(loader.load());
            ReadAre readAre = loader.getController();
            readAre.setValues(arena);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(addTab.isSelected()) {
            Address address = addTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("readAdd.fxml"));
            Scene scene = new Scene(loader.load());
            ReadAdd readAdd = loader.getController();
            readAdd.setValues(address);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(ticTab.isSelected()) {
            Ticket ticket = ticTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("readTic.fxml"));
            Scene scene = new Scene(loader.load());
            ReadTic readTic = loader.getController();
            readTic.setValues(ticket);
            thisStage.setScene(scene);
            thisStage.show();
        }
    }
    @FXML
    private Button readCusButton;

    @FXML
    void ReadCusClick(ActionEvent event) throws IOException, ClassNotFoundException {
        if(ticTab.isSelected()) {
            Ticket ticket = ticTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("readTicTwo.fxml"));
            Scene scene = new Scene(loader.load());
            ReadTicTwo readTicTwo = loader.getController();
            readTicTwo.setValues(ticket);
            thisStage.setScene(scene);
            thisStage.show();
        }
    }

    @FXML
    void UpdateButton(ActionEvent event) throws IOException {
        if(cusTab.isSelected()) {
            Customer customer = cusTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("updateCus.fxml"));
            Scene scene = new Scene(loader.load());
            UpdateCus updateCus = loader.getController();
            updateCus.setValues(customer);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(addTab.isSelected()) {
            Address address = addTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("updateAdd.fxml"));
            Scene scene = new Scene(loader.load());
            UpdateAdd updateAdd = loader.getController();
            updateAdd.setValues(address);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(areTab.isSelected()){
            Arena arena = areTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("updateAre.fxml"));
            Scene scene = new Scene(loader.load());
            UpdateAre updateAre = loader.getController();
            updateAre.setValues(arena);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(conTab.isSelected()){
            Concert concert = conTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("updateCon.fxml"));
            Scene scene = new Scene(loader.load());
            UpdateCon updateCon = loader.getController();
            updateCon.setValues(concert);
            thisStage.setScene(scene);
            thisStage.show();
        }
        if(ticTab.isSelected()){
            Ticket ticket = ticTable.getSelectionModel().getSelectedItem();
            Stage thisStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("updateTic.fxml"));
            Scene scene = new Scene(loader.load());
            UpdateTic updateTic = loader.getController();
            updateTic.setValues(ticket);
            thisStage.setScene(scene);
            thisStage.show();
        }

    }
    @FXML
    void RefreshButton(ActionEvent event) throws IOException, ClassNotFoundException {
        customerLoad();
        addressLoad();
        concertLoad();
        arenaLoad();
        ticketLoad();
    }

}
