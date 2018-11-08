package by.gifts.dao;

import by.gifts.config.HibernateOpenSession;
import by.gifts.model.Items;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ItemsDao {
    /**
     * Write item in database
     *
     * @param items object of {@link Items}
     */
    public void createItem(Items items) {
        Session session = HibernateOpenSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(items);
        transaction.commit();
        session.close();
    }
}
