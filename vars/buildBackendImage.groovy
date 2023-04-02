def call() {
    script {
        sh 'docker login -u $DOCKER_REGISTRY_USER -p $DOCKER_REGISTRY_PASSWORD'
        sh 'docker build -t ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG} ./backend'
        sh 'docker push ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG}'
    }
}