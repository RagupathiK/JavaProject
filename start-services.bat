@echo off
echo Starting User Service...
start "User Service" cmd /k "cd user-service && mvn spring-boot:run"

timeout /t 5

echo Starting Order Service...
start "Order Service" cmd /k "cd order-service && mvn spring-boot:run"

echo Services starting...
echo User Service: http://localhost:8081
echo Order Service: http://localhost:8082