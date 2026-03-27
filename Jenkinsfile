// ===================================================
// Jenkinsfile - DevOps E-Commerce CI/CD Pipeline
// Stages: Clone → Build → Test → Docker → Deploy
// ===================================================

pipeline {
    agent any

    environment {
        APP_NAME = "ecommerce-app"
        CONTAINER_NAME = "ecommerce-container"
        APP_PORT = "9090"
    }

    stages {

        // -----------------------------------------------
        // STAGE 1: Clone Code from GitHub
        // -----------------------------------------------
        stage('Clone Code') {
            steps {
                echo '=== Cloning code from GitHub ==='
                git branch: 'main', url: 'https://github.com/Niharikasheety/devops-ecommerce-project.git'
            }
        }

        // -----------------------------------------------
        // STAGE 2: Build with Maven (skip tests for speed)
        // -----------------------------------------------
        stage('Build Project') {
            steps {
                echo '=== Building project with Maven ==='
                sh 'chmod +x mvnw'
                sh './mvnw clean package -DskipTests'
            }
        }

        // -----------------------------------------------
        // STAGE 3: Run JUnit Tests
        // -----------------------------------------------
        stage('Run Tests') {
            steps {
                echo '=== Running JUnit Test Cases ==='
                sh './mvnw test'
            }
        }

        // -----------------------------------------------
        // STAGE 4: Build Docker Image
        // -----------------------------------------------
        stage('Build Docker Image') {
            steps {
                echo '=== Building Docker Image ==='
                sh "docker build -t ${APP_NAME} ."
            }
        }

        // -----------------------------------------------
        // STAGE 5: Deploy Container (auto-remove old)
        // -----------------------------------------------
        stage('Deploy Container') {
            steps {
                echo '=== Deploying Application Container ==='
                sh """
                    docker rm -f ${CONTAINER_NAME} || true
                    docker run -d -p ${APP_PORT}:${APP_PORT} --name ${CONTAINER_NAME} ${APP_NAME}
                """
            }
        }

    }

    // -----------------------------------------------
    // Post-build notifications
    // -----------------------------------------------
    post {
        success {
            echo '=== PIPELINE SUCCESS: Application deployed at http://localhost:9090 ==='
        }
        failure {
            echo '=== PIPELINE FAILED: Check console output for errors ==='
        }
    }
}
