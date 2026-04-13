# studyplanner

A java web application using the Apache Struts framework.

## Useful information

Your actions are **supposed** to throw unhandled exceptions, they are going to be collected by the `ExceptionInterceptor`.

> Important thing to keep in mind: If your action throws an error, the `HibernateInterceptor` is going to rollback all changes that have occured in the current session, therefore if you **absolutely have** to save something alongisde an exception, this exception has to be handled before it goes outside of the scope of the action.

## Setup

Create a file named `secrets.properties` in `src/main/resources`:

```
auth.secret=example-secret
```

Create a file named `hibernate.properties` in `src/main/resources`:

```
hibernate.connection.url = jdbc:mysql://localhost:3306/studyplanner?useSSL=false&serverTimezone=UTC
hibernate.connection.username = root
hibernate.connection.password =
```

> Don't forget to configure the credentials

## Setup for production

Set your working directory to this repository and run the following commands:

```
chmod +x ./docker/certbot/request-certs.sh
./docker/certbot/request-certs.sh
```

Copy `.env.example` to `.env` and configure all empty values
