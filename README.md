🚚 E-Commerce Shipping Charge System (Jumbotail Inspired)

A scalable backend system built using Spring Boot, implementing:
📦 Dynamic Shipping Charge Calculation
🏭 Nearest Warehouse Detection
🚚 Strategy-Based Transport Selection
🔐 JWT-Based Authentication
🗄️ MySQL / PostgreSQL Support
🧩 Clean Layered Architecture

📌 Problem Statement

Given:
Seller location
Warehouse locations
Customer location
Delivery speed

The system calculates accurate shipping charges based on:
Distance
Transport mode (MiniVan / Truck / Aeroplane)
Weight
Delivery speed (Standard / Express)

🧠 High-Level Design (HLD)

JWT-secured REST APIs
Role-based access
Distance-based transport selection
Strategy Pattern for pricing logic
Modular microservice-friendly design

🔍 Low-Level Design (LLD)
📦 Core Entities
User
Seller
Customer
Warehouse
Product
DeliverySpeed (Enum)

🛠️ Tech Stack
Layer	Technology
Backend	:Spring Boot 3
Security	:Spring Security + JWT
Database	:MySQL / PostgreSQL
ORM	:Spring Data JPA
Build Tool	:Maven
Testing	:Postman
Architecture	:Layered + Strategy Pattern

🔐 Authentication
JWT-based stateless authentication
BCrypt password encryption

📡 API Endpoints
1)/api/auth/public/register    POST REQUEST
2)/api/auth/public/login       POST REQUEST
3)/api/v1/warehouse/nearest?sellerId=1   GET REQUEST
4)/api/v1/shipping-charge?warehouseId=2&customerId=1&deliverySpeed=STANDARD   GET REQUEST
5)/api/v1/shipping-charge/calculate    POST REQUEST

API TESTING DEMO:

<img width="1919" height="1049" alt="Screenshot 2026-02-18 142623" src="https://github.com/user-attachments/assets/3b70f858-1499-4cb6-8f61-7c5566116fbe" />
<img width="1917" height="1068" alt="Screenshot 2026-02-18 142633" src="https://github.com/user-attachments/assets/91403a9a-571c-4b0b-a58f-0bb3aa7b84d5" />
<img width="1919" height="1078" alt="Screenshot 2026-02-18 142645" src="https://github.com/user-attachments/assets/f2b97f70-806f-484b-a24f-f9eb2250b6c2" />
<img width="1919" height="1081" alt="Screenshot 2026-02-18 142654" src="https://github.com/user-attachments/assets/da11710d-fdb8-4c64-8255-84f9291debb3" />
<img width="1919" height="1088" alt="Screenshot 2026-02-18 142707" src="https://github.com/user-attachments/assets/c57dcfa1-e279-4f28-9315-9bbc5ab895ac" />


🧪 Testing via Postman
1)Register user
2)Login to get JWT token
3)Add Bearer token in Authorization header
4)Call shipping APIs

👨‍💻 Author
Vishesh Unadkat
Backend Developer | Spring Boot Enthusiast | Problem Solver
