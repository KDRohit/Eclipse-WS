FROM eclipse-temurin:latest
WORKDIR /app
COPY target/movie_app.war movie_app.war
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/movie_app.war"]