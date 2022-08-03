package controller;

import dao.CountryDAO;
import dao.ICountryDAO;
import models.Country;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "CountryServlet", urlPatterns = "/countryServlet")
public class CountryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public static ICountryDAO IcountryDAO;

    public void init() {
        IcountryDAO = new CountryDAO();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "create":
                    showNewForm(req, resp);
                    break;
                case "edit":
                    showEditForm(req, resp);
                    break;
                case "delete":
                    deleteCountry(req, resp);
                    break;
                default:
                    listCountry(req, resp);
                    break;
            }
        } catch (SQLException | ClassNotFoundException exception) {
            throw new ServletException(exception);
        }

    }

    private void listCountry(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        List<Country> listCountry = IcountryDAO.selectAllCountry();
        req.setAttribute("listCountry", listCountry);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void deleteCountry(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        IcountryDAO.deleteCountry(id);

        List<Country> listCountry = IcountryDAO.selectAllCountry();
        req.setAttribute("listCountry", listCountry);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country/list.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Country country = IcountryDAO.selectCountryById(id);
        req.setAttribute("country", country);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country/edit.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = " ";
        }
        try {
            switch (action) {
                case "edit":
                    editCountry(req, resp);
                    break;
                case "create":
                    insertCountry(req, resp);
                    break;
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    private void insertCountry(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String name = req.getParameter("name");
        Country newCountry = new Country(name);
        newCountry.setName(name);

        IcountryDAO.insertCountry(newCountry);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country/create.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void editCountry(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ClassNotFoundException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Country updateCountry = new Country(id, name);

        IcountryDAO.updateCountry(updateCountry);

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/country/edit.jsp");
//        requestDispatcher.forward(req, resp);

        resp.sendRedirect("/countryServlet");
    }
}
