package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDao {
    void inserUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> sellectAllUser();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

}
