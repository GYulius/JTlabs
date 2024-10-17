/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Filter.java to edit this template
 */
package ro.gilian.javatechlabs.filters;


import java.io.CharArrayWriter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.PrintWriter;

@WebFilter("/*") // This filter will apply to all responses
public class ResponseDecoratorFilter implements Filter {

    @Override
    public void doFilter(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        // Custom response wrapper to capture output
        CharResponseWrapper responseWrapper = new CharResponseWrapper(res);

        // Proceed with the request and response
        chain.doFilter(request, responseWrapper);

        // Retrieve prelude and coda from the application context
        String prelude = (String) req.getServletContext().getAttribute("prelude");
        String coda = (String) req.getServletContext().getAttribute("coda");

        // Add prelude, the original response, and coda
        String originalResponseContent = responseWrapper.toString();
        String decoratedContent = (prelude != null ? prelude : "") + 
                                  originalResponseContent + 
                                  (coda != null ? coda : "");

        // Write the decorated content back to the original response
        res.setContentLength(decoratedContent.length());
        res.getWriter().write(decoratedContent);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }

    // Custom HttpServletResponseWrapper to capture response output
    public class CharResponseWrapper extends HttpServletResponseWrapper {
        private CharArrayWriter writer = new CharArrayWriter();

        public CharResponseWrapper(HttpServletResponse response) {
            super(response);
        }

        @Override
        public PrintWriter getWriter() throws IOException {
            return new PrintWriter(writer);
        }

        @Override
        public String toString() {
            return writer.toString();
        }
    }
}