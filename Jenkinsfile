@Library('devops') _

pipeline {
    agent {
        docker {
            image 'deanosaurx/jenkins-agent:latest'
            args '--user root -v /var/run/docker.sock:/var/run/docker.sock'
        }
    }
    options {
        timestamps()
        buildDiscarder(logRotator(numToKeepStr: '30'))
        disableConcurrentBuilds()
        timeout(time: 10, unit: 'MINUTES')
    }

    environment {
        DOCKER_REGISTRY = "docker.io/deanosaurx"
        FRONTEND_IMAGE_NAME = "frontend"
        BACKEND_IMAGE_NAME = "backend"
        IMAGE_TAG = "${env.BUILD_NUMBER}"
    }

    stages {
        stage('Build Frontend Image') {
            steps {
                buildFrontendImage()
            }
        }

        stage('Build Backend Image') {
            steps {
                buildBackendImage()
            }
        }
    }
}
