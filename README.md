# Java_Tech_Labs - Gherghevici_Iulian

Java Technologies
2024-2025
Laboratory Activity

Projects related to lab activity
Project number according to laboratory number

Student Iulian Gherghevici
Master ISS1-1
Computer Science Faculty
"Alexandru Ioan Cuza" University
Iasi, Romania

Lab 1 - Java Servlet Technology
- Creating a servlet that receives a string and returns an HTML page containing the characters of that string presented as an ordered list. 

Lab 1-2
- Creating a servlet that receives two integers parameters, called numVertices and numEdges, and returns the adjacency matrix of a randomly generated graph with the specified number of vertices and edges.
- Writing in the server log the specified information about each request
- Invoke the servlet from a desktop application (Java)
- The response of the servlet will be, in this case, a simple text representing the adjaceny matrix, in a format at your choice.


Lab 2 - Web Components
- Create a Web application (starting from the previous lab) containing the following components:
input.jsp: a page containing a form for uploading a text file.
FileUploadServlet: a servlet that reads the content of the file and stores into session a collection of its lines.
result.jsp: a page that displays the lines of the file shuffled.

Lab 2-2
- Create a web filter that logs all requests received by input.jsp.
- Create a web listener that reads two properties, named prelude and coda, specified as context init parameters, at the application start-up. These values should be stored in two attributes having application scope.
- Create a web filter that decorates the response by adding the prelude at the beginning and the coda at the end.
- Add a CAPTCHA facility to the input form.

Lab 3 - JavaServer Faces
- Create a Web application using JavaServer Faces technology, dedicated to the Vehicle Routing Problem.
- Consider a Cartesian map, each location of the map having (x,y) coordinates. There is a warehouse located at (0,0) and a number of clients located at random coordinates. In the warehouse, there are products. The clients request one (or more) products from the map, having specific constraints, related to the days and time intervals when they are available to receive their products.
-  Create the following:
    - A relational database in order to store and retrieve data. (PostgreSQL is recommended). You should have at least the table for products, having some predefined data.
    - A JSF project, using Maven.
    - A web page for viewing the products in the database.
    - It is recommended to use an Ajax-based JSF implementation, such as PrimeFaces.

Lab 3 - 2
- Create pages for viewing products and clients using datatables.
- Create a page for adding a new client or editing an existing one, using a dialog.
- Use appropriate components for specifying the properties of a client, such as: DatePicker, SelectOneMenu, PickList, etc.
- Define the web-flow using navigation-rules.
- Internationalize the user interface and offer support for at least two locales. 

