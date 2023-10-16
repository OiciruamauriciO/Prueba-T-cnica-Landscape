FROM openjdk:11-jre-slim
COPY "./target/backend-0.0.1-SNAPSHOT.war" "app.war"
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.war"]