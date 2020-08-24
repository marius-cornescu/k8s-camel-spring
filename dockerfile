#####################################################################################################################################################
# Creates pseudo distributed hadoop 2.7.1
#
# docker build --rm -t artizan.org/spring-camel:1.0 .
#
# docker build --rm --build-arg http_proxy=$http_proxy -t artizan.org/spring-camel:1.0 .
# 
# docker run -it artizan.org/spring-camel:1.0 sh
# 
#################################################################
FROM alpine:3.11
EXPOSE 8080

RUN apk add openjdk11

RUN mkdir /jars
ADD target/app.jar /jars/
CMD ["java", "-jar", "/jars/app.jar"]
#################################################################