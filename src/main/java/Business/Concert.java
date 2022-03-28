package Business;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table
public class Concert {

    @Id
    @Column(name = "concertId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int concertId;

    @Column(name = "artistName")
    private String artistName;

    @Column(name = "concertDate")
    private Timestamp concertDate;

    @Column(name = "ticketPrice")
    private int ticketPrice;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "arenaId")
    private Arena arena;

    public Concert() {
    }

    public Concert(int concertId, String artistName, Timestamp concertDate, int ticketPrice) {
        this.concertId = concertId;
        this.artistName = artistName;
        this.concertDate = concertDate;
        this.ticketPrice = ticketPrice;
    }

    public String toStringAdv() {
        return "Concert{" +
                "concertId=" + concertId +
                ", artistName='" + artistName + "\n" +
                ", concertDate=" + concertDate + "\n"+
                ", ticketPrice=" + ticketPrice + "\n"+
                ", arena=" + arena +
                '}';
    }

    public int getConcertId() {
        return concertId;
    }

    public void setConcertId(int concertId) {
        this.concertId = concertId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public Date getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(Timestamp concertDate) {
        this.concertDate = concertDate;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(int ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Arena getArena() {
        return arena;
    }

    public void setArena(Arena arena) {
        this.arena = arena;
    }

    @Override
    public String toString() {
        java.sql.Date cdate = new java.sql.Date(concertDate.getTime());
        String stringy = artistName +" (" +cdate+ ") ";
        if (arena!=null)
            stringy+=arena.toString();
        return stringy;
    }
}
