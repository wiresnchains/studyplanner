package me.dgrachov.studyplanner.interceptor;

import org.apache.struts2.ActionInvocation;
import org.apache.struts2.interceptor.Interceptor;
import org.hibernate.Transaction;
import me.dgrachov.studyplanner.persistence.HibernateSessionManager;
import me.dgrachov.studyplanner.persistence.dao.DAOFactory;
import me.dgrachov.studyplanner.persistence.dao.hibernate.HibernateDAOFactory;

public class HibernateInterceptor implements Interceptor {
    @Override
    public void init() {
        DAOFactory.setFactory(new HibernateDAOFactory());
    }

    @Override
    public void destroy() {
        DAOFactory.setFactory(null);
    }

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        Transaction tx = null;

        try {
            var session = HibernateSessionManager.getSessionFactory().getCurrentSession();
            tx = session.beginTransaction();

            String result = invocation.invoke();

            tx.commit();

            return result;
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            throw e;
        }
    }
}
