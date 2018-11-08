package by.gifts.config;

import by.gifts.model.Gifts;
import by.gifts.model.Items;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateConfig {
    private static SessionFactory sessionFactory = buildSessionFactory();
    private static final Logger LOG = LoggerFactory.getLogger(HibernateConfig.class);

    private HibernateConfig() {
    }

    /**
     * Build and configure session
     *
     * @return {@link SessionFactory}
     * @throws Exception
     */
    public static SessionFactory buildSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                configuration.addAnnotatedClass(Gifts.class);
                configuration.addAnnotatedClass(Items.class);
                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
                sessionFactory = configuration.buildSessionFactory(builder.build());
            } catch (Exception e) {
                LOG.error("Exception: " + e);
            }
        }
        return sessionFactory;
    }
}
