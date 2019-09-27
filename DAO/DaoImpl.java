package com.diabetes.simpleserver.DAO;



import com.diabetes.simpleserver.util.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 * Created by Milamesher on 24.09.2019.
 */
public class DaoImpl<Id, Entity> implements Dao<Id, Entity> {
    @Override
    public Entity getById(Id id) {
        return null;
    }

    @Override
    public void save(Entity entity) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        session.close();
    }

}