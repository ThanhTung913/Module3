package controller;

import dao.CountryDAO;
import dao.ICountryDAO;
import dao.UserDAO;
import models.Country;
import models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userServlet", urlPatterns = "/userServlet")
public class UserServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private UserDAO userDAO;
    private ICountryDAO iCountryDAO;

    public void init() {
        userDAO = new UserDAO();
        iCountryDAO = new CountryDAO();

        if (this.getServletContext().getAttribute("listCountry") == null) {
            try {
                this.getServletContext().setAttribute("listCountry", iCountryDAO.selectAllCountry());
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateUser(req, resp);
                    break;
                case "edit":
                    showEditUser(req, resp);
                    break;
                case "delete":
                    deleteUser(req, resp);
                    break;
                default:
                    listUser(req, resp);
                    break;
            }

        } catch (Exception ex) {
            throw new ServletException(ex);
        }


    }

    private void listUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<User> listuser = userDAO.selectAllUsers();
        req.setAttribute("listUser", listuser);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        int id = Integer.parseInt(req.getParameter("id"));
        userDAO.deleteUser(id);

        List<User> userList = userDAO.selectAllUsers();
        req.setAttribute("listUser", userList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showEditUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        User existingUser = (User) userDAO.selectUser(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("views/edit.jsp");
        req.setAttribute("user", existingUser);
        requestDispatcher.forward(req, resp);
    }


    private void showCreateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException, ClassNotFoundException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/create.jsp");
        requestDispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertUser(req, resp);
                    break;
                case "edit":
                    editUser(req, resp);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }

    }

    private void editUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int idCountry = Integer.parseInt(req.getParameter("idCountry"));
        User userUpdate = new User(id, name, email, idCountry);
        userDAO.updateUser(userUpdate);
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/edit.jsp");
//        requestDispatcher.forward(req, resp);
        resp.sendRedirect("/userServlet");
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        int idCountry = Integer.parseInt(req.getParameter("idCountry"));
        User newUser = new User(name, email, idCountry);
        userDAO.inserUser(newUser);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/create.jsp");
        requestDispatcher.forward(req, resp);
    }
}
