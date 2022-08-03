package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "changeMoneyServlet",urlPatterns = "/changeMoney")
public class ChangeMoney extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float VND = Float.parseFloat(req.getParameter("VND"));
        float USD = Float.parseFloat(req.getParameter("USD"));
        float change = USD * VND;
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("<html>");
        printWriter.write("<h2> Use want to change "+ USD + " USD to VND </h2>");
        printWriter.write("<h2> VND: " + change + "</h2>");
    }
}
