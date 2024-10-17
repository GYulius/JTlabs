/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ro.gilian.javatechlabs.servlets;

/**
 *
 * @author Iul
 */

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CharacterListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        // Get the string parameter from the request
        String inputString = req.getParameter("input");

        // Get the PrintWriter to write the response
        PrintWriter out = resp.getWriter();

        // Start HTML output
        out.println("<html>");
        out.println("<head><title>Character List</title></head>");
        out.println("<body>");
        out.println("<h1>Character List</h1>");

        if (inputString != null && !inputString.isEmpty()) {
            // Create an ordered list of characters
            out.println("<ol>");
            for (char c : inputString.toCharArray()) {
                out.println("<li>" + c + "</li>");
            }
            out.println("</ol>");
        } else {
            out.println("<p>No input string provided!</p>");
        }

        // End HTML output
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Delegate POST requests to doGet
        doGet(req, resp);
    }
}