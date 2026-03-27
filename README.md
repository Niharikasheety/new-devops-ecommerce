# 🛒 DevOps-Driven E-Commerce Application

A complete **Spring Boot** e-commerce backend deployed through a full **DevOps lifecycle** using Git, Maven, JUnit, Docker, Jenkins, and Kubernetes.

---

## 📌 Project Summary

| Detail | Info |
|---|---|
| App | E-Commerce Product & Order API |
| Language | Java 17 |
| Framework | Spring Boot 3.3.5 |
| Database | MySQL 8 |
| Build Tool | Maven |
| Testing | JUnit 5 |
| Container | Docker |
| CI/CD | Jenkins |
| Orchestration | Docker Compose / Kubernetes |

---

## 🏗️ Project Structure

```
devops-ecommerce/
├── src/
│   ├── main/
│   │   ├── java/com/example/ecommerce/
│   │   │   ├── EcommerceApplication.java
│   │   │   ├── controller/
│   │   │   │   ├── HomeController.java
│   │   │   │   ├── ProductController.java
│   │   │   │   └── OrderController.java
│   │   │   ├── entity/
│   │   │   │   ├── Product.java
│   │   │   │   └── Order.java
│   │   │   ├── repository/
│   │   │   │   ├── ProductRepository.java
│   │   │   │   └── OrderRepository.java
│   │   │   └── service/
│   │   │       ├── ProductService.java
│   │   │       └── OrderService.java
│   │   └── resources/
│   │       └── application.properties
│   └── test/
│       └── EcommerceApplicationTests.java  ← JUnit test cases
├── frontend/
│   └── index.html                          ← Frontend UI
├── k8s/
│   └── deployment.yaml                     ← Kubernetes YAML
├── Dockerfile
├── docker-compose.yml
├── Jenkinsfile
└── pom.xml
```

---

## 🚀 DevOps Lifecycle Phases

### Phase 1 — Development (Spring Boot)
Application built with Spring Boot. Exposes REST APIs for Products and Orders.

### Phase 2 — Database (MySQL)
MySQL database integrated using Spring Data JPA. Tables auto-created by Hibernate.

### Phase 3 — Version Control (Git + GitHub)
```bash
git init
git add .
git commit -m "Initial commit"
git remote add origin https://github.com/YOUR_USERNAME/devops-ecommerce-project.git
git branch -M main
git push -u origin main
```

### Phase 4 — Build Automation (Maven)
```bash
# Clean and build
mvn clean package

# Run tests
mvn test

# Skip tests (for Jenkins)
mvn clean package -DskipTests
```

### Phase 5 — Testing (JUnit 5)
6 test cases covering:
- Product price validation
- Product name not null
- Discount calculation
- Quantity validation
- Product object creation
- Service method validation

```bash
mvn test
```

### Phase 6 — Containerization (Docker)
```bash
# Build Docker image
docker build -t ecommerce-app .

# Run container
docker run -d -p 9090:9090 --name ecommerce-container ecommerce-app

# Check running containers
docker ps

# Check logs
docker logs ecommerce-container
```

### Phase 7 — Multi-Container (Docker Compose)
```bash
# Start all services (MySQL + App)
docker compose up --build

# Run in background
docker compose up -d --build

# Stop all
docker compose down

# Check status
docker compose ps
```

### Phase 8 — CI/CD Pipeline (Jenkins)
Start Jenkins:
```bash
docker run -d --name jenkins \
  -p 8080:8080 -p 50000:50000 \
  -v jenkins_home:/var/jenkins_home \
  -v /var/run/docker.sock:/var/run/docker.sock \
  jenkins/jenkins:lts
```

Fix Docker permission inside Jenkins:
```bash
docker exec -u 0 -it jenkins bash
chmod 666 /var/run/docker.sock
exit
docker restart jenkins
```

Open Jenkins: http://localhost:8080

Pipeline stages:
1. Clone Code from GitHub
2. Build with Maven
3. Run JUnit Tests
4. Build Docker Image
5. Deploy Container (auto-removes old)

### Phase 9 — Kubernetes (Optional)
```bash
# Apply all resources
kubectl apply -f k8s/deployment.yaml

# Check pods
kubectl get pods

# Check services
kubectl get services

# Access app
http://localhost:30090
```

---

## 🌐 API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/` | App status |
| GET | `/health` | Health check |
| GET | `/api/products` | Get all products |
| POST | `/api/products` | Add product |
| PUT | `/api/products/{id}` | Update product |
| DELETE | `/api/products/{id}` | Delete product |
| GET | `/api/orders` | Get all orders |
| POST | `/api/orders` | Place order |
| DELETE | `/api/orders/{id}` | Delete order |

---

## 🔧 Configuration

**application.properties** (for Docker Compose):
```properties
server.port=9090
spring.datasource.url=jdbc:mysql://mysql:3306/ecommerce?createDatabaseIfNotExist=true
spring.datasource.username=root
spring.datasource.password=Niharika@123
spring.jpa.hibernate.ddl-auto=update
```

**For local run** (change `mysql` to `localhost`):
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce?createDatabaseIfNotExist=true
```

---

## 📋 Sample API Requests

**Add Product:**
```json
POST /api/products
{
  "name": "Laptop",
  "description": "Gaming Laptop",
  "price": 75000,
  "quantity": 10,
  "category": "Electronics"
}
```

**Place Order:**
```json
POST /api/orders
{
  "customerName": "Niharika",
  "productName": "Laptop",
  "quantity": 1,
  "totalPrice": 75000
}
```
