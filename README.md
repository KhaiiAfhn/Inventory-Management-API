# 📦 Inventory Management API

A professional Spring Boot REST API built with a **3-Tier Architecture** to manage product inventory.

## 🚀 Features
- **RESTful Endpoints:** Full CRUD operations for products (POST, GET).
- **3-Tier Architecture:** Clear separation of concerns (Controller → Service → Repository).
- **Global Exception Handling:** Professional JSON error responses for validation and runtime errors.
- **Secure Configuration:** Uses Environment Variables (`${DB_PASSWORD}`) to protect database credentials.

## 🛠️ Tech Stack
- **Java 21**
- **Spring Boot 3.4.3**
- **Spring Data JPA** (Hibernate)
- **MS SQL Server**
- **Maven**



## 🏗️ Project Structure
- `controller/`: Handles HTTP requests (Receptionist).
- `service/`: Contains business logic and safety checks (Manager).
- `repository/`: Manages database communication via JPA (Butler).
- `model/`: Defines the Product entity and validation rules.
- `exception/`: Global handler for clean API error messages.

## ⚙️ Setup & Installation
1. Clone the repository.
2. Configure your **Environment Variables** in your IDE:
    - `DB_USERNAME`: Your SQL username (e.g., `sa`)
    - `DB_PASSWORD`: Your SQL password
3. Run the application via IntelliJ or Maven: `mvn spring-boot:run`