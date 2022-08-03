package service;

import models.Customers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServletmImpl implements CustomerService {
    private static Map<Integer, Customers> listCustomers = new HashMap<>();

    static {
        listCustomers.put(1, new Customers(1, "Tung", "tung@gmail.com", "Hue"));
        listCustomers.put(2, new Customers(2, "Nho", "nho@gmail.com", "Hue"));
        listCustomers.put(3, new Customers(3, "Bun", "bun@gmail.com", "Hue"));
        listCustomers.put(4, new Customers(4, "Bo", "bo@gmail.com", "Hue"));
        listCustomers.put(5, new Customers(5, "Miu", "miu@gmail.com", "Hue"));

    }

    @Override
    public List<Customers> findAll() {
        return new ArrayList<>(listCustomers.values());
    }

    @Override
    public void save(Customers customers) {
        listCustomers.put(customers.getId(), customers);
    }

    @Override
    public Customers findByid(int id) {
        return listCustomers.get(id);
    }

    @Override
    public void edit(int id, Customers customers) {
        listCustomers.put(id, customers);
    }

    @Override
    public void delete(int id) {
        listCustomers.remove(id);
    }
}
