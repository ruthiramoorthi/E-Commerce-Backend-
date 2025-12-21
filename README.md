# 🛒 E-Commerce Backend – Spring Boot

## 📌 Project Overview

This project is a **backend REST API for an E-Commerce application** built using **Spring Boot**. It handles core e-commerce functionalities such as **user management, product management, cart operations, and order processing**. The project follows **clean architecture**, **RESTful principles**, and uses **JPA/Hibernate** for database interaction.

This project is ideal for **learning and showcasing Spring Boot backend development skills**.

---

## 🚀 Features

* User registration & authentication
* Product CRUD operations
* Category management
* Cart management (add/remove/update items)
* Order placement
* Order history
* Role-based access (Admin / User)
* Exception handling
* Validation
* RESTful APIs

---

## 🧰 Tech Stack

* **Java** (17+ recommended)
* **Spring Boot**
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL / H2 Database
* Maven
* Lombok
* Postman (for API testing)

---

## 🏗️ Project Structure

```
E-Commerce-Backend
│
├── controller        # REST Controllers
├── service           # Service interfaces
├── serviceImpl       # Service implementations
├── repository        # JPA Repositories
├── entity            # JPA Entities
├── dto               # Data Transfer Objects
├── exception         # Custom Exceptions & Global Handler
├── config            # Configuration classes
└── ECommerceApplication.java
```

---

## 🗄️ Database Design (Main Entities)

### User

* id
* name
* email
* password
* role

### Product

* id
* name
* description
* price
* stock
* category

### Cart

* id
* user
* items

### CartItem

* id
* cart
* product
* quantity

### Order

* id
* user
* orderItems
* totalPrice
* orderDate
* status

---

## 🔑 API Endpoints (Sample)

### User APIs

| Method | Endpoint            | Description   |
| ------ | ------------------- | ------------- |
| POST   | /api/users/register | Register user |
| POST   | /api/users/login    | Login user    |

### Product APIs

| Method | Endpoint           | Description         |
| ------ | ------------------ | ------------------- |
| POST   | /api/products      | Add product (Admin) |
| GET    | /api/products      | Get all products    |
| GET    | /api/products/{id} | Get product by ID   |
| PUT    | /api/products/{id} | Update product      |
| DELETE | /api/products/{id} | Delete product      |

### Cart APIs

| Method | Endpoint                  | Description      |
| ------ | ------------------------- | ---------------- |
| POST   | /api/cart/add             | Add item to cart |
| DELETE | /api/cart/remove/{itemId} | Remove item      |
| GET    | /api/cart                 | View cart        |

### Order APIs

| Method | Endpoint          | Description   |
| ------ | ----------------- | ------------- |
| POST   | /api/orders/place | Place order   |
| GET    | /api/orders       | Order history |

---

## ⚙️ Configuration

### application.properties

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

server.port=8080
```

---

## ▶️ How to Run the Project

1. Clone the repository

   ```bash
   git clone https://github.com/your-username/e-commerce-backend.git
   ```

2. Open in IDE (IntelliJ / Eclipse / VS Code)

3. Configure database in `application.properties`

4. Run the application

   ```bash
   mvn spring-boot:run
   ```

5. Access APIs at

   ```
   http://localhost:8080
   ```

---

## 🧪 Testing

* Use **Postman** or **Swagger** (if enabled)
* Validate request/response JSON
* Test error scenarios (product not found, cart empty, etc.)

---

## 🛑 Exception Handling

* Custom exceptions (e.g., `ProductNotFoundException`, `CartNotFoundException`)
* Global exception handler using `@ControllerAdvice`

---

## 📈 Future Enhancements

* JWT Authentication
* Payment Gateway Integration
* Wishlist feature
* Pagination & Sorting
* Swagger API Documentation
* Docker support

---

## 👨‍💻 Author

**Rooth Rooth**
Java & Spring Boot Developer

---

## ⭐ Contribution

Contributions are welcome! Fork the repo, create a feature branch, and submit a pull request.

---

## 📄 License

This project is for learning purposes. You may use and modify it freely.
