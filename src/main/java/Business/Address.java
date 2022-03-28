package Business;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @Column(name = "addressId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "streetName")
    private String streetName;

    @Column(name = "streetNumber")
    private String streetNumber;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "county")
    private String county;

    @OneToMany (mappedBy = "address", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<Customer> customers = new ArrayList<Customer>();

    public Address() {
    }



    public Address(int addressId, String streetName, String streetNumber, String postalCode, String county) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.county = county;
    }

    public Address(int addressId, String streetName, String streetNumber, String postalCode, String county, Collection<Customer> customers) {
        this.addressId = addressId;
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.county = county;
        this.customers = customers;
    }

    public String toStringAdv() {
        return "Address{" +
                "addressId=" + addressId +
                ", streetName='" + streetName + "\n" +
                ", streetNumber='" + streetNumber + "\n" +
                ", postalCode='" + postalCode + "\n" +
                ", county='" + county + "\n" +
                ", customers=" + customers +
                '}';
    }

    @Override
    public String toString() {
        return streetName+" "+streetNumber+" "+postalCode+" "+county;
    }

    public Collection<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Collection<Customer> customers) {
        this.customers = customers;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }
}
