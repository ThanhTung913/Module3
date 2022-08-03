package controller;

import model.Calculator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "calculatorServlet",urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        float firstOperand = Float.parseFloat(req.getParameter("first-operand"));
        float secondOperand = Float.parseFloat(req.getParameter("second-operand"));
        char operator = req.getParameter("operator").charAt(0);
        PrintWriter printWriter = resp.getWriter();
        printWriter.println("<html>");
        printWriter.println("<h1>Result: ");
        float result = Calculator.calculator(firstOperand,secondOperand,operator);
        printWriter.println(firstOperand + " " + operator + " " + secondOperand + " = " + result);
        printWriter.println("</h1>");
    }
}
