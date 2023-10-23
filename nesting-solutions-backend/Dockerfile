# First stage: complete build environment
FROM maven:3.8.6 AS builder

# add pom.xml and source code
ADD nesting-solutions-backend/pom.xml pom.xml
ADD nesting-solutions-backend/src src/

# package jar
RUN mvn clean package

FROM openjdk:17

# Copy the JAR file into the container
COPY --from=builder target/nesting-solutions-0.0.1-SNAPSHOT.jar nesting-solutions-0.0.1-SNAPSHOT.jar

# Expose the application's port (if needed)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "nesting-solutions-0.0.1-SNAPSHOT.jar"]

