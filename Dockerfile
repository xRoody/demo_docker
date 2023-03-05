



FROM openjdk:17

WORKDIR /app

COPY .mvn/ .mvn

COPY mvnw pom.xml ./

RUN ./mvnw dependency:resolve

COPY src ./src

EXPOSE 8081

ENTRYPOINT ["./mvnw"]

CMD ["spring-boot:run"]