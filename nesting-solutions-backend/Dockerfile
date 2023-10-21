FROM openjdk:17

#Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/nesting-solutions-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the application's port (if needed)
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]

