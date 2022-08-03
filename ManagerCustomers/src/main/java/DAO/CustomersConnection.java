//package DAO;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//
//public class CustomersConnection {
//    private final String jdbcURL = "jdbc:mysql://localhost:3306/CustomerManager?useSSL=false";
//    private final String jdbcUserName = "root";
//    private final String jdbcPassword = "Thanhtung913";
//    private final String SQL_SELECT_CUSTOMER = "SELECT id,name,email,address FROM Customers";
//
//    protected Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            connection = DriverManager.getConnection(jdbcURL, jdbcUserName, jdbcPassword);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return connection;
//    }
//}a
