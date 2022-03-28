package DAO;

import Business.Address;
import Business.Concert;
import Business.Customer;
import Business.Ticket;
import Database.Data;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TicketDAO implements DAO{

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Ticket> x = Optional.ofNullable((Ticket) data.getData(Ticket.class, (int) id));
        return x;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
    Data data = new Data();
    List<Object[]> ticketObjects = data.getDataListQuery("SELECT * FROM ticket");
    List<Ticket> tickets = new ArrayList<Ticket>();
        for (Object[] o : ticketObjects) {
        Ticket ticket = new Ticket();
        if(o[0]!=null)
            ticket.setTicketId((Integer) o[0]);
        if(o[1]!=null)
            ticket.setPurchaseDate((Timestamp) o[3]);
        if(o[2]!=null)
            ticket.setCustomer((Customer) data.getData(Customer.class, (Integer) o[1]));
        if(o[3]!=null)
            ticket.setConcert((Concert) data.getData(Concert.class, (Integer)o[2]));
        tickets.add(ticket);
    }
        return tickets;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
        Data data = new Data();
        data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
         Data data = new Data();
         Ticket ticket = (Ticket) oldT;
         data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
        Data data = new Data();
        Ticket ticket = (Ticket) o;
        data.deleteEm(Ticket.class, ticket.getTicketId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
