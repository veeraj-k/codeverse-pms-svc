FROM openjdk:21-slim

WORKDIR /pms

COPY . .

EXPOSE 8080

CMD ["./mvnw","spring-boot:run"]