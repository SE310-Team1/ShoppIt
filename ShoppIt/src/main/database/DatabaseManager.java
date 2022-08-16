package database;

import database.dataModels.FoodItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private Session session;

    public DatabaseManager() {
        Configuration con = new Configuration().configure().addAnnotatedClass(FoodItem.class);
        ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(con.getProperties()).build();
        SessionFactory sessionFactory = con.buildSessionFactory(registry);
        session = sessionFactory.openSession();

    }

    public void addObject(Object o) {
        Transaction tx = session.beginTransaction();
        session.persist(o);
        tx.commit();
    }
}
