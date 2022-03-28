package DAO;

import Business.Address;
import Business.Customer;
import Database.Data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class AddressDAO implements DAO {

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Address> address = Optional.ofNullable((Address) data.getData(Address.class, (int) id));
        return address;
    }

    @Override
    public List readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> addressObjects = data.getDataListQuery("SELECT * FROM address");
        List<Address> addresses = new ArrayList<Address>();
        for (Object[] o : addressObjects) {
            Address address = new Address((Integer) o[0], o[1].toString(), o[2].toString(), o[3].toString(), o[4].toString());
            address.setAddressId((Integer) o[0]);
            addresses.add(address);
        }
        return addresses;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
        Data data = new Data();
        data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
        Data data = new Data();
        Address a = (Address) oldT;
        data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
        Data data = new Data();
        Address address = (Address) o;
        data.deleteEm(Address.class, address.getAddressId());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
