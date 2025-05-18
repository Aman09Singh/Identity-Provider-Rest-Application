# Rest Application working as an Identity Provider

This app will allow you to create a JWT Token after authenticating the user.  
It will check whether a user exists in the database and if present, it will give you the authentication header. 

### Technology Used 
**Java 21  
Spring 3.4.5  
MySQL 8.0.42** 

### APIs available
For authentication - `http://localhost:8080/auth/validate`  
For adding a user - `http://localhost:8080/save`  
For deleting a user with email - `http://localhost:8080/delete/{email}`  


