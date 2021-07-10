# JPACRUDProject

### Overview
This is a full stack Java application and implements web-based C.R.U.D. functionality, utilizing Spring MVC and the DAO pattern. The DAO implementation uses JDBC to persist and retrieve data through MySQL.

### Functionality
A user can enter a Film's ID and see the details of the film in a web page. If the film is not found, they see an appropriate message. When a film's details are displayed, it's actors and categories are also listed.
A user can choose to add a new film. They can enter all the properties of the film. Their input will be used to create Film object, which the DAO implementation will save in the database. If the insert fails, the user is informed of this.
When a user retrieves a film, they have the option of deleting it. If they delete the film, it is removed from the database. If the delete fails (such as, due to child records), the user is informed of this.
When a user retrieves a film, they have the option of editing it. If they choose this, all the film's current properties are displayed in a form, allowing them to change any property except the film's ID. When they submit the form, that film's record is updated in the database. If the update fails, the user is informed of this.
A user can search for films by keyword/pattern in title or description. From the resulting list of films, the user can choose to update or delete a record.

### Technologies Used
- Java 1.8
- HTML, CSS, XML
- Bootstrap
- Spring Tool Suite & Spring Boot
- Gradle
- MySQL & MySQL Workbench
- JDBC
- MAMP
- Apache Tomcat 8.5
- AWS EC2

### How to Run
This full stack Java application runs on an Apache Tomcat webserver. User can interact with the application through online navigation.
To host your own instance, you are going to need a similar webserver that implements Java servlet containers. We recommend importing the program to Eclipse IDE, and installing a Tomcat instance within Eclipse to run locally.

### Lessons Learned
Java web applications consist of multiple systems communicating with each other, manipulating the data and forwarding it to other services or pages. The MVC design pattern is a very good framework for developing scalable web applications.

### EER Diagram
![EERDiagram](https://user-images.githubusercontent.com/83374176/123504132-bc31c380-d614-11eb-8844-aebbae35b5b1.png)
