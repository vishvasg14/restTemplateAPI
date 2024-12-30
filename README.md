# Internal API Middleware Service

A Spring Boot middleware application that facilitates communication between multiple APIs. It validates user credentials, generates tokens, fetches user email details, and acts as a bridge between services.

---

## 🌟 Features

- **Login API**: Validates user credentials and generates a token.
- **Email Service API**: Fetches user email details and additional data using a token.
- Token-based authentication support.
- Middleware functionality to connect and manage API interactions.

---

## 🚀 Technologies Used

- **Java**: Programming language.
- **Spring Boot**: Framework for building RESTful APIs.
- **Lombok**: To reduce boilerplate code in DTOs.
- **Maven**: Dependency management.
- **REST APIs**: For handling HTTP requests and responses.

---

## ⚙️ Endpoints

### 1. **Login API**

**Endpoint**: `POST /api/login`

#### Request Body:
{
  "username": "admin",
  "password": "password"
}
Response:
json
 
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
plaintext
 
Authorization: mock-token-12345
Response:
json
 
{
  "userEmail": "user@example.com",
  "accessToken": "mock-token-12345",
  "someData": "some-data"
}
Description:
Accepts an Authorization header with or without the Bearer prefix.
Validates the token and returns user email details, access token, and additional data.
🛠️ Setup Instructions
Prerequisites
JDK 17 or higher
Maven 3.6 or higher
Steps to Run
Clone the Repository:

bash
 
git clone <repository-url>
cd <repository-folder>
Build the Project:

bash
 
mvn clean install
Run the Application:

bash
 
mvn spring-boot:run
Access the APIs:

Login API: http://localhost:8081/api/login
Email Service API: http://localhost:8081/api/emailservice
🧪 Example Requests
1. Login API:
POST http://localhost:8081/api/login

Request Body:
json
 
{
  "username": "admin",
  "password": "password"
}
Response:
json
 
{
  "username": "admin",
  "token": "mock-token-12345"
}
2. Email Service API:
GET http://localhost:8081/api/emailservice

Request Header:
plaintext
 
Authorization: mock-token-12345
Response:
json
 
{
  "userEmail": "user@example.com",
  "accessToken": "mock-token-12345",
  "someData": "some-data"
}
⚙️ Configuration
Port Configuration
To change the default port, update the application.properties file:

properties
 
server.port=8081
