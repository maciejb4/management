# Person Management Spring Application

## Getting started:
1. Create new MySQL connection with schema
2. Go to src/main/resources/application.properties and update spring.datasource.url to your new schema
3. Add spring.datasource.username and spring.datasource.password to the same file
4. Run ManagementApplication
5. You can now test endpoints on localhost:9191 with tools like Postman:
   - /addPerson (with query body)
   - /findAll
   - /modify (with query body)
   - /persons (with query params)
   - /person/{id}
   - /personByLastName/{lastName}
   - /remove/{personId}
  

Sample Person object to add: 

{
    "type":"INTERNAL",
    "firstName":"Thomas",
    "lastName":"Anderson",
    "mobile":"690100200",
    "email":"test@test1.com",
    "pesel":"90102802645"
}
