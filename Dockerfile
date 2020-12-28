FROM openjdk:8
ADD target/travis-vs-jenkins.jar travis-vs-jenkins.jar
EXPOSE 3030
ENTRYPOINT ["java","-jar","travis-vs-jenkins.jar"]