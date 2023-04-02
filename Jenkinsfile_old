pipeline {
    agent {
        docker {
            image 'deanosaurx/jenkins-agent:latest'
            args  '--user root -v /var/run/docker.sock:/var/run/docker.sock'
            }
        }
    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '30'))
        disableConcurrentBuilds()
        timeout(time: 10, unit: 'MINUTES')
    }
    environment {
        FRONTEND_IMAGE_NAME= 'frontend'
        BACKEND_IMAGE_NAME= 'backend'
        DOCKER_HUB_REPO = 'deanosaurx'
    }
    stages {          
        stage('Docker Login & Build') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
                }
                sh 'docker build -t $FRONTEND_IMAGE_NAME ./frontend'
                sh 'docker build -t $BACKEND_IMAGE_NAME ./backend'
                sh 'docker tag $FRONTEND_IMAGE_NAME $DOCKER_HUB_REPO/$FRONTEND_IMAGE_NAME:latest'
                sh 'docker tag $FRONTEND_IMAGE_NAME $DOCKER_HUB_REPO/$FRONTEND_IMAGE_NAME:${BUILD_NUMBER}'
                sh 'docker tag $BACKEND_IMAGE_NAME $DOCKER_HUB_REPO/$BACKEND_IMAGE_NAME:latest'
                sh 'docker tag $BACKEND_IMAGE_NAME $DOCKER_HUB_REPO/$BACKEND_IMAGE_NAME:${BUILD_NUMBER}'
            }
        }
        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
                    sh "docker push $DOCKER_HUB_REPO/$FRONTEND_IMAGE_NAME:latest"
                    sh "docker push $DOCKER_HUB_REPO/$FRONTEND_IMAGE_NAME:${BUILD_NUMBER}"
                    sh "docker push $DOCKER_HUB_REPO/$BACKEND_IMAGE_NAME:latest"
                    sh "docker push $DOCKER_HUB_REPO/$BACKEND_IMAGE_NAME:${BUILD_NUMBER}"
                }
            }                
        }
        stage('Clean up Docker images') {
            steps {
                sh 'docker image prune -af'
            }
            post {
                always {
                    sh 'docker image prune -af'
                }
            }
        }
    }
}