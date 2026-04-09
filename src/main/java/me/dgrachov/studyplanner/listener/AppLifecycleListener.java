package me.dgrachov.studyplanner.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import me.dgrachov.studyplanner.persistence.HibernateSessionManager;

@WebListener
public class AppLifecycleListener implements ServletContextListener {
    @Override
    public void contextDestroyed(ServletContextEvent event) {
        HibernateSessionManager.shutdown();
    }
}
