FROM openjdk:17-oracle
EXPOSE 8090
ADD ./target/bootDocker.jar bootDocker.jar
ENTRYPOINT ["java","-jar","bootDocker.jar"]