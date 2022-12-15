##Client.java

Here we declare our Client Class using lombook @data function and
@Entity function from Entity framework for Springboot
here we declared Id  for the client information using @GeneratedValue 
To increase the count automatically.

To validate data  we are using javax validation for the email and 
size of data taken from the clients.if they failed to pass the correct
format they cannot save the data in Database.


##ClientCacheConfig Class
here we creating a spring dependency injection for client cache.
with the help of @bean configuration we are creating an instance of the
ClientCacheConfig Class 


##ClientController Class

This is the file where we connect all the java springboot code to front
end  or views of the project.it fetches input data from views  and 
post data in views using @GetMapping and @PostMapping controllers.


##ClientRepository Class


##ClientRestController Class
in this file we returns client data  to the serverside using mapping the get 
post methods.at the end of all methods we return a http address of the specific 
webpage which we want to show the users.


##Schedule Class
In this class we are trying to create a counter method to count client visiting 
the websites. it refresh itself every 3 seconds.


##ScheduleController.java
Here we map the get post results to the views using controller to show in the website.


##FinalProjectApplication.java

Use this File to launch the website and connect to aws database server


src/main/resource/template

This folder contains all the front end files required to complete this
project.Bootstrap is used to give smooth finish to the website.Head  and body
of Html file contains javascript and cdn file to give nice fonts to the website.

##clientform.html

When you click on Add user button in navbar of index file it opens this file 
which allows users to Add client Data of Name, email and Savings for a month.
To save this information in record you click on submit.
it saves the information to aws Mysql database.

##index.html

This page gives intro to the project and presents the idea of project and 
provides links to source code.

##listclients.html

this page shows data retrived from aws Mysql database in tables Client data.

##saved.html

Once you submit the client data without any validation errors it open this page 
and shows success message on the website.

##Application.properties

This file allow us to run an application in different enviroment.
it contains login information of AWS database storage and source 
url for making connection with Mysql database in AWS.


src/test/java/

##ClentControllerTest.java

In this file i have wrote unit test cases for ClientController by using 
spring MockMvc testing framework by using this framework test cases can mock
dependencies.
for example first test is to createClient data which uses mockMvc function to 
behave like client and add data to the form.


##pom.xml

This File is most important file in the project , it contains all the list of
dependencies from springframework to mysql-connector-java.
it also contains the list of used versions of dependencies and properties.

To connect with aws we have used spring-cloud-starter-aws-jdbc dependencies.


