def call() {
    script {
        sh 'docker login -u $DOCKER_REGISTRY_USER -p $DOCKER_REGISTRY_PASSWORD'
        sh 'docker build -t ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG} ./frontend'
        sh 'docker push ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG}'
    }
}