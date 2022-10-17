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
     * Get a table
     * @param targetClass Class type to be returned
     * @param tableName Table name
     * @return List of attributes of type targetClass from table
     * @param <T>
     */
    public <T> List<T> getTable(Class<T> targetClass, String tableName) {
        return getFromDatabase(targetClass, "FROM " + tableName);
    }
    /**
     * Get a table that is sorted by provided attribute of entity
     * @param targetClass Class type to be returned
     * @param tableName Table name
     * @param  attribute Attribute from the table/entity
     * @return List of attributes of type targetClass from table
     * @param <T>
     */

    public <T> List<T> getTableSorted(Class<T> targetClass, String tableName, String attribute) {
        return getFromDatabase(targetClass, "from " + tableName  + " where order by "+ attribute +" asc");

    }


    /**
     * Get attributes from a table
     * @param targetClass Class type to be returned
     * @param attribute Attribute from the table
     * @param tableName Table name
     * @return List of attributes of type targetClass from table
     * @param <T>
     */
    public <T> List<T> getAttributeList(Class<T> targetClass, String attribute, String tableName) {
        return getFromDatabase(targetClass, "SELECT s." + attribute + " FROM " + tableName + " s");
    }

    /**
     * @param targetClass
     * @param HQLQuery    For getting all items of a particular class use "FROM classname"
     * @param <T>
     * @return
     */
    private <T> List<T> getFromDatabase(Class<T> targetClass, String HQLQuery) {
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

    /**
     * Get a table that is sorted by provided attribute of entity
     * @param targetClass Class type to be returned
     * @param tableName Table name
     * @param  attribute Attribute from the table/entity
     * @return List of attributes of type targetClass from table
     * @param <T>
     */

    public <T> List<T> getTableSorted(Class<T> targetClass, String tableName, String attribute) {
        return getFromDatabase(targetClass, "from " + tableName  + " where order by "+ attribute +" asc");

    }
}
