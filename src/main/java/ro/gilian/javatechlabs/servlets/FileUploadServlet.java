/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package ro.gilian.javatechlabs.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig
public class FileUploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // CAPTCHA Validation
        String captchaAnswer = request.getParameter("captchaAnswer");
        String captchaExpected = (String) request.getSession().getAttribute("captcha");

        if (captchaAnswer == null || !captchaAnswer.equals(captchaExpected)) {
            request.setAttribute("error", "Invalid CAPTCHA");
            request.getRequestDispatcher("input.jsp").forward(request, response);
            return;
        }

        // Retrieve file part and read its content
        Part filePart = request.getPart("file");
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(filePart.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }

        // Store the lines into session
        request.getSession().setAttribute("fileLines", lines);

        // Redirect to result.jsp
        response.sendRedirect("result.jsp");
    }
}