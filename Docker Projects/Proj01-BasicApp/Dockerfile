FROM eclipse-temurin:21-jre

WORKDIR /app

COPY target/Basic_App.war app.war

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.war"]