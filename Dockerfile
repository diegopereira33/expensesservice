# For Java 8, try this
# FROM openjdk:8-jdk-alpine

# For Java 11, try this
FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/expensesService-0.0.1-SNAPSHOT.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/expensesService-0.0.1-SNAPSHOT.jar /opt/app/appExpenses.jar
COPY ${JAR_FILE} appExpenses.jar

# java -jar /opt/app/appExpenses.jar
ENTRYPOINT ["java","-jar","appExpenses.jar"]