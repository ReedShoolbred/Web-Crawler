Web-Crawler is intended solely as a demo application to implement a REST API and CRUD functionality in a Spring application. 

An more in-depth user guide is currently in the works, but here are the basic instructions to test the application:

1) Download source code.

2) Using the UrlEntity class, set up a database with a field for each mapping found in UrlEntity. (During development, I found it easiest to use MySQL and create an in-memory database).
   
3) Input the database specifications (url, username, password, etc..) in the application.properties file.
   
4) Run the WebCrawlerApplication.java file.

5) You can then use the web-crawler-frontend repository as a basic front end to interact with the Web-Crawler rest endpoints.
