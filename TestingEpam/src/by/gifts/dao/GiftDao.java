package by.gifts.dao;

import by.gifts.config.HibernateOpenSession;
import by.gifts.model.Gifts;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class GiftDao {
    /**
     * Function that create gift in database
     *
     * @param gifts object of {@link Gifts}
     */
    public void createGift(Gifts gifts) {
        Session session = HibernateOpenSession.getSession();
        Transaction transaction = session.beginTransaction();
        session.save(gifts);
        transaction.commit();
        session.close();
    }

    /**
     * Function returns last ID
     *
     * @return {@link Integer} last id
     */
    public int getGiftID() {
        Session session = HibernateOpenSession.getSession();
        Query query = session.createQuery("SELECT max(id) FROM Gifts");
        int ID = Integer.parseInt(query.list().get(0).toString());
        session.close();
        return ID;
    }
}
