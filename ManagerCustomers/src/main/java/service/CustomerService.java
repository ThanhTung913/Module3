package service;

import models.Customers;

import java.util.List;

public interface CustomerService {
    List<Customers> findAll();

    void save(Customers customers);

    Customers findByid(int id);

    void edit(int id, Customers customers);

    void delete(int id);

}
