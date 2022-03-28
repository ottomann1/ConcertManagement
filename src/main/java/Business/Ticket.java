package Business;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table
public class Ticket {

    @Id
    @Column(name = "ticketId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @Column(name = "purchaseDate")
    private Timestamp purchaseDate;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "concertId")
    private Concert concert;

    public Ticket() {
    }

    public Ticket(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Ticket(int ticketId, Timestamp purchaseDate, Customer customer, Concert concert) {
        this.ticketId = ticketId;
        this.purchaseDate = purchaseDate;
        this.customer = customer;
        this.concert = concert;
    }

    public String toStringAdv() {
        return "Ticket{" +
                "ticketId=" + ticketId + "\n"+
                ", purchaseDate=" + purchaseDate +"\n"+
                ", customer=" + customer +"\n"+
                ", concert=" + concert +
                '}';
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public Timestamp getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Timestamp purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Concert getConcert() {
        return concert;
    }

    public void setConcert(Concert concert) {
        this.concert = concert;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", purchaseDate=" + purchaseDate +
                ", customer=" + customer +
                ", concert=" + concert +
                '}';
    }
}
