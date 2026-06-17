FROM gcr.io/distroless/java17-debian12
WORKDIR /app
COPY target/hello-app-0.0.1.war hello-app.war
EXPOSE 5051
ENTRYPOINT ["java","-jar","/app/hello-app.war"]