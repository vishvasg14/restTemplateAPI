Internal API Middleware Service
This project is a Spring Boot application that acts as a middleware service. It facilitates communication between multiple APIs, processes login requests, and fetches user email information using a token-based flow.

Features
Login API (/api/login): Validates user credentials and generates a token.
Email Service API (/api/emailservice): Accepts a token and returns user email details and additional data.
Middleware service to connect and manage API interactions.
Endpoints
1. Login API
Endpoint: POST /api/login

Request Body:

json
Copy code
{
  "username": "admin",
  "password": "password"
}
Response:

json
Copy code
{
  "username": "admin",
  "token": "mock-token-12345"
}
Description:

Accepts static login credentials (username and password).
Returns a token upon successful authentication.
2. Email Service API
Endpoint: GET /api/emailservice

Headers:

makefile
Copy code
Authorization: Bearer mock-token-12345
or

makefile
Copy code
Authorization: mock-token-12345
Response:

json
Copy code
{
  "userEmail": "user@example.com",
  "accessToken": "mock-token-12345",
  "someData": "some-data"
}
Description:

Accepts an Authorization header with or without the Bearer prefix.
Validates the token and returns user email details, access token, and additional data.
Technologies Used
Java: Programming language.
Spring Boot: Framework for building the application.
Lombok: To reduce boilerplate code for DTOs.
Maven: Dependency management.
REST APIs: To handle HTTP requests and responses.
Setup Instructions
Clone the repository:

bash
Copy code
git clone <repository-url>
cd <repository-folder>
Build the project:

bash
Copy code
mvn clean install
Run the application:

bash
Copy code
mvn spring-boot:run
Access the APIs at:

http://localhost:8081/api/login
http://localhost:8081/api/emailservice
Configuration
Change the Port
Update the application.properties file:

properties
Copy code
server.port=8081
Testing the APIs
Login API
Use Postman or any REST client to send a POST request to /api/login.
Email Service API
Send a GET request to /api/emailservice with the token in the Authorization header.
Example Requests
1. Login API Request:
POST http://localhost:8081/api/login

json
Copy code
{
  "username": "admin",
  "password": "password"
}
2. Email Service API Request:
GET http://localhost:8081/api/emailservice

Header:

makefile
Copy code
Authorization: mock-token-12345
Notes
Replace mock logic with real-world authentication and token validation as needed.
Make sure to handle sensitive data securely in production.
The token should ideally be a JWT or other secure token format.
