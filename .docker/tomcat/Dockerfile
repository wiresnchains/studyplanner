FROM maven:3.9 AS build

WORKDIR /app

COPY . .

ARG DB_HOST
ARG DB_USER
ARG DB_PASS
ARG DB_NAME
ARG AUTH_SECRET

RUN mkdir -p src/main/resources && \
    printf "hibernate.connection.driver_class=com.mysql.cj.jdbc.Driver\nhibernate.connection.url=jdbc:mysql://%s:3306/%s?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC\nhibernate.connection.username=%s\nhibernate.connection.password=%s\n" \
    "$DB_HOST" "$DB_NAME" "$DB_USER" "$DB_PASS" \
    > src/main/resources/hibernate.properties && \
    printf "auth.secret=%s\n" "$AUTH_SECRET" \
    > src/main/resources/secrets.properties

RUN mvn clean package -DskipTests

FROM tomcat:11.0

COPY --from=build /app/target/studyplanner.war /usr/local/tomcat/webapps/ROOT.war
