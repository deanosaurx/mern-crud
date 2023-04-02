def call() {
    script {
        withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
        sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
        }
        sh 'docker tag $BACKEND_IMAGE_NAME $DOCKER_HUB_REPO/$BACKEND_IMAGE_NAME:latest'
        sh 'docker tag $BACKEND_IMAGE_NAME $DOCKER_HUB_REPO/$BACKEND_IMAGE_NAME:${BUILD_NUMBER}'
        sh 'docker build -t ${BACKEND_IMAGE_NAME} ./backend'
        sh 'docker push ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG}'
    }
}