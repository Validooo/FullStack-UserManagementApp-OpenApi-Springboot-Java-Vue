<h1><a href= "https://validooo.github.io/FullStack-UserManagementApp-OpenApi-Springboot-Java-Vue/"> Link to website</a></h1>






<p>The project allows users to create contacts and manage them. It utilizes the OpenAPI Generator plugin to generate REST API classes in Java from a YAML file where the REST API endpoints are defined. The generated classes are subsequently implemented with self-written components (Controller, Service, Entity, Repository). We have employed Spring Boot to manage our dependencies, import the OpenAPI Generator plugin, and facilitate database generation. The frontend is constructed using Vue and is presented as a single-page application encompassing two routes (Userlist and AddEditUser).</p>

<h2> Steps to follow: </h2>

* Install Npm, Vue Cli, Java
* To run the Vue app, use the command  `npm run serve`.
* Import the Spring Boot backend project into Eclipse or IntelliJ as a Maven project.
* Compile the project using Maven to generate the REST API classes.
* Launch the Application

<h2> Notes: </h2>

* The OpenAPI Generator plugin is defined in the pom.xml file.
* The database is configured in the application.properties file.
* The online version uses the store created by Vue's reactive to store the data.
* The YAML file is located in the resources folder.

  <h2>Reference: </h2>
* This project used the following tutorial as a reference: https://medium.com/swlh/vue3-using-ref-or-reactive-88d47c8f6944.

<h2>Screenshots</h2>

<b>1- User list</b>

<img src="pictures/users-home.png" >

<b>2- Add new User</b>
<img src="pictures/add-new-user.png" >

<b>3-Update User Details</b>
<img src="pictures/update-user-by-id.png" >

<b>4-User Updated</b>
<img src="pictures/user-updated.png" >

<b>5-User Deleted</b>
<img src="pictures/delete-user.png" >
