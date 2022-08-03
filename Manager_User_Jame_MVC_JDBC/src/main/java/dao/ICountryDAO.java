package dao;

import models.Country;

import java.sql.SQLException;
import java.util.List;

public interface ICountryDAO {
    void insertCountry(Country country) throws SQLException, ClassNotFoundException;

    Country selectCountryById(int id) throws SQLException, ClassNotFoundException;

    List<Country> selectAllCountry() throws SQLException, ClassNotFoundException;

    boolean deleteCountry(int id) throws SQLException, ClassNotFoundException;

    boolean updateCountry(Country country) throws SQLException, ClassNotFoundException;
}
