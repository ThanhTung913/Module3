package dao;

import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/MangerUser_MVC_JDBC?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "Thanhtung913";

    private final String INSERT_USER_SQL = "INSERT INTO user(name, email, idCountry) VALUES (?,?,?);";
    private final String SELECT_USER_BY_ID = "SELECT id,name,email,idCountry FROM user WHERE id = ?;";
    private final String SELECT_ALL_USER = "SELECT * FROM user;";
    private final String DELETE_USER_SQL = "DELETE FROM user WHERE id =?;";
    private final String UPDATE_USER_SQL = "UPDATE user SET name = ?, email =?, idCountry =? WHERE id =?;";

    public UserDAO() {
    }

    protected Connection getConnection() throws SQLException, ClassNotFoundException {
        Connection connection = null;
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        return connection;
    }


    @Override
    public void inserUser(User user) throws SQLException, ClassNotFoundException {
        System.out.println(INSERT_USER_SQL);
        Connection connection = getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER_SQL);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getEmail());
        preparedStatement.setInt(3, user.getIdCountry());
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();

    }

    @Override
    public User selectUser(int id) throws SQLException, ClassNotFoundException {

        User user = null;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int idCountry = Integer.parseInt(resultSet.getString("idCountry"));
                user = new User(id, name, email, idCountry);
            }

        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> selectAllUsers() throws SQLException, ClassNotFoundException {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                int idCountry = Integer.parseInt(resultSet.getString("idCountry"));
                users.add(new User(id, name, email, idCountry));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    @Override
    public boolean deleteUser(int id) throws SQLException, ClassNotFoundException {
        boolean rowDelete = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_SQL);
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }

        return rowDelete;
    }

    @Override
    public boolean updateUser(User user) throws SQLException, ClassNotFoundException {
        boolean rowUpdate = false;
        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_SQL);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setInt(3, user.getIdCountry());
            preparedStatement.setInt(4, user.getId());
            rowUpdate = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            printSQLException(e);
        }

        return rowUpdate;
    }

    @Override
    public List<User> searchUser(String name) {

        return null;
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
