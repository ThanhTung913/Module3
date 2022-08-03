package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "directoryServlet", urlPatterns = "/directory")
public class Directory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, String> directorry = new HashMap<>();
        directorry.put("one", "Một");
        directorry.put("two", "Hai");
        directorry.put("three", "Ba");
        directorry.put("four", "Bốn");
        directorry.put("five", "Năm");

        String search = req.getParameter("search");
        PrintWriter printWriter = resp.getWriter();
        String result = directorry.get(search);
        printWriter.write("<html>");
        if (result != null) {
            printWriter.write("<h1>Word: " + search + " </h1>");
            printWriter.write("<h1>Result: " + result + " </h1>");
        } else {
            printWriter.write("<h1>Not Found </h1>");
        }

        printWriter.write("</html>");
    }
}
