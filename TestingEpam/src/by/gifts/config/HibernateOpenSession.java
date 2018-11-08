package by.gifts.config;

import org.hibernate.Session;

public class HibernateOpenSession {
    /**
     * Get session
     *
     * @return {@link Session}
     */
    public static Session getSession() {
        return HibernateConfig.buildSessionFactory().openSession();
    }
}