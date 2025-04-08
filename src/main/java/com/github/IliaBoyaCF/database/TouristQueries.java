package com.github.IliaBoyaCF.database;

import com.github.IliaBoyaCF.database.entities.Tourist;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class TouristQueries {
    public static List<Tourist> getTourists() {
        try (Session session = SessionFactoryHolder.getSessionFactory().openSession()) {
            Query<Tourist> query = session.createQuery("FROM Tourist", Tourist.class);
            return query.list();
        }
    }

    public static void addNew(Tourist tourist) {
        try (Session session = SessionFactoryHolder.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(tourist);
            transaction.commit();
        }
    }
}
