node {
    stage('Clone Git Repository'){
        git clone https://github.com/thiethaa/springboot-h2-jenkins-vs-travis.git
    }
    stage('Maven Build'){
      MAVEN_HOME = tool name: 'Maven', type: 'maven'
      sh "${MAVEN_HOME}/bin/mvn clean install"
    }

    stage('Docker Build'){
        def DOCKER_HOME = tool name: 'Docker', type: 'dockerTool'
        sh """
               ${DOCKER_HOME} login
               ${DOCKER_HOME} build -t jenkins-build-image .
        """
    }
    stage('Docker Push'){
        sh """
             ${DOCKER_HOME} tag jenkins-build-image thiethaa/jenkins-build-image:v.1.0.0
             ${DOCKER_HOME} push thiethaa/jenkins-build-image:v.1.0.0
        """
    }
}