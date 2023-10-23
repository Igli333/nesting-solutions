# First stage: complete build environment
FROM maven:3.5.0-jdk-8-alpine AS builder

# add pom.xml and source code
ADD ./pom.xml pom.xml
ADD ./src src/

# package jar
RUN mvn clean package

FROM openjdk:17

# Copy the JAR file into the container
COPY --from=builder target/nesting-solutions-0.0.1-SNAPSHOT.jar nesting-solutions-0.0.1-SNAPSHOT.jar

# Expose the application's port (if needed)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "nesting-solutions-0.0.1-SNAPSHOT.jar"]

