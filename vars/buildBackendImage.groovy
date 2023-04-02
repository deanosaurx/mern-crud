def call() {
    script {
        withCredentials([usernamePassword(credentialsId: 'DOCKER_HUB', passwordVariable: 'DOCKER_HUB_PASSWORD', usernameVariable: 'DOCKER_HUB_USERNAME')]) {
        sh "docker login -u $DOCKER_HUB_USERNAME -p $DOCKER_HUB_PASSWORD"
        }
        sh 'docker build -t ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG} ./backend'
        sh 'docker push ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG}'
    }
}