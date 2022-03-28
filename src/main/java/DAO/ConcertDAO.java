package DAO;

import Business.Address;
import Business.Arena;
import Business.Concert;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConcertDAO implements DAO{
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Concert> concert = Optional.ofNullable((Concert) data.getData(Concert.class, (int) id));
        return concert;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> concertObjects = data.getDataListQuery("SELECT * FROM concert");
        List<Concert> concerts = new ArrayList<Concert>();
        for (Object[] o : concertObjects) {
        Concert concert = new Concert((Integer) o[0], o[1].toString(), (java.sql.Timestamp) o[2], (Integer) o[3]);
            if (o[4] != null)
                concert.setArena((Arena) data.getData(Arena.class, (Integer) o[4]));
        concerts.add(concert);
    }
        return concerts;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
        Data data = new Data();
        data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
        Data data = new Data();
        Concert concert = (Concert) oldT;
        data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
        Data data = new Data();
        Concert concert = (Concert) o;
        data.deleteEm(Concert.class, concert.getConcertId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
