#####################################################################################################################################################
# docker build --rm -t artizan.org/spring-camel:1.0 .
#
# docker build --rm --build-arg http_proxy=$http_proxy -t artizan.org/spring-camel:1.0 .
# 
# docker run -it artizan.org/spring-camel:1.0 sh
# 
#################################################################
FROM alpine:3.12
EXPOSE 8080

RUN apk add openjdk11-jre-headless

RUN mkdir /jars
ADD k8s-camel-spring-first/target/*.jar /jars/
#
RUN mkdir /configs
ADD k8s-camel-spring-first/src/main/resources/PROD-application.properties /configs/application.properties
#
CMD ["java", "-jar", "/jars/k8s-camel-spring-first-1.0-SNAPSHOT.jar", "--spring.config.location=file:///configs/application.properties"]
#################################################################