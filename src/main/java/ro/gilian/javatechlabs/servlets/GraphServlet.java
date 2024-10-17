/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ro.gilian.javatechlabs.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Logger;

@WebServlet("/generateGraph")
public class GraphServlet extends HttpServlet {

    // Logger for logging request information
    private static final Logger logger = Logger.getLogger(GraphServlet.class.getName());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Log request information
        logRequestInfo(req);

        // Set the response content type to HTML
        resp.setContentType("text/html");

        // Get the parameters numVertices and numEdges from the request
        String numVerticesParam = req.getParameter("numVertices");
        String numEdgesParam = req.getParameter("numEdges");

        // Convert the parameters to integers
        int numVertices = Integer.parseInt(numVerticesParam);
        int numEdges = Integer.parseInt(numEdgesParam);

        // Generate a random adjacency matrix
        int[][] adjacencyMatrix = generateRandomGraph(numVertices, numEdges);

        // Get the PrintWriter to write the response
        PrintWriter out = resp.getWriter();

        // Start writing the HTML output
        out.println("<html>");
        out.println("<head><title>Random Graph</title></head>");
        out.println("<body>");
        out.println("<h1>Adjacency Matrix</h1>");

        // Create a table to represent the adjacency matrix
        out.println("<table border='1'>");
        for (int i = 0; i < numVertices; i++) {
            out.println("<tr>");
            for (int j = 0; j < numVertices; j++) {
                out.println("<td>" + adjacencyMatrix[i][j] + "</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");

        // End the HTML output
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Delegate POST requests to doGet
        doGet(req, resp);
    }

    // Helper method to generate a random graph as an adjacency matrix
    private int[][] generateRandomGraph(int numVertices, int numEdges) {
        // Initialize an empty adjacency matrix
        int[][] matrix = new int[numVertices][numVertices];

        Random random = new Random();

        // Add random edges to the graph
        int edgeCount = 0;
        while (edgeCount < numEdges) {
            int i = random.nextInt(numVertices);
            int j = random.nextInt(numVertices);

            // Avoid self-loops and duplicate edges
            if (i != j && matrix[i][j] == 0) {
                matrix[i][j] = 1;
                matrix[j][i] = 1; // Since it's an undirected graph
                edgeCount++;
            }
        }

        return matrix;
    }

    // Helper method to log request information
    private void logRequestInfo(HttpServletRequest req) {
        String method = req.getMethod();
        String ip = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");
        String language = req.getHeader("Accept-Language");
        String numVertices = req.getParameter("numVertices");
        String numEdges = req.getParameter("numEdges");

        // Log the information to the server log
        logger.info("HTTP Method: " + method);
        logger.info("Client IP: " + ip);
        logger.info("User-Agent: " + userAgent);
        logger.info("Client Language: " + language);
        logger.info("Parameters - numVertices: " + numVertices + ", numEdges: " + numEdges);
    }
}