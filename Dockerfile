FROM maven as build
WORKDIR /code
COPY . /code/
RUN mvn package

FROM openjdk:8-jre
EXPOSE 8080
WORKDIR /app
COPY --from=build /code/simple-typescript-interpreter-web/target/simple-typescript-interpreter-web.jar .
CMD java -jar simple-typescript-interpreter-web.jar
