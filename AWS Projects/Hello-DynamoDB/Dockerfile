FROM gcr.io/distroless/java17-debian12
WORKDIR /app
COPY target/Hello-Dynamo-DB.war Hello-Dynamo-DB.war
EXPOSE 1010
ENTRYPOINT ["java","-jar","/app/Hello-Dynamo-DB.war"]