def call() {
    script {
        sh 'docker build -t ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG} ./frontend'
        sh 'docker push ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG}'
    }
}