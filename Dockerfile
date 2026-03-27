# ===================================================
# Dockerfile - DevOps E-Commerce Application
# Base Image: eclipse-temurin:17-jdk (Java 17)
# ===================================================

# Use official Java 17 image
FROM eclipse-temurin:17-jdk

# Set working directory inside container
WORKDIR /app

# Copy the built JAR file into container
COPY target/ecommerce-0.0.1-SNAPSHOT.jar app.jar

# Expose application port
EXPOSE 9090

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
