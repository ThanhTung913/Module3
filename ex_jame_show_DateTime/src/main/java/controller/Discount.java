package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "discountServet", urlPatterns = "/discount")
public class Discount extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("ProductDescription");
        Double price = Double.valueOf(req.getParameter("ListPrice"));
        Double percent = Double.valueOf(req.getParameter("DiscountPercent"));

        Double discountAmount = price * percent * 0.01;
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h2>Description: "+description+"</h2>");
        printWriter.println("<h2> Lượng chiết khấu (Discount Amount): " + percent + " VND   </h2>");
        printWriter.println("<h2> Giá sau khi đã được chiết khấu (Discount Price): " + discountAmount +" VND   </h2>");
        printWriter.println("</html>");
    }
}
