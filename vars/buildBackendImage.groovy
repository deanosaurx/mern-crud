def call() {
    script {
        sh 'sudo docker login -u $DOCKER_REGISTRY_USER -p $DOCKER_REGISTRY_PASSWORD'
        sh 'sudo docker build -t ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG} ./backend'
        sh 'sudo docker push ${DOCKER_REGISTRY}/${BACKEND_IMAGE_NAME}:${BACKEND_IMAGE_TAG}'
    }
}