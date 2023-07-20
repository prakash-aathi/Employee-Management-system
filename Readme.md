# Employee Management System
=================


## Installation:
--------------
1. Extract the Zip file
2. Navigate to the project directory: `employee`

## Database Setup:
---------------
1. Create a new database in Mongodb and replace your URL.
2. Update the database configuration in the `application.properties` file.

## Running the Project:
--------------------
1. Build the project: `mvn clean install`
2. Run the application: `mvn spring-boot:run`
3. The application will start running on `http://localhost:8080`.
4. To test endpoints Added swagger `http://localhost:8080/swagger-ui/index.html#/`

## API Endpoints:
--------------
1. Add Employee:
   - Method: POST
   - URL: http://localhost:8080/api/v1/employee 
   - Request Body: JSON structure with the following fields:
   ```
     {    "email": "prakash27@gmail.com","employeeName": "Prakash","phoneNumber": "9710838457", "profileImage": "https://pk.com", "reportsTo": "No One"}
   ```
   
```
{  "email": "akash@gmail.com","employeeName": "akash","phoneNumber": "8923456712","profileImage": "https://ak.com", "reportsTo": "[REPLACE_1ST_RESPONSE_ID]" }
```
     
   - Response: The unique UUID ID of the added employee.
   ```
   "64b54db9d9cb4569e7c5ea1a"
   ```

2. Get All Employees:
   - Method: GET
   - URL: http://localhost:8080/api/v1/employeepage=0&pageSize=10&sortBy=id

   - Response: JSON array of all employees.

3. Delete Employee by ID:
   - Method: DELETE
   - URL: http://localhost:8080/api/v1/employeeid=64b54db9d9cb4569e7c5ea1a

   - Response: ```"Deleted SuccessFully"```

4. Update Employee by ID:
   - Method: PUT
   - URL: http://localhost:8080/api/v1/employee
   - Request Body: JSON structure with the updated employee details (same structure as the "Add Employee" request body)
   - Response: The updated employee details.

5. Get nth Level Manager of an Employee:
   - Method: GET
   - URL: http://localhost:8080/api/v1/employee/reporting?id=64b51c404df3662b795c83a8&level=1
   - Response: The nth level manager of the specified employee.

6. Get Employees with Pagination and Sorting:
   - Method: GET
   - URL: http://localhost:8080/api/v1/employee?page=0&pageSize=10&sortBy=id
   - Response: JSON array of employees based on the pagination and sorting parameters.



