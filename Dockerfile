FROM openjdk:8
ADD target/accounts_mongo.jar accounts_mongo.jar
EXPOSE 7070
ENTRYPOINT ["java", "-jar", "accounts_mongo.jar"]