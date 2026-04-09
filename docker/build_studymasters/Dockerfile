FROM maven:3.9

ARG DB_HOST
ARG DB_USER
ARG DB_PASS
ARG DB_NAME
ARG AUTH_SECRET

WORKDIR /app

COPY . .

RUN mkdir -p src/main/resources && \
    printf "hibernate.connection.url = jdbc:mysql://%s:3306/%s?useSSL=false&serverTimezone=UTC\nhibernate.connection.username = %s\nhibernate.connection.password = %s\n" \
    "$DB_HOST" "$DB_NAME" "$DB_USER" "$DB_PASS" \
    > src/main/resources/hibernate.properties

RUN printf "auth.secret=%s\n" "$AUTH_SECRET" \
    > src/main/resources/secrets.properties

RUN mvn clean package -DskipTests

RUN mkdir -p /opt/tomcat/webapps && \
    cp target/*.war /opt/tomcat/webapps/
