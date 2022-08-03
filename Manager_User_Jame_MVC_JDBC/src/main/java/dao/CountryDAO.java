package dao;

import models.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CountryDAO implements ICountryDAO {

    public CountryDAO() {
    }

    private String jdbcURL = "jdbc:mysql://localhost:3306/MangerUser_MVC_JDBC?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Thanhtung913";

    private final String INSERT_COUNTRY_SQL = "INSERT INTO country(name) VALUES (?);";
    private final String SELECT_COUNTRY_BY_ID = "SELECT name FROM country WHERE id = ?;";
    private final String SELECT_ALL_COUNTRY = "SELECT * FROM country;";
    private final String DELETE_COUNTRY_SQL = "DELETE FROM country WHERE id =?;";
    private final String UPDATE_COUNTRY_SQL = "UPDATE country SET name = ? WHERE id =?;";


    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }

    @Override
    public void insertCountry(Country country) throws SQLException, ClassNotFoundException {
        try {
            System.out.println(INSERT_COUNTRY_SQL);
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_COUNTRY_SQL);
            preparedStatement.setString(1, country.getName());
            System.out.println(this.getClass() + "inserCountry" + preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }


        //Statement : dùng câu query không tham số
        //PrepareStatement: dùng câu query có tham số
        //CallableStatement: dùng cho câu StoreProcesdure
        //executeUpdate: thực thi các câu query INSERT, UPDATE, DELETE trả về mẫu tin bị ảnh huởng vởi sql

    }

    @Override
    public Country selectCountryById(int id) throws SQLException, ClassNotFoundException {
        Country country = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNTRY_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(this.getClass() + "selectCountryById: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                country = new Country(id, name);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return country;
    }

    @Override
    public List<Country> selectAllCountry() throws SQLException, ClassNotFoundException {
        List<Country> listCountry = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_COUNTRY);

            System.out.println(this.getClass() + "selectAllCountry: " + preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                listCountry.add(new Country(id, name));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return listCountry;
    }

    @Override
    public boolean deleteCountry(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_COUNTRY_SQL);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowDelete;
    }

    @Override
    public boolean updateCountry(Country country) throws SQLException, ClassNotFoundException {
        boolean rowUpdate = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_COUNTRY_SQL);
            preparedStatement.setString(1, country.getName());
            preparedStatement.setInt(2, country.getId());

            System.out.println(this.getClass() + "updateCountry: " + preparedStatement);
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }
        return rowUpdate;
    }

    private void printSQLException(SQLException exception) {
        for (Throwable e : exception) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = exception.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
