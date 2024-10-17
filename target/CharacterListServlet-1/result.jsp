<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.Collections, java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Result</title>
</head>
<body>
    <h2>Shuffled File Lines</h2>

    <%
        List<String> fileLines = (List<String>) session.getAttribute("fileLines");

        if (fileLines != null && !fileLines.isEmpty()) {
            Collections.shuffle(fileLines);

            for (String line : fileLines) {
                out.println("<p>" + line + "</p>");
            }
        } else {
            out.println("<p>No file content available.</p>");
        }
    %>

    <a href="input.jsp">Upload another file</a>
</body>
</html>

