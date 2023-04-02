def call() {
    script {
        sh 'docker build -t ${FRONTEND_IMAGE_NAME} ./frontend'
        sh 'docker push ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG}'
    }
}