def call() {
    script {
        sh 'docker build -t ${BACKEND_IMAGE_NAME} ./backend'
        sh 'docker push ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG}'
    }
}