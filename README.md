# studyplanner

A java web application using the Apache Struts framework.

## Useful information

Your actions are **supposed** to throw unhandled exceptions, they are going to be collected by the `ExceptionInterceptor`.

> Important thing to keep in mind: If your action throws an error, the `HibernateInterceptor` is going to rollback all changes that have occured in the current session, therefore if you **absolutely have** to save something alongisde an exception, this exception has to be handled before it goes outside of the scope of the action.
