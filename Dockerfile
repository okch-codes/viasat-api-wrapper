FROM amazoncorretto:21-alpine-jdk
MAINTAINER okch
COPY build/libs/viasat-api-wrapper-1.0.jar viasat-api-wrapper-1.0.jar
ENTRYPOINT ["java","-jar","/viasat-api-wrapper-1.0.jar"]