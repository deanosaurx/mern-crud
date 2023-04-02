def call() {
    script {
        sh 'sudo docker login -u $DOCKER_REGISTRY_USER -p $DOCKER_REGISTRY_PASSWORD'
        sh 'sudo ocker build -t ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG} ./frontend'
        sh 'sudo docker push ${DOCKER_REGISTRY}/${FRONTEND_IMAGE_NAME}:${FRONTEND_IMAGE_TAG}'
    }
}