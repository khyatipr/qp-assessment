# Use an official OpenJDK runtime as a base image
FROM openjdk:17-jdk-alpine
# Set the working directory inside the container
WORKDIR /grocery-item

# Copy the packaged JAR file into the container
COPY target/Admin-0.0.1-SNAPSHOT.jar app.jar

# Expose the port that your application will run on
EXPOSE 8081

# Command to run your application
CMD ["java", "-jar", "app.jar"]
