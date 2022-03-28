package Business;

import javax.persistence.*;
import java.sql.Date;
import java.util.Calendar;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @Column(name = "customerId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "addressId")
    private Address address;


    public String toStringAdv() {
        return "Customer{" +
                "personId=" + personId +
                ", firstName='" + firstName + "\n" +
                ", lastName='" + lastName + "\n" +
                ", dob=" + dob + "\n"+
                ", phone='" + phone + "\n" +
                ", address=" + address +
                '}';
    }

    public Customer() {
    }

    public Customer(String firstName, String lastName, Date dob, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
    }
    public Customer(int personId, String firstName, String lastName, Date dob, String phone) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
    }
    public Customer(int personId, String firstName, String lastName, Date dob, String phone, Address address) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.phone = phone;
        this.address = address;
    }

    public Address getAddress() {
        if (address!=null)
        return address;
        Address nulladdress = new Address();
        return nulladdress;
    }

    @Override
    public String toString() {
        return firstName +" "+ lastName;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public String getName(){
        return (firstName+" "+lastName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
