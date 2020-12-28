node {
    stage('Clone Git Repository'){
        git 'https://github.com/thiethaa/springboot-h2-jenkins-vs-travis.git'
    }
    stage('Maven Build'){
      MAVEN_HOME = tool name: 'Maven', type: 'maven'
      sh "${MAVEN_HOME}/bin/mvn clean install"
    }

    stage('Docker Build'){
        def DOCKER_HOME = '/usr/local/bin/docker'
        sh """
               echo "docker logging out "
               ${DOCKER_HOME} logout

               echo "logining to docker"
               ${DOCKER_HOME} login

               echo "build image"
               ${DOCKER_HOME} build -t jenkins-build-image .
        """
    }
    stage('Docker Push'){
        def DOCKER_HOME = '/usr/local/bin/docker'
        sh """
             ${DOCKER_HOME} tag jenkins-build-image thiethaa/jenkins-build-image:v.1.0.0
             ${DOCKER_HOME} push thiethaa/jenkins-build-image:v.1.0.0
        """
    }
}