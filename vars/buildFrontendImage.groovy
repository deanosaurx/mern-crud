def call() {
    script {
        withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
        sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
        }
        sh 'docker tag $FRONTEND_IMAGE_NAME $DOCKER_HUB_REPO/$FRONTEND_IMAGE_NAME:latest'
        sh 'docker tag $FRONTEND_IMAGE_NAME $DOCKER_HUB_REPO/$FRONTEND_IMAGE_NAME:${BUILD_NUMBER}'
        sh 'docker build -t ${FRONTEND_IMAGE_NAME} ./frontend'
        sh 'docker push ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG}'
    }
}