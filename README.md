# Mini Java Microservices Project

## Services
- **User Service** (Port 8081): Manages user data
- **Order Service** (Port 8082): Manages orders and calls User Service

## Quick Start
1. Run `start-services.bat` to start both services
2. Test endpoints:
   - GET http://localhost:8081/users - All users
   - GET http://localhost:8081/users/1 - Specific user
   - POST http://localhost:8081/login - User login (username/password)
   - GET http://localhost:8082/orders - All orders
   - GET http://localhost:8082/orders/1 - Order with user details

## Login Credentials
- admin/admin123
- user1/pass123
- user2/pass456

## Manual Start
```bash
# Terminal 1
cd user-service
mvn spring-boot:run

# Terminal 2  
cd order-service
mvn spring-boot:run
```