FROM openjdk:17-jdk-alpine

WORKDIR /app

COPY target/qrscanner-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 9090

ENTRYPOINT ["java","-jar","/app/app.jar"]

#ENTRYPOINT ["./wait-for-it.sh", "mysql:3306", "--", "./wait-for-it.sh", "elasticsearch:9200", "--", "java", "-jar", "/app/app.jar"]

## Copy the wait-for-it.sh script into the container
#COPY wait-for-it.sh /wait-for-it.sh
#
## Make the wait-for-it.sh script executable
#RUN chmod +x /wait-for-it.sh

#ENTRYPOINT ["sh", "-c", "sleep 30 && /wait-for-it.sh mysql:3307 -- /wait-for-it.sh elasticsearch:9201 -- java -jar /app/app.jar"]


# Copy wait-for-it script
#COPY wait-for-it.sh /app/wait-for-it.sh
RUN #chmod +x /app/wait-for-it.sh















#FROM openjdk:17-jdk-alpine
#WORKDIR /app
#COPY target/qrscanner-0.0.1-SNAPSHOT.jar /app/app.jar
# Expose the port your Spring Boot app runs on (e.g., 9090)
#EXPOSE 9090
#ENTRYPOINT ["java","-jar","/app/app.jar"]