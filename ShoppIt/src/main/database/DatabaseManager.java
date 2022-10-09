package database;

import database.models.FoodItem;
import database.models.Item;
import database.models.ShoppingList;
import jakarta.persistence.NoResultException;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DatabaseManager {
    private Session session;

    public DatabaseManager() {
        Configuration con = new Configuration().configure().addAnnotatedClass(FoodItem.class).addAnnotatedClass(Item.class).addAnnotatedClass(ShoppingList.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(registry);
        session = sessionFactory.openSession();

    }

    public void addObject(Object o) {
        Transaction tx = session.beginTransaction();
        session.persist(o);
        tx.commit();
    }

    public void updateObject(Object o) {
        Transaction tx = session.beginTransaction();
        session.merge(o);
        tx.commit();
    }

    /**
     * @param targetClass
     * @param HQLQuery    For getting all items of a particular class use "FROM classname"
     * @param <T>
     * @return
     */
    public <T> List<T> getFromDatabase(Class<T> targetClass, String HQLQuery) {
        Transaction tx = null;
        List<T> list;

        try {
            tx = session.beginTransaction();
            list = session.createQuery(HQLQuery, targetClass).list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
            list = new ArrayList<>();
        }
        return list;
    }

    public <T> List<T> getAllFromDataBase(Class<T> targetClass) {
        return getFromDatabase(targetClass, "FROM ".concat(targetClass.getSimpleName()));
    }

    public void updateImage(String foodName, String update) {
        List<FoodItem> foodItemObjects = session.createQuery("select f FROM FoodItem f", FoodItem.class).list();
        for (FoodItem item : foodItemObjects) {
            String name = item.getProductName();
            if (name.equals(foodName)) {
                item.setImgFilename(update);
                session.merge(item);
            }
        }
    }
}
