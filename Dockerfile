FROM openjdk:11
ADD target/email-api.jar email-api.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","email-api.jar"]