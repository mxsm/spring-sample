FROM openjdk:8
MAINTAINER mxsm
ENV BASE_DIR="/home/springboot"
ADD spring-boot-1.0-SNAPSHOT.jar $BASE_DIR/spring-boot-1.0-SNAPSHOT.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","/home/springboot/spring-boot-1.0-SNAPSHOT.jar"]