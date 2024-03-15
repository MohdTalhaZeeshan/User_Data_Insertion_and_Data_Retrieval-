1.To Complete this task  I have used Java, HTML5, CSS3, JDBC, Servlets, Maven, Eclipse IDE, Apache Tomcat v9, MySQL Database.
2.Now let me explain step by step :

*********************************************             FRONT-END             *********************************************             
3.First we have to install the latest version of Eclipse IDE and add the workspace.
4.After Setting up the workspace we have to choose Java EE perspective and JRE version as 1.8.
5.Open Eclipse and press ctrl+n to create a new project and type maven in search bar.
6.Select maven and select jdk version 1.8  and choose the workspace and archetype as web 1.0.
7.Enter the project name and create the project 
8.Then go to index.jsp we will get an error.
9.To resolve it we have to add library that is apache tomcat v9 in our project as it is a web project so we need server here apache tomcat is server.
10.Click on project open src in that open sub folder main in that folder click on sub folder webapp and create two html files for user registration and fetching the details of user and printing it in table format.
11.We have to save those files with .html extension 
12.Take a form tag and take five input tags for name, emailId,age,date of birth and   submit button.
13.Give styeling using style tag in head section.
14.Similarly create one more file and create a form tag in it take to input tags one for name and other as submit button.
15.Apply styling using style tag in the head tag.
16.Give action attribute in form tag and name attribute in input tags and give method attribute in both files.

*********************************************              BACKEND-MySQL-Database           ********************************************* 
--------------------------------------------------------- MySQL --------------------------------------------------------------------------
1.Create a Database in MySQL software you can use command line or my sql work bench.
2.Create a table in that database.
3.create columns as userId, userName,userEmailId, userAge ,user Date of birth.
4.Add constraints and datatypes for the columns.
5.Then Commit.

-----------------------------------------------------   MIDDLE-END-JAVA--------------------------------------------------------------------
1.Create a package in project in src/main/java folder.
2.In That Package Create two Classes one for Inserting data into MySQL Database by fetching it from the HTML page.
3.Other for Retriving the details using the name from the html file.
4.Create a class for Inserting the Data give a readble class name and this class should extend HttpServlet Class because it will make our application multiThreaded and session featured.
5.In order to do that our class should extend in we will be able to inherit all the properties of that class.
6.This HttpServlet  class is present inside a  package javax.servlet.http which is present in servlet-api jar file this jar file will be in added when we add apache tomcat v9 to our project as it is present in it.
7.We have a lot of methods in httpservlet class like service ,doGet,doPost,doDelete,doTrace etc.
8.Here we will use doPost method because it is secure and does not display the input values in the url bar.
9.We have to give method attribute value as post in the html files otherwise we will get 405 error as method noy found.
10.This method has two arguments which are interface they are HttpServletRequest and HttpServletResponse.
11.Now we have to get the user enterd information into java from the html page so we make use of the method called as getParameter method which is a non-static method present in HttpServletRequest interface.
12.The return type is String.
13.So we ahve to convert it into the desird type beacuse we have age which cannot be in String
14.Now Extract all the values from request object or html input tags by using this method.
15.Now write a query to insert these values into MySQL Database.
16.First we have to make a connection between java and mysql databse this is called as jdbc connection.
17.In driver manager class there is a method called getConnection method to which we have to pass the url of database as value.
18.It returns connection object stored in connection interface.
19.  Now in order to take the query to the databse we have to create a platform.
20 Creation of platform depends on the  type of query like run time valued query or static query here we have run time valued query because we have to take values from the user input so we have to use a method called as 
prepareStatment Method present in connection interface which will return prepared statement object.
21.After that we have to set the values to this method by passing the query as an argument to this method.
22.We have to make this query as an complete query before sending it to the databse.
23.Check wheater the emailId is valued or not and age should be positive if it satisfies then only set the values else throw respective errors.
24.After setting the values by using refernce variable use this method called as executeUpdate method whose return type is int this method will perform write operations and returns no of record that are affected.
25.If result is greater than zero then data inserted successfully else display a message as data not inserted.
26.To print the message or values on the webpage we use the method as getWriter method present in HttpServletResponse interface which returns object of PrintWriter Class.
27.To set properties of tags on web page to given messages we use a method called as setContentType present in response interface we have to pass the value as text/html as value to this method.
28.Now try to run the code we will get an exception as driver not found so now we have to specify to the server the driver we are using so here we use forName method prsent in class name called as Class
to which we have to provide the fully qualified name.
29.Then we have to paste the text of mysqlconnector jar in pom.xml file inside dependicies to over come the driver not found exception and handle other exceptions using try and catch blocks.
30.To configure object of that class we make use of an annotaion i.e is @WebServlet() in which we have to specify a name by double qoutes and forward slash and name.
31.This name should be given as a value to the action attribute present in the form tag so when user clicks submit button then that the server will create an object of that class and gives values present in it to the 
class.
32.Similarly create one more class for retrival of Data here i am retrieving using the name of user.
33.Create same method and get the details from the input boxes or request object and store it in variables.
34.Now write a query to display the details based on the given conditions.
35.Create a connection between java and mysql database using the method mentioned before.
36.Create a platform.
37.Set the values.
38.Complete the query
39.Send It to the database.
40.Here now we use a method called as executeQuery method this method will take query to database and put that query under compilation.
41.Then it executes the query.
42.If result is present then it creates a buffer memory.
43.Note that this memory is a temporary memory.
44.It returns a resultSet object which is stored in ResultSet interface.
45.Now we have to check the data is present in the buffer memory or not.
46.For that we have three methods they are 
i.isBeforeFirst()
ii.next()
iii.last()
47.To print the data first we have to get data if data is present then we use getters method present in ResultSet Interface where we have use object refernce variable to call the methods now we have have to specify the 
column name as an argument to get that values.
48.we have to use the place holders in query string to place of values as they will be given at run time.
49.While setting we use setters present in preparedStaement Interface and we have to pass the index and values we extracted from input boxes.
50.To print in the table format ue table tag and give row tag inside it.
51.To display it in the web page we have to use PrinterWriter Class
52.printer Writer class gets object from getWriter method.
53.Then we have to use setContentType to set properties of tags to values.
54.Add borders to the table and style and Color.
55.If buffer memory is null print appropriate error.
56.Now Save all the files.
57.First open user registration page to insert data into tables.
58.Open html page double click run as server select the server as apache tomcat v9.
59.Page will be Displayed.
60.Enter proper values.
61.Click submit.
62.If we get a proper message.
63.Check the values at backend in MySQL.
64.Similarly open another web page and run on server.
65.Enter the name and see the result and verify at the backend.
