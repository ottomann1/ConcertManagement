package DAO;

import Business.Address;
import Business.Arena;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ArenaDAO implements DAO {
    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Arena> arena = Optional.ofNullable((Arena) data.getData(Arena.class, (int) id));
        return arena;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> arenaObjects = data.getDataListQuery("SELECT * FROM arena");
        List<Arena> arenas = new ArrayList<Arena>();
        for (Object[] o : arenaObjects) {
            Arena arena = new Arena((Integer)o[0], o[1].toString(), (Boolean) o[3]);
            arena.setArenaId((Integer) o[0]);
            if (o[2] != null)
                arena.setAddress((Address) data.getData(Address.class, (Integer) o[2]));
            arenas.add(arena);
        }
        return arenas;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
        Data data = new Data();
        data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
        Data data = new Data();
        Arena arena = (Arena) oldT;
        data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
        Data data = new Data();
        Arena arena = (Arena) o;
        data.deleteEm(Arena.class, arena.getArenaId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
