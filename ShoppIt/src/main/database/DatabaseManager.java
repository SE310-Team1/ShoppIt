package database;

import database.models.FoodItem;
import database.models.Item;
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
        Configuration con = new Configuration().configure().addAnnotatedClass(FoodItem.class).addAnnotatedClass(Item.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(registry);
        session = sessionFactory.openSession();

    }

    public void addObject(Object o) {
        Transaction tx = session.beginTransaction();
        session.persist(o);
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
        } finally {
            session.close();
        }
        return list;
    }

    public <T> List<T> getAllFromDataBase(Class<T> targetClass) {
        return getFromDatabase(targetClass, "FROM ".concat(targetClass.getSimpleName()));
    }


    /**
     * For this method to function correctly all items must have a list ID corresponding to a list
     *
     * @return
     */
    public List<List<Item>> getItems() {
        List<Item> items = getFromDatabase(Item.class, "FROM Item i ORDER BY i.listId");

        List<List<Item>> lists = new LinkedList<>();
        int listCount = 0;
        lists.add(new LinkedList<>());
        for (Item item : items) {
            while (item.getListId() > listCount) {
                lists.add(new LinkedList<>());
                listCount++;
            }
            lists.get(listCount).add(item);
        }
        return lists;
    }

    public void deleteObject(Object o) {
        Transaction tx = session.beginTransaction();
        session.remove(o);
        tx.commit();
    }

}
