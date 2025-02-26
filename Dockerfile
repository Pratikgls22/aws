FROM openjdk:17

# Copy the JAR package into the image
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# Expose the application port
EXPOSE 9090

# Run the App
#ENTRYPOINT ["java", "-jar", "/app.jar"]
COPY wait-for-it.sh /wait-for-it.sh

RUN chmod +x /wait-for-it.sh

ENTRYPOINT ["./wait-for-it.sh", "mysql:3306", "--", "java", "-jar", "/app.jar"]




