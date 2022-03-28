package DAO;

import Business.Address;
import Business.Customer;
import Database.Data;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO implements DAO{

    @Override
    public Optional read(long id) throws IOException, ClassNotFoundException {
        Data data = new Data();
        Optional<Customer> customer = Optional.ofNullable((Customer) data.getData(Customer.class, (int) id));
        return customer;
    }
    @Override
    public List<Customer> readAll() throws IOException, ClassNotFoundException {
        Data data = new Data();
        List<Object[]> customerObjects = data.getDataListQuery("SELECT * FROM customer");
        List<Customer> customers = new ArrayList<Customer>();
        for (Object[] o : customerObjects) {
            Customer customer = new Customer((Integer) o[0], o[1].toString(), o[2].toString(), (Date) o[3], o[4].toString());
            customer.setPersonId((Integer) o[0]);
            if (o[5] != null)
                customer.setAddress((Address) data.getData(Address.class, (Integer) o[5]));
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void create(Object o) throws IOException, ClassNotFoundException {
        Data data = new Data();
        data.setData(o);
    }

    @Override
    public void update(Object newT, Object oldT) throws IOException {
        Data data = new Data();
        Customer customer = (Customer) oldT;
        data.updateData(newT);
    }

    @Override
    public void delete(Object o) throws IOException {
        Data data = new Data();
        Customer customer = (Customer) o;
        data.deleteDataQuery("DELETE FROM customer WHERE customerId = "+customer.getPersonId());
        System.out.println("deleted "+customer.getName());
    }

    @Override
    public void deleteAll() throws IOException {

    }
}
