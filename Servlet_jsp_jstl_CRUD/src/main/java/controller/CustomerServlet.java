package controller;

import dao.CustomerDao;
import model.Customer;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        System.out.println(action);
//        String action = request.getParameter("action");
//        if (action == null) {
//            action = " ";
//        }
        switch (action) {
            case "/new":
                showNewCustomer(request, response);
                break;
            case "/delete":
                deleteCustomerById(request, response);
                break;
            case "/edit":
                break;
            case "/update":
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }


    //    Viết phương thức hiển thị thêm mới customer
    private void showNewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/createCustomerFollow.jsp");
        requestDispatcher.forward(request, response);
    }

    //    Viết phương thức Delete
    private void deleteCustomerById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idCustomer = Integer.parseInt(request.getParameter("id"));
        CustomerDao.deleteCustomer(idCustomer);
        response.sendRedirect("/");
    }

    //    Viết phương thức laays dữ liệu và trả về trang list
    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> listCustomer = CustomerDao.findAllCustomer();
        request.setAttribute("listCustomer", listCustomer);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/index.jsp");
        requestDispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/create":
                createCustomer(request, response);
                break;
        }
    }


    //    Viết phương thức lưu dữ liệu vào data thông qua doPost
    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer checkCustomer = CustomerDao.findById(id);
        if (checkCustomer == null) {
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Customer newCustomer = new Customer(id, name, phone, email);
            CustomerDao.addCustomer(newCustomer);
            response.sendRedirect("/");
        } else {
            String message = "This id  ready exists";
            String name = request.getParameter("name");
            String phone = request.getParameter("phone");
            String email = request.getParameter("email");
            Customer exitsCustomer = new Customer(id, name, phone, email);
            request.setAttribute("message", message);
            request.setAttribute("customer", exitsCustomer);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/customer/createCustomerFollow.jsp");
            requestDispatcher.forward(request, response);
//            Nếu id đã tồn tại thì sẽ trả về lại trang create
        }

    }
}
